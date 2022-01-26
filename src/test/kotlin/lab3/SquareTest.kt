package lab3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SquareTest
{
    @Test
    fun CreateSquare()
    {
        try {
            val Test = ShapeFactoryImpl()
            Test.createSquare(7.0)
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
        var S = Square(7.0)
        assertEquals(49.0, S.calcArea())
    }

    @Test
    fun testPerimeter()
    {
        var S = Square(7.0)
        assertEquals(28.0, S.calcPerimeter())
    }
}