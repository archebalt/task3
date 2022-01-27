package lab3

import kotlinx.serialization.Serializable
import kotlin.math.PI

@Serializable
class Circle(val radius: Double) : Shape {

    init {
        if (radius <= 0) {
            throw IllegalArgumentException("Data entered incorrectly")
        }
    }

    override fun calcArea(): Double {

        return radius * radius * PI
    }

    override fun calcPerimeter(): Double {
        return 2 * radius * PI
    }
}