package lab4


fun main() {
    val resul : Array<Array<Double>> = Array(3) { Array(3) { 3.0 } }
    val resul2 : Array<Array<Double>> = Array(3) { Array(3) { 11.0 } }
    val m : Matrix
    val m1 : Matrix = Matrix(resul)
    val ma : Matrix = Matrix(resul2)
    m = ma.minus(m1)
    println(m.toString())
}
