import Matrices._
import Benchmark._

val m1_1 = matrizAlAzar(1,2)
val m1_2 = matrizAlAzar(1,2)


val m2_1 = matrizAlAzar(2,2)
val m2_2 = matrizAlAzar(2,2)


val m4_1 = matrizAlAzar(4,2)
val m4_2 = matrizAlAzar(4,2)

val m8_1 = matrizAlAzar(8,2)
val m8_2 = matrizAlAzar(8,2)


val m16_1 = matrizAlAzar(16,2)
val m16_2 = matrizAlAzar(16,2)


val m32_1 = matrizAlAzar(32,2)
val m32_2 = matrizAlAzar(32,2)

val m64_1 = matrizAlAzar(64,2)
val m64_2 = matrizAlAzar(64,2)

val m128_1 = matrizAlAzar(128,2)
val m128_2 = matrizAlAzar(128,2)

val m256_1 = matrizAlAzar(256,2)
val m256_2 = matrizAlAzar(256,2)

val m512_1 = matrizAlAzar(512,2)
val m512_2 = matrizAlAzar(512,2)

val m1024_1 = matrizAlAzar(1024,2)
val m1024_2 = matrizAlAzar(1024,2)



val matrices1x1 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multStrassen, multStrassenPar)(m1_1,m1_2)

val matrices2x2 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multStrassen, multStrassenPar)(m2_1,m2_2)

val matrices4x4 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multStrassen, multStrassenPar)(m4_1,m4_2)

val matrices16x16 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multStrassen, multStrassenPar)(m8_1,m8_2)

val matrices32x32 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multStrassen, multStrassenPar)(m32_1,m32_2)

val matrices64x64 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multStrassen, multStrassenPar)(m64_1,m64_2)

val matrices128x128 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multStrassen, multStrassenPar)(m128_1,m128_2)

val matrices256x256 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multStrassen, multStrassenPar)(m256_1,m256_2)

val matrices512x512 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multStrassen, multStrassenPar)(m512_1,m512_2)

val matrices1x1_2 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatriz, multMatrizPar)(m1_1,m1_2)

val matrices2x2_2 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatriz, multMatrizPar)(m2_1,m2_2)

val matrices4x4_2 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatriz, multMatrizPar)(m4_1,m4_2)

val matrices16x16_2 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatriz, multMatrizPar)(m8_1,m8_2)

val matrices32x32_2 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatriz, multMatrizPar)(m32_1,m32_2)

val matrices64x64_2 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatriz, multMatrizPar)(m64_1,m64_2)

val matrices128x128_2 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatriz, multMatrizPar)(m128_1,m128_2)

val matrices256x256_2 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatriz, multMatrizPar)(m256_1,m256_2)

val matrices512x512_2 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatriz, multMatrizPar)(m512_1,m512_2)

val matrices1x1_3 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatrizRec, multMatrizRecPar)(m1_1,m1_2)

val matrices2x2_3 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatrizRec, multMatrizRecPar)(m2_1,m2_2)

val matrices4x4_3 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatrizRec, multMatrizRecPar)(m4_1,m4_2)

val matrices16x16_3 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatrizRec, multMatrizRecPar)(m8_1,m8_2)

val matrices32x32_3 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatrizRec, multMatrizRecPar)(m32_1,m32_2)

val matrices64x64_3 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatrizRec, multMatrizRecPar)(m64_1,m64_2)

val matrices128x128_3 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatrizRec, multMatrizRecPar)(m128_1,m128_2)

val matrices256x256_3 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatrizRec, multMatrizRecPar)(m256_1,m256_2)

val matrices512x512_3 = for (
  i <- (1 to 5).toVector
) yield compararAlgoritmos(multMatrizRec, multMatrizRecPar)(m512_1,m512_2)



val prodPuntos10 = {
  for (
    i <- (1 to 5).toVector
  ) yield compararProdPunto(10)
}

val prodPuntos100 = {
  for (
    i <- (1 to 5).toVector
  ) yield compararProdPunto(100)
}

val prodPuntos1000 = {
  for (
    i <- (1 to 5).toVector
  ) yield compararProdPunto(1000)
}

val prodPuntos10000 = {
  for (
    i <- (1 to 5).toVector
  ) yield compararProdPunto(10000)
}

val prodPuntos100000 = {
  for (
    i <- (1 to 5).toVector
  ) yield compararProdPunto(100000)
}

val prodPuntos1000000 = {
  for (
    i <- (1 to 5).toVector
  ) yield compararProdPunto(1000000)
}

val prodPuntos10000000 = {
  for (
    i <- (1 to 5).toVector
  ) yield compararProdPunto(10000000)
}

val prodPuntos100000000 = {
  for (
    i <- (1 to 5).toVector
  ) yield compararProdPunto(100000000)
}

