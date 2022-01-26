package lab3

import kotlinx.serialization.Serializable
import kotlin.system.exitProcess
@Serializable
class Square(val a: Double) : Shape {

    init {
        if (a < 0) {
            throw IllegalArgumentException("Data entered incorrectly")
        }
    }

    override fun calcArea(): Double {

        return a * a
    }

    override fun calcPerimeter(): Double {
        return a * 4
    }
}