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

/*

Mult matriz normal vs Mult matriz recursiva

compararAlgoritmos(multMatriz,multMatrizRec)(m2_1,m2_2)
compararAlgoritmos(multMatriz,multMatrizRec)(m4_1,m4_2)
compararAlgoritmos(multMatriz,multMatrizRec)(m8_1,m8_2)
compararAlgoritmos(multMatriz,multMatrizRec)(m16_1,m16_2)
compararAlgoritmos(multMatriz,multMatrizRec)(m32_1,m32_2)
compararAlgoritmos(multMatriz,multMatrizRec)(m64_1,m64_2)
compararAlgoritmos(multMatriz,multMatrizRec)(m128_1,m128_2)
compararAlgoritmos(multMatriz,multMatrizRec)(m256_1,m256_2)
compararAlgoritmos(multMatriz,multMatrizRec)(m512_1,m512_2)
compararAlgoritmos(multMatriz,multMatrizRec)(m1024_1,m1024_2)

Mult matriz paralela vs Mult matriz secuencial

compararAlgoritmos(multMatrizPar,multMatrizRec)(m2_1,m2_2)
compararAlgoritmos(multMatrizPar,multMatrizRec)(m4_1,m4_2)
compararAlgoritmos(multMatrizPar,multMatrizRec)(m8_1,m8_2)
compararAlgoritmos(multMatrizPar,multMatrizRec)(m16_1,m16_2)
compararAlgoritmos(multMatrizPar,multMatrizRec)(m32_1,m32_2)
compararAlgoritmos(multMatrizPar,multMatrizRec)(m64_1,m64_2)
compararAlgoritmos(multMatrizPar,multMatrizRec)(m128_1,m128_2)
compararAlgoritmos(multMatrizPar,multMatrizRec)(m256_1,m256_2)
compararAlgoritmos(multMatrizPar,multMatrizRec)(m512_1,m512_2)
compararAlgoritmos(multMatrizPar,multMatrizRec)(m1024_1,m1024_2)

Mult matriz normal vs Mult matriz paralela

compararAlgoritmos(multMatriz,multMatrizPar)(m2_1,m2_2)
compararAlgoritmos(multMatriz,multMatrizPar)(m4_1,m4_2)
compararAlgoritmos(multMatriz,multMatrizPar)(m8_1,m8_2)
compararAlgoritmos(multMatriz,multMatrizPar)(m16_1,m16_2)
compararAlgoritmos(multMatriz,multMatrizPar)(m32_1,m32_2)
compararAlgoritmos(multMatriz,multMatrizPar)(m64_1,m64_2)
compararAlgoritmos(multMatriz,multMatrizPar)(m128_1,m128_2)
compararAlgoritmos(multMatriz,multMatrizPar)(m256_1,m256_2)
compararAlgoritmos(multMatriz,multMatrizPar)(m512_1,m512_2)
compararAlgoritmos(multMatriz,multMatrizPar)(m1024_1,m1024_2)

Mult matriz recursiva vs mult strassen

compararAlgoritmos(multMatrizRec,multStrassen)(m2_1,m2_2)
compararAlgoritmos(multMatrizRec,multStrassen)(m4_1,m4_2)
compararAlgoritmos(multMatrizRec,multStrassen)(m8_1,m8_2)
compararAlgoritmos(multMatrizRec,multStrassen)(m16_1,m16_2)
compararAlgoritmos(multMatrizRec,multStrassen)(m32_1,m32_2)
compararAlgoritmos(multMatrizRec,multStrassen)(m64_1,m64_2)
compararAlgoritmos(multMatrizRec,multStrassen)(m128_1,m128_2)
compararAlgoritmos(multMatrizRec,multStrassen)(m256_1,m256_2)
compararAlgoritmos(multMatrizRec,multStrassen)(m512_1,m512_2)
compararAlgoritmos(multMatrizRec,multStrassen)(m1024_1,m1024_2)

*/

compararAlgoritmos(multStrassen,multStrassenPar)(m2_1,m2_2)
compararAlgoritmos(multStrassen,multStrassenPar)(m4_1,m4_2)
compararAlgoritmos(multStrassen,multStrassenPar)(m8_1,m8_2)
compararAlgoritmos(multStrassen,multStrassenPar)(m16_1,m16_2)
compararAlgoritmos(multStrassen,multStrassenPar)(m32_1,m32_2)
compararAlgoritmos(multStrassen,multStrassenPar)(m64_1,m64_2)
compararAlgoritmos(multStrassen,multStrassenPar)(m128_1,m128_2)
compararAlgoritmos(multStrassen,multStrassenPar)(m256_1,m256_2)
compararAlgoritmos(multStrassen,multStrassenPar)(m512_1,m512_2)
compararAlgoritmos(multStrassen,multStrassenPar)(m1024_1,m1024_2)

compararAlgoritmos(multStrassen,multMatrizPar)(m2_1,m2_2)
compararAlgoritmos(multStrassen,multMatrizPar)(m4_1,m4_2)
compararAlgoritmos(multStrassen,multMatrizPar)(m8_1,m8_2)
compararAlgoritmos(multStrassen,multMatrizPar)(m16_1,m16_2)
compararAlgoritmos(multStrassen,multMatrizPar)(m32_1,m32_2)
compararAlgoritmos(multStrassen,multMatrizPar)(m64_1,m64_2)
compararAlgoritmos(multStrassen,multMatrizPar)(m128_1,m128_2)
compararAlgoritmos(multStrassen,multMatrizPar)(m256_1,m256_2)
compararAlgoritmos(multStrassen,multMatrizPar)(m512_1,m512_2)
compararAlgoritmos(multStrassen,multMatrizPar)(m1024_1,m1024_2)


compararAlgoritmos(multStrassen,multMatrizRec)(m2_1,m2_2)
compararAlgoritmos(multStrassen,multMatrizRec)(m4_1,m4_2)
compararAlgoritmos(multStrassen,multMatrizRec)(m8_1,m8_2)
compararAlgoritmos(multStrassen,multMatrizRec)(m16_1,m16_2)
compararAlgoritmos(multStrassen,multMatrizRec)(m32_1,m32_2)
compararAlgoritmos(multStrassen,multMatrizRec)(m64_1,m64_2)
compararAlgoritmos(multStrassen,multMatrizRec)(m128_1,m128_2)
compararAlgoritmos(multStrassen,multMatrizRec)(m256_1,m256_2)
compararAlgoritmos(multStrassen,multMatrizRec)(m512_1,m512_2)
compararAlgoritmos(multStrassen,multMatrizRec)(m1024_1,m1024_2)