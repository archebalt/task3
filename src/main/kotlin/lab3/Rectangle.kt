package lab3

import kotlinx.serialization.Serializable
import kotlin.system.exitProcess
@Serializable
class Rectangle(val a: Double, val b: Double) : Shape { /* implementation */

    init {
        if (a < 0 || b < 0) {
            throw IllegalArgumentException("Data entered incorrectly")
        }
    }

    override fun calcArea(): Double {
        return a * b
    }

    override fun calcPerimeter(): Double {
        return (a + b) * 2
    }
}