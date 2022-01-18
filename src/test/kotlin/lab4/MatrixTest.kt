package lab4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MatrixTest()
{

    @Test
    fun testA()
    {
        val resul: Array<Array<Double>> = Array(3) { Array(4) { 0.0 } }
        val m = Matrix(resul)
        val ma = Matrix(resul)
        assertEquals(true, m.is_comparison(ma))
    }

    @Test
    fun testB()
    {
        val resul: Array<Array<Double>> = Array(3) { Array(4) { 1.0 } }
        val resul2: Array<Array<Double>> = Array(3) { Array(4) { 3.0 } }
        val m = Matrix(resul)
        val ma = Matrix(resul2)
        m.plusAssign(ma)
        var comparison = true
        for(i in 1..2)
        {
            for(j in 1..3)
            {
                if(m.table[i-1][j-1] != 4.0)
                    comparison = false
            }
        }
        assertEquals(true, comparison)
    }

    @Test
    fun testC()
    {
        val resul: Array<Array<Double>> = Array(3) { Array(4) { 1.0 } }
        val resul2: Array<Array<Double>> = Array(3) { Array(4) { 3.0 } }
        val m = Matrix(resul)
        val ma = Matrix(resul2)
        m.plusAssign(ma)
        var comparison = true
        for(i in 1..2)
        {
            for(j in 1..3)
            {
                if(m.table[i-1][j-1] != 4.0)
                    comparison = false
            }
        }
        assertEquals(true, comparison)
    }

    @Test
    fun testD()
    {
        val resul: Array<Array<Double>> = Array(3) { Array(3) { 3.0 } }
        val resul2: Array<Array<Double>> = Array(3) { Array(1) { 11.0 } }
        val m = Matrix(resul)
        val ma = Matrix(resul2)
        m.timesAssign(ma)
        var comparison = true
        for(i in 1..3)
        {
                if(m.table[i-1][0] != 99.0)
                    comparison = false
        }

        assertEquals(true, comparison)

    }

}