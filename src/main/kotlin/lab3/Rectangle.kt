package lab3

import kotlin.system.exitProcess

class Rectangle(private val a : Double , private val b : Double) : Shape { /* implementation */
    override fun calcArea() : Double {
        if (a < 0 || b < 0) {
            println("error")
            exitProcess(400)
        }
        return a * b
    }

    override fun calcPerimeter() : Double {
        if (a < 0 || b < 0) {
            println("error")
            exitProcess(400)
        }
        return (a + b) * 2
    }
}