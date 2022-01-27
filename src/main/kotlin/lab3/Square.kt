package lab3

import kotlinx.serialization.Serializable

@Serializable
class Square(val sideA: Double) : Shape {

    init {
        if (sideA < 0) {
            throw IllegalArgumentException("Data entered incorrectly")
        }
    }

    override fun calcArea(): Double {
        return sideA * sideA
    }

    override fun calcPerimeter(): Double {
        return sideA * 4
    }
}