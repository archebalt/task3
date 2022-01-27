package lab3

import kotlinx.serialization.Serializable

@Serializable
class Rectangle(val sideA: Double, val sideB: Double) : Shape { /* implementation */

    init {
        if (sideA < 0 || sideB < 0) {
            throw IllegalArgumentException("Data entered incorrectly")
        }
    }

    override fun calcArea(): Double {
        return sideA * sideB
    }

    override fun calcPerimeter(): Double {
        return (sideA + sideB) * 2
    }
}