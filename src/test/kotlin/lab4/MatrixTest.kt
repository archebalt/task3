package lab4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFails

internal class MatrixTest() {

    @Test
    fun testEquals() {
        val resul: Array<Array<Double>> = Array(3) { Array(4) { 0.0 } }
        val m = Matrix(resul)
        val ma = Matrix(resul)
        assertEquals(true, m == ma)
    }

    @Test
    fun testPlus() {
        val resul: Array<Array<Double>> = Array(3) { Array(4) { 1.0 } }
        val resul2: Array<Array<Double>> = Array(3) { Array(4) { 3.0 } }
        val m = Matrix(resul)
        val ma = Matrix(resul2)
        m.plusAssign(ma)
        var comparison = true
        for (i in 1..2) {
            for (j in 1..3) {
                if (m[i - 1, j - 1] != 4.0)
                    comparison = false
            }
        }
        assertEquals(true, comparison)
    }

    @Test
    fun testMinus() {
        val resul: Array<Array<Double>> = Array(3) { Array(4) { 1.0 } }
        val resul2: Array<Array<Double>> = Array(3) { Array(4) { 3.0 } }
        val m = Matrix(resul)
        val ma = Matrix(resul2)
        m.minusAssign(ma)
        var comparison = true
        for (i in 1..2) {
            for (j in 1..3) {
                if (m[i - 1, j - 1] != -2.0)
                    comparison = false
            }
        }
        assertEquals(true, comparison)
    }

    @Test
    fun testTimes() {
        val resul: Array<Array<Double>> = Array(3) { Array(3) { 3.0 } }
        val resul2: Array<Array<Double>> = Array(3) { Array(1) { 11.0 } }
        val m = Matrix(resul)
        val ma = Matrix(resul2)
        m.timesAssign(ma)
        var comparison = true
        for (i in 1..3) {
            if (m[i - 1, 0] != 99.0)
                comparison = false
        }
        assertEquals(true, comparison)

    }

    @Test
    fun testString() {
        val resul: Array<Array<Double>> = Array(2) { Array(2) { 3.0 } }
        val m = Matrix(resul)
        val a = 3.0
        val str = a.toString() + "\t" + a.toString() + "\t" + "\n" + a.toString() + "\t" + a.toString() + "\t" + "\n"
        assertEquals(str, m.toString())
    }

    @Test
    fun testDiv() {

        val resul: Array<Array<Double>> = Array(3) { Array(4) { 3.0 } }
        val m = Matrix(resul)
        m.divAssign(2.0)
        var comparison = true
        for (i in 1..2) {
            for (j in 1..3) {
                if (m[i - 1, j - 1] != 1.5)
                    comparison = false
            }
        }
        assertEquals(true, comparison)
    }

    @Test
    fun testTimesAssign() {

        val resul: Array<Array<Double>> = Array(3) { Array(4) { 3.0 } }
        val m = Matrix(resul)
        m.timesAssign(2.0)
        var comparison = true
        for (i in 1..2) {
            for (j in 1..3) {
                if (m[i - 1, j - 1] != 6.0)
                    comparison = false
            }
        }
        assertEquals(true, comparison)
    }

    @Test
    fun testCreate() {
        val resul = arrayOf(arrayOf(1.0, 2.0, 3.0), arrayOf(1.0, 2.0))
        assertFails { Matrix(resul) }
    }

    @Test
    fun testNewTimes() {
        val resul: Array<Array<Double>> = Array(3) { Array(3) { 3.0 } }
        val resul2: Array<Array<Double>> = Array(3) { Array(1) { 11.0 } }
        val m1 = Matrix(resul)
        val ma = Matrix(resul2)

        assertFails { ma.timesAssign(m1) }
    }
}