package lab4

class Matrix(arr : Array<Array<Double>>) {
    private var a : Int
    private var b : Int
    private var table : Array<Array<Double>>

    init {
        table = arr
        a = table.size
        if (table.isNotEmpty()) {
            b = table[0].size
            for (i in 1 until a-1) {
                if (table[i].size != b) {
                    throw IllegalArgumentException("Data entered incorrectly")
                }
            }
        }
        else
            throw IllegalArgumentException("Data entered incorrectly")
    }

    operator fun plus(other : Matrix) : Matrix {
        compare(other)
        val result : Array<Array<Double>> =  Array(a) { Array(b) {0.0} }
        for (i in 1..a) {
            for (j in 1..b) {
                result[i-1][j-1] = table[i - 1][j - 1] + other[i - 1, j - 1]
            }
        }
        return Matrix(result)
    }

    operator fun plusAssign(other : Matrix) {
        compare(other)
        for (i in 1..a) {
            for (j in 1..b) {
                table[i - 1][j - 1] = table[i - 1][j - 1] + other[i - 1,j - 1]
            }
        }
    }

    operator fun minus(other : Matrix) : Matrix {
        compare(other)
        val result : Array<Array<Double>> =  Array(a) { Array(b) {0.0} }
        for (i in 1..a) {
            for (j in 1..b) {
                result[i-1][j-1] = table[i - 1][j - 1] -  other.table[i - 1][j - 1]
            }
        }
        return Matrix(other.table)
    }

    operator fun minusAssign(other : Matrix) {
        compare(other)
        for (i in 1..a) {
            for (j in 1..b) {
                table[i - 1][j - 1] = table[i - 1][j - 1] - other.table[i - 1][j - 1]
            }
        }
    }

    operator fun times(other : Matrix) : Matrix {
        val resul : Array<Array<Double>> = Array(a) { Array(other.a) { 0.0 } }
        for (i in 1..a) {
            for (j in 1..b) {
                for (k in 1..table.size) {
                    resul[i - 1][j - 1] += table[i - 1][k - 1] * other.table[k - 1][j - 1]
                }
            }
        }
        return Matrix(resul)
    }

    operator fun timesAssign(other : Matrix) {
        val resul : Array<Array<Double>> = Array(a) { Array(other.b) { 0.0 } }
        for (i in 1..a) {
            for (j in 1..other.b) {
                for (k in 1..b) {
                    resul[i - 1][j - 1] += table[i - 1][k - 1] * other.table[k - 1][j - 1]
                }
            }
        }
        table = resul
        a = table.size
        b = table[0].size
    }

    operator fun times(value : Double) : Matrix {
        val resul : Array<Array<Double>> = Array(a) { Array(b) { 0.0 } }
        for (i in 1..a) {
            for (j in 1..b) {
                resul[i - 1][j - 1] += table[i - 1][j - 1] * value

            }
        }
        return Matrix(resul)
    }

    operator fun timesAssign(value : Double){
        for (i in 1..a) {
            for (j in 1..b) {
                table[i - 1][j - 1] = table[i - 1][j - 1] * value

            }
        }
    }

    operator fun div(value : Double) : Matrix {
        val resul : Array<Array<Double>> = Array(a) { Array(b) { 0.0 } }
        for (i in 1..a) {
            for (j in 1..b) {
                resul[i - 1][j - 1] += table[i - 1][j - 1] / value

            }
        }
        return Matrix(resul)
    }

    operator fun divAssign(value : Double) {
        for (i in 1..a) {
            for (j in 1..b) {
                table[i - 1][j - 1] /= value

            }
        }
    }

    operator fun set(i : Int , j : Int , value : Double) {
        table[i][j] = value
    }

    fun getSizeRows() : Int {
        return a
    }

    fun getSizeColumns() : Int {
        return b
    }

    operator fun get(i : Int , j : Int) : Double {
        return table[i][j]
    }

    operator fun unaryMinus() : Matrix {
        val resultat = Matrix(table)
        for (i in 1..a) {
            for (j in 1..b) {
                resultat.table[i - 1][j - 1] = -table[i - 1][j - 1]
            }
        }
        return resultat
    }

    operator fun unaryPlus() : Matrix {
        return this
    }

    private fun compare(matr: Matrix)
    {
        if (matr.getSizeColumns() != b || matr.getSizeRows() != a)
            throw IllegalArgumentException("Data entered incorrectly")
    }

    override fun toString(): String {
        var resultat = ""
        for (i in 1..a) {
            for (j in 1..b) {
                resultat += table[i - 1][j - 1].toString() + "\t"
            }
            resultat += "\n"
        }
        return resultat
    }

    override operator fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Matrix

        if (a != other.a) return false
        if (b != other.b) return false
        for (i in 1..a) {
            for (j in 1..b) {
                if (other[i - 1,j - 1] != table[i - 1][j - 1])
                    return false
            }
        }

        return true
    }

    override fun hashCode(): Int {
        var result = a
        result = 31 * result + b
        result = 31 * result + table.contentDeepHashCode()
        return result
    }


}