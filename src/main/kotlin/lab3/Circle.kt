package lab3

import kotlin.math.PI
import kotlin.system.exitProcess

class Circle(private val r: Double):Shape {
    override fun calcArea(): Double {
        if(r<0) {
            println("error")
            exitProcess(400)
        }
        return r*r*PI
    }

    override fun calcPerimeter(): Double {
        if(r<0)
        {
            println("error")
            exitProcess(400)
        }
        return 2*r*PI
    }
}