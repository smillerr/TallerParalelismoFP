
import Matrices._
import scala.collection.parallel.CollectionConverters._
import org.scalameter._
package object Benchmark {
  type AlgoritmoMult = (Matriz, Matriz) => Matriz


  def compararAlgoritmos(a1:AlgoritmoMult, a2:AlgoritmoMult)
                        (m1:Matriz, m2:Matriz):(Double,Double, Double) = {
    val timeA1 = config(
      KeyValue(Key.exec.minWarmupRuns -> 20),
      KeyValue(Key.exec.maxWarmupRuns -> 60),
      KeyValue(Key.verbose -> false)
    ) withWarmer(new Warmer.Default) measure (a1(m1,m2))

    val timeA2 = config(
      KeyValue(Key.exec.minWarmupRuns -> 20),
      KeyValue(Key.exec.maxWarmupRuns -> 60),
      KeyValue(Key.verbose -> false)
    ) withWarmer(new Warmer.Default) measure (a2(m1,m2))

    val speedUp= timeA1.value/timeA2.value
    (timeA1.value, timeA2.value, speedUp)
  }



  def compararProdPunto(n: Int) = {
    // Para probar con paralelismo de datos
    val v1 = vectorAlAzar(n, 2)
    val v2 = vectorAlAzar(n, 2)
    val v1parD = v1.par
    val v2parD = v2.par
    val timeA1 = config(
      KeyValue(Key.exec.minWarmupRuns -> 20),
      KeyValue(Key.exec.maxWarmupRuns -> 60),
      KeyValue(Key.verbose -> false)
    ) withWarmer (new Warmer.Default) measure {
      prodPunto(v1, v2)
    }

    val timeA2 = config(
      KeyValue(Key.exec.minWarmupRuns -> 20),
      KeyValue(Key.exec.maxWarmupRuns -> 60),
      KeyValue(Key.verbose -> false)
    ) withWarmer (new Warmer.Default) measure {
      prodPuntoParD(v1parD, v2parD)
    }
    val speedUp = timeA1.value / timeA2.value
    (timeA1.value, timeA2.value, speedUp)
  }

  def tiempoAlgoritmo(a: AlgoritmoMult)(m1: Matriz, m2: Matriz): Double = {
    val timeA1 = config(
      KeyValue(Key.exec.minWarmupRuns -> 20),
      KeyValue(Key.exec.maxWarmupRuns -> 40),
      KeyValue(Key.verbose -> false)
    ) withWarmer (new Warmer.Default) measure (a(m1, m2))

    timeA1.value
    }



}