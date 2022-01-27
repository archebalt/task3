package lab3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.PI
import kotlin.test.assertFails

internal class CircleTest {
    @Test
    fun CreateCircle() {
        try {
            val test = ShapeFactoryImpl()
            test.createCircle(10.0)
        } catch (e: Exception) {
            fail()
        }
    }

    @Test
    fun CreateCircle2() {
        val Test = ShapeFactoryImpl()
        assertFails { Test.createCircle(-10.0) }
    }


    @Test
    fun testArea() {
        val c = Circle(7.0)
        assertEquals(7 * 7 * PI, c.calcArea())
    }

    @Test
    fun testPerimeter() {
        val c = Circle(7.0)
        assertEquals(2 * 7 * PI, c.calcPerimeter())
    }
}