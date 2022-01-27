package lab3

import kotlinx.serialization.Serializable
import kotlin.math.sqrt

@Serializable
class Triangle(val sideA: Double, val sideB: Double, val sideC: Double) : Shape {

    init {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0 || sideA + sideB <= sideC || sideC + sideB <= sideA || sideC + sideA <= sideB) {
            throw IllegalArgumentException("Data entered incorrectly")
        }
    }

    override fun calcArea(): Double {
        val perimeter = (sideA + sideB + sideC) / 2
        val area = perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - sideC)
        return sqrt(area)
    }

    override fun calcPerimeter(): Double {
        return sideA + sideB + sideC
    }
}