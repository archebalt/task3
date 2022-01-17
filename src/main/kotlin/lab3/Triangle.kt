package lab3

import kotlin.math.sqrt
import kotlin.system.exitProcess

class Triangle(private val a : Double , private val b : Double , private val c : Double) : Shape { /* implementation */
    override fun calcArea() : Double {
        if (a < 0 || b < 0 || c < 0) {
            println("error")
            exitProcess(400)
        }
        val perimeter = (a + b + c) / 2
        val area = perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c)
        return sqrt(area)
    }

    override fun calcPerimeter() : Double {
        if (a < 0 || b < 0 || c < 0) {
            println("error")
            exitProcess(400)
        }
        return a + b + c
    }
}