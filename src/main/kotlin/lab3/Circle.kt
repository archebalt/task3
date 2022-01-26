package lab3

import kotlin.math.PI
import kotlin.system.exitProcess

class Circle(val r: Double) : Shape {

    init {
        if (r <= 0) {
            throw IllegalArgumentException("Data entered incorrectly")
        }
    }

    override fun calcArea(): Double {

        return r * r * PI
    }

    override fun calcPerimeter(): Double {
        return 2 * r * PI
    }
}