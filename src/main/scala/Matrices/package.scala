import common._
import scala.util.Random
import scala.collection.parallel.immutable._

package object Matrices {
  val random = new Random()
  type Matriz = Vector[Vector[Int]]


  def vectorAlAzar(long: Int, vals:Int): Vector[Int] = {
    val v = Vector.fill(long)(random.nextInt(vals))
    v
  }
  def matrizAlAzar(long: Int, vals: Int): Matriz = {
    // Crea una matriz de enteros cuadrada de long x long,
    // con valores aleatorios entre 0 y vals
    val v = Vector.fill(long, long)(random.nextInt(vals))
    v
  }

  def transpuesta(m: Matriz): Matriz = {
    val l = m.length
    Vector.tabulate(l, l)((i, j) => m(j)(i))
  }

  def prodPunto(v1: Vector[Int], v2: Vector[Int]): Int = {
    (v1 zip v2).map { case (i, j) => i * j }.sum
  }

  def prodPuntoParD(v1: ParVector[Int], v2: ParVector[Int]): Int = { // A ser usada en el punto 1.5
    (v1 zip v2).map { case (i, j) => i * j }.sum
  }


  def multMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val l = m1.length
    val m2Transpuesta = transpuesta(m2)
    Vector.tabulate(l, l)((i,j) => prodPunto(m1(i),m2Transpuesta(j)))
  }

  def multMatrizPar(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length
    val mT = task(transpuesta(m2))
    Vector.tabulate(n, n) { (i, j) => prodPunto(m1(i), mT.join()(j)) }
  }


  def subMatriz(m: Matriz, i: Int, j: Int, l: Int): Matriz = {
    Vector.tabulate(l, l) { (a, b) => m(i + a)(j + b) }.take(l)
  }


  def sumMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length
    Vector.tabulate(n, n) { (i, j) => m1(i)(j) + m2(i)(j) }
  }


  def multMatrizRec(m1: Matriz, m2: Matriz): Matriz = {
    // recibe m1 y m2 matrices cuadradas del mismo tamaño, potencia de 2
    // y devuelve la multiplicación de las 2 matrices
    val n = m1.length
    if (n == 1) {
      Vector(Vector(m1(0)(0) * m2(0)(0)))
    } else {
      val m = n / 2
      val a = subMatriz(m1, 0, 0, m)
      val b = subMatriz(m1, 0, m, m)
      val c = subMatriz(m1, m, 0, m)
      val d = subMatriz(m1, m, m, m)
      val e = subMatriz(m2, 0, 0, m)
      val f = subMatriz(m2, 0, m, m)
      val g = subMatriz(m2, m, 0, m)
      val h = subMatriz(m2, m, m, m)

      val ae = multMatrizRec(a, e)
      val bg = multMatrizRec(b, g)
      val af = multMatrizRec(a, f)
      val bh = multMatrizRec(b, h)
      val ce = multMatrizRec(c, e)
      val dg = multMatrizRec(d, g)
      val cf = multMatrizRec(c, f)
      val dh = multMatrizRec(d, h)

      val ae_bg = sumMatriz(ae, bg)
      val af_bh = sumMatriz(af, bh)
      val ce_dg = sumMatriz(ce, dg)
      val cf_dh = sumMatriz(cf, dh)

      val result = Vector.tabulate(n, n) { (i, j) =>
        if (i < m && j < m) {
          ae_bg(i)(j)
        } else if (i < m && j >= m) {
          af_bh(i)(j - m)
        } else if (i >= m && j < m) {
          ce_dg(i - m)(j)
        } else {
          cf_dh(i - m)(j - m)
        }
      }

      result
    }
  }


  def multMatrizRecPar(m1: Matriz, m2: Matriz): Matriz = {
    // recibe m1 y m2 matrices cuadradas del mismo tamaño, potencia de 2
    // y devuelve la multiplicación de las 2 matrices, en paralelo
    val umbralSeq = 16

    if (m1.length <= umbralSeq) {
      multMatrizRec(m1, m2)
    }

    val a = subMatriz(m1, 0, 0, m1.length / 2)
    val b = subMatriz(m1, 0, m1.length / 2, m1.length / 2)
    val c = subMatriz(m1, m1.length / 2, 0, m1.length / 2)
    val d = subMatriz(m1, m1.length / 2, m1.length / 2, m1.length / 2)
    val e = subMatriz(m2, 0, 0, m2.length / 2)
    val f = subMatriz(m2, 0, m2.length / 2, m2.length / 2)
    val g = subMatriz(m2, m2.length / 2, 0, m2.length / 2)
    val h = subMatriz(m2, m2.length / 2, m2.length / 2, m2.length / 2)

    val ae = task(multMatrizRecPar(a, e))
    val bg = task(multMatrizRecPar(b, g))
    val af = task(multMatrizRecPar(a, f))
    val bh = task(multMatrizRecPar(b, h))
    val ce = task(multMatrizRecPar(c, e))
    val dg = task(multMatrizRecPar(d, g))
    val cf = task(multMatrizRecPar(c, f))
    val dh = task(multMatrizRecPar(d, h))

    val ae_bg = sumMatriz(ae.join(), bg.join())
    val af_bh = sumMatriz(af.join(), bh.join())
    val ce_dg = sumMatriz(ce.join(), dg.join())
    val cf_dh = sumMatriz(cf.join(), dh.join())

    val result = Vector.tabulate(m1.length, m1.length) { (i, j) =>
      if (i < m1.length / 2 && j < m1.length / 2) {
        ae_bg(i)(j)
      } else if (i < m1.length / 2 && j >= m1.length / 2) {
        af_bh(i)(j - m1.length / 2)
      } else if (i >= m1.length / 2 && j < m1.length / 2) {
        ce_dg(i - m1.length / 2)(j)
      } else {
        cf_dh(i - m1.length / 2)(j - m1.length / 2)
      }
    }

    result
  }

  // Ejercicio 1.3.1
  def restaMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val l1 = m1.length
    Vector.tabulate(l1, l1) { (i, j) => m1(i)(j) - m2(i)(j) }
  }

  // Ejercicio 1.3.2
  def multStrassen(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length

    if (n == 1) {
      Vector(Vector(m1(0)(0) * m2(0)(0)))
    } else {
      val m = n / 2

      val a = subMatriz(m1, 0, 0, m)
      val b = subMatriz(m1, 0, m, m)
      val c = subMatriz(m1, m, 0, m)
      val d = subMatriz(m1, m, m, m)

      val e = subMatriz(m2, 0, 0, m)
      val f = subMatriz(m2, 0, m, m)
      val g = subMatriz(m2, m, 0, m)
      val h = subMatriz(m2, m, m, m)

      val p1 = multStrassen(a, restaMatriz(f, h))
      val p2 = multStrassen(sumMatriz(a, b), h)
      val p3 = multStrassen(sumMatriz(c, d), e)
      val p4 = multStrassen(d, restaMatriz(g, e))
      val p5 = multStrassen(sumMatriz(a, d), sumMatriz(e, h))
      val p6 = multStrassen(restaMatriz(b, d), sumMatriz(g, h))
      val p7 = multStrassen(restaMatriz(a, c), sumMatriz(e, f))

      val r1 = sumMatriz(restaMatriz(sumMatriz(p5, p4), p2), p6)
      val r2 = sumMatriz(p1, p2)
      val r3 = sumMatriz(p3, p4)
      val r4 = restaMatriz(restaMatriz(sumMatriz(p1, p5), p3), p7)

      val result = Vector.tabulate(n, n) { (i, j) =>
        if (i < m && j < m) {
          r1(i)(j)
        } else if (i < m && j >= m) {
          r2(i)(j - m)
        } else if (i >= m && j < m) {
          r3(i - m)(j)
        } else {
          r4(i - m)(j - m)
        }
      }

      result
    }
  }


  // Ejercicio 1.3.3
  def multStrassenPar(m1: Matriz, m2: Matriz): Matriz = {
    // recibe m1 y m2 matrices cuadradas del mismo tamaño, potencia de 2
    // y devuelve la multiplicación en paralelo de las 2 matrices usando el algoritmo de Strassen
    val n = m1.length

    if (n == 1) {
      Vector(Vector(m1(0)(0) * m2(0)(0)))
    } else {
      val m = n / 2

      val a = subMatriz(m1, 0, 0, m)
      val b = subMatriz(m1, 0, m, m)
      val c = subMatriz(m1, m, 0, m)
      val d = subMatriz(m1, m, m, m)

      val e = subMatriz(m2, 0, 0, m)
      val f = subMatriz(m2, 0, m, m)
      val g = subMatriz(m2, m, 0, m)
      val h = subMatriz(m2, m, m, m)

      val p1 = task {
        multStrassenPar(a, restaMatriz(f, h))
      }
      val p2 = task {
        multStrassenPar(sumMatriz(a, b), h)
      }
      val p3 = task {
        multStrassenPar(sumMatriz(c, d), e)
      }
      val p4 = task {
        multStrassenPar(d, restaMatriz(g, e))
      }
      val p5 = task {
        multStrassenPar(sumMatriz(a, d), sumMatriz(e, h))
      }
      val p6 = task {
        multStrassenPar(restaMatriz(b, d), sumMatriz(g, h))
      }
      val p7 = task {
        multStrassenPar(restaMatriz(a, c), sumMatriz(e, f))
      }

      val r1 = sumMatriz(restaMatriz(sumMatriz(p5.join(), p4.join()), p2.join()), p6.join())
      val r2 = sumMatriz(p1.join(), p2.join())
      val r3 = sumMatriz(p3.join(), p4.join())
      val r4 = restaMatriz(restaMatriz(sumMatriz(p1.join(), p5.join()), p3.join()), p7.join())

      val result = Vector.tabulate(n, n) { (i, j) =>
        if (i < m && j < m) {
          r1(i)(j)
        } else if (i < m && j >= m) {
          r2(i)(j - m)
        } else if (i >= m && j < m) {
          r3(i - m)(j)
        } else {
          r4(i - m)(j - m)
        }
      }
      result
    }
  }
}

