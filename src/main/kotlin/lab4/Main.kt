package lab4


fun main() {
    val result : Array<Array<Double>> = Array(3) { Array(3) { 3.0 } }
    val result2 : Array<Array<Double>> = Array(3) { Array(3) { 11.0 } }
    val m : Matrix
    val m1 = Matrix(result)
    val ma = Matrix(result2)
    m = ma.times(m1)
    println(m.toString())
}
