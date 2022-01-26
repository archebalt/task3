package lab3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.PI

internal class CircleTest
{
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
        var C = Circle(7.0)
        assertEquals(7*7* PI, C.calcArea())
    }

    @Test
    fun testPerimeter()
    {
        var C = Circle(7.0)
        assertEquals(2*7*PI, C.calcPerimeter())
    }
}