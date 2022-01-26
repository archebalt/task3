package lab3

import kotlinx.serialization.Serializable
import kotlin.math.sqrt
import kotlin.system.exitProcess
@Serializable
class Triangle(val a: Double, val b: Double, val c: Double) : Shape {

    init {
        if (a <= 0 || b <= 0 || c <= 0 && !(a + b > c && c + b > a && c + a > b)) {
            throw IllegalArgumentException("Data entered incorrectly")
        }
    }

    override fun calcArea(): Double {
        val perimeter = (a + b + c) / 2
        val area = perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c)
        return sqrt(area)
    }

    override fun calcPerimeter(): Double {
        return a + b + c
    }
}