
import Matrices._
import org.scalameter._

package object Benchmark {
  type AlgoritmoMult = (Matriz, Matriz) => Matriz

  // ... (rest of your code)

  def compararMultMatriz(n: Int) = {
    // To test with data parallelism
    val m1 = matrizAlAzar(n, 2)
    val m2 = matrizAlAzar(n, 2)
    val m1parD = m1.par
    val m2parD = m2.par
    val timeA1 = config(
      KeyValue(Key.exec.minWarmupRuns -> 20),
      KeyValue(Key.exec.maxWarmupRuns -> 60),
      KeyValue(Key.verbose -> false)
    ) withWarmer (new Warmer.Default) measure { multMatriz(m1, m2) }

    val timeA2 = config(
      KeyValue(Key.exec.minWarmupRuns -> 20),
      KeyValue(Key.exec.maxWarmupRuns -> 60),
      KeyValue(Key.verbose -> false)
    ) withWarmer (new Warmer.Default) measure { multMatrizParD(m1parD, m2parD) }
    val speedUp = timeA1.value / timeA2.value
    (timeA1.value, timeA2.value, speedUp)
  }

  // ... (rest of your code)
}
