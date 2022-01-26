package lab3

import kotlin.system.exitProcess

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