package lab3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TriangleTest
{
    @Test
    fun CreateTriangle()
    {
        try {
            val Test = ShapeFactoryImpl()
            Test.createTriangle(7.0,3.0,5.0)
        } catch (e: Exception) {
            fail()
        }
    }

    @Test
    fun testTriangle()
    {
        var T = Triangle(3.0, 4.0, 5.0)
        assertEquals(6.0, T.calcArea())
    }

    @Test
    fun testPerimeter()
    {
        var T = Triangle(3.0, 4.0, 5.0)
        assertEquals(12.0, T.calcPerimeter())
    }
}