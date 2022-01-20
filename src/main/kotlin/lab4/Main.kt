package lab4



fun main() {
    val resul: Array<Array<Double>> = Array(3) { Array(3) { 3.0 } }
    val resul2: Array<Array<Double>> = Array(3) { Array(1) { 11.0 } }
    val m : Matrix = Matrix(resul)
    val m1 : Matrix = Matrix(resul)
    val ma : Matrix = Matrix(resul2)
    println(m.is_comparison(ma))
    println(m.is_comparison(m1))
    m.timesAssign(ma)
    println(m.ToString())
}
