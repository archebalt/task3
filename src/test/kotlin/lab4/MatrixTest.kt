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
        assertEquals(true, m == ma)
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
                if(m[i-1,j-1] != 4.0)
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
        m.minusAssign(ma)
        var comparison = true
        for(i in 1..2)
        {
            for(j in 1..3)
            {
                if(m[i-1,j-1] != -2.0)
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
                if(m[i-1,0] != 99.0)
                    comparison = false
        }
        assertEquals(true, comparison)

    }

    @Test
    fun testE() {
        val resul: Array<Array<Double>> = Array(2) { Array(2) { 3.0 } }
        val m : Matrix = Matrix(resul)
        val a : Double = 3.0
        val str = a.toString() + "\t" + a.toString() + "\t" + "\n" + a.toString() + "\t" + a.toString() + "\t" + "\n"
        assertEquals(str, m.toString())
    }

    @Test
    fun testF()
    {

        val resul: Array<Array<Double>> = Array(3) { Array(4) { 3.0 } }
        val m = Matrix(resul)
        m.divAssign(2.0)
        var comparison = true
        for(i in 1..2)
        {
            for(j in 1..3)
            {
                if(m[i-1,j-1] != 1.5)
                    comparison = false
            }
        }
        assertEquals(true, comparison)
    }

    @Test
    fun testG()
    {

        val resul: Array<Array<Double>> = Array(3) { Array(4) { 3.0 } }
        val m = Matrix(resul)
        m.timesAssign(2.0)
        var comparison = true
        for(i in 1..2)
        {
            for(j in 1..3)
            {
                if(m[i-1,j-1] != 6.0)
                    comparison = false
            }
        }
        assertEquals(true, comparison)
    }


}