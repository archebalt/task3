package lab3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFails

internal class SquareTest {
    @Test
    fun CreateSquare() {
        try {
            val Test = ShapeFactoryImpl()
            Test.createSquare(7.0)
        } catch (e: Exception) {
            fail()
        }
    }

    @Test
    fun CreateSquare2() {
        val Test = ShapeFactoryImpl()
        assertFails { Test.createSquare(-7.0) }
    }

    @Test
    fun CreateCircle() {
        try {
            val Test = ShapeFactoryImpl()
            Test.createCircle(10.0)
        } catch (e: Exception) {
            fail()
        }
    }

    @Test
    fun testArae() {
        val S = Square(7.0)
        assertEquals(49.0, S.calcArea())
    }

    @Test
    fun testPerimeter() {
        val S = Square(7.0)
        assertEquals(28.0, S.calcPerimeter())
    }
}