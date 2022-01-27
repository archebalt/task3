package lab3

import kotlin.random.Random

class ShapeFactoryImpl : ShapeFactory {
    override fun createCircle(radius: Double): Circle {
        return Circle(radius)
    }

    override fun createSquare(sideA: Double): Square {
        return Square(sideA)
    }

    override fun createRectangle(sideA: Double, sideB: Double): Rectangle {
        return Rectangle(sideA, sideB)
    }

    override fun createTriangle(sideA: Double, sideB: Double, sideC: Double): Triangle {
        return Triangle(sideA, sideB, sideC)
    }

    override fun createRandomCircle(): Circle {
        val radius = Random.nextDouble(0.1, 100.0)
        return Circle(radius)
    }

    override fun createRandomSquare(): Square {
        val sideA = Random.nextDouble(0.1, 100.0)
        return Square(sideA)
    }

    override fun createRandomRectangle(): Rectangle {
        val sideA = Random.nextDouble(0.1, 100.0)
        val sideB = Random.nextDouble(0.1, 100.0)
        return Rectangle(sideA, sideB)
    }

    override fun createRandomTriangle(): Triangle {

        val sideA: Double = Random.nextDouble(0.1, 100.0)
        val sideB: Double = Random.nextDouble(0.1, sideA)
        val c: Double = Random.nextDouble(sideA - sideB, sideA + sideB)

        return Triangle(sideA, sideB, c)
    }

    override fun createRandomShape(): Shape {
        return when (Random.nextInt(0, 3)) {
            0 -> createRandomCircle()
            1 -> createRandomSquare()
            2 -> createRandomRectangle()
            else -> createRandomTriangle()
        }
    }
}