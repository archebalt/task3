package lab3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFails

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
    fun CreateTriangle2() {
        val Test = ShapeFactoryImpl()
        assertFails { Test.createTriangle(10.0 ,-2.0,4.0) }
    }

    @Test
    fun CreateTriangle3() {
        val Test = ShapeFactoryImpl()
        assertFails { Test.createTriangle(10.0 ,2.0,4.0) }
    }

    @Test
    fun testTriangle()
    {
        val Test = Triangle(3.0, 4.0, 5.0)
        assertEquals(6.0, Test.calcArea())
    }

    @Test
    fun testPerimeter()
    {
        val Test = Triangle(3.0, 4.0, 5.0)
        assertEquals(12.0, Test.calcPerimeter())
    }
}