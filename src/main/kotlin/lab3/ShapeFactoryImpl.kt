package lab3

import kotlin.random.Random
import kotlin.system.exitProcess

class ShapeFactoryImpl() : ShapeFactory {
    override fun createCircle(r: Double): Circle {
        return Circle(r)
    }

    override fun createSquare(a: Double): Square {
        return Square(a)
    }

    override fun createRectangle(a: Double, b: Double): Rectangle {
        return Rectangle(a, b)
    }

    override fun createTriangle(a: Double, b: Double, c: Double): Triangle {
        return Triangle(a, b, c)
    }

    override fun createRandomCircle(): Circle {
        val r = Random.nextDouble(0.1, 100.0)
        return Circle(r)
    }

    override fun createRandomSquare(): Square {
        val a = Random.nextDouble(0.1, 100.0)
        return Square(a)
    }

    override fun createRandomRectangle(): Rectangle {
        val a = Random.nextDouble(0.1, 100.0)
        val b = Random.nextDouble(0.1, 100.0)
        return Rectangle(a, b)
    }

    override fun createRandomTriangle(): Triangle {
        var a: Double
        var b: Double
        var c: Double

            a = Random.nextDouble(0.1, 100.0)
            b = Random.nextDouble(0.1, a)
            c = Random.nextDouble(a - b, a + b)

        return Triangle(a, b, c)
    }

    override fun createRandomShape(): Shape {
        val i = Random.nextInt(0, 3)
        when (i) {
            0 -> return createRandomCircle()
            1 -> return createRandomSquare()
            2 -> return createRandomRectangle()
            else -> return createRandomTriangle()
        }
    }
}