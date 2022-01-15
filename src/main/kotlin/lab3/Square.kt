package lab3

import kotlin.system.exitProcess


class Square(private val a: Double): Shape
{
    /* implementation */
    override fun calcArea(): Double {
        if(a<0) {
            println("error")
            exitProcess(400)
        }
        return a*a
    }

    override fun calcPerimeter(): Double {
        if(a<0) {
            println("error")
            exitProcess(400)
        }
        return a*4
    }
}