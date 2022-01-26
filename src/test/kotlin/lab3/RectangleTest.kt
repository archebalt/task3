package lab3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.PI

internal class RectangleTest
{
    @Test
    fun CreateRectangle()
    {
        try {
            val Test = ShapeFactoryImpl()
            Test.createRectangle(7.0,8.0)
        } catch (e: Exception) {
            fail()
        }
    }

    @Test
    fun CreateCircle()
    {
        try {
            val Test = ShapeFactoryImpl()
            Test.createCircle(10.0)
        } catch (e: Exception) {
            fail()
        }
    }

    @Test
    fun testArae()
    {
        var R = Rectangle(7.0,6.0)
        assertEquals(42.0, R.calcArea())
    }

    @Test
    fun testPerimeter()
    {
        var R = Rectangle(7.0,6.0)
        assertEquals(26.0, R.calcPerimeter())
    }
}