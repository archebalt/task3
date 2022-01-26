package lab7

import java.io.File

class funFile {
    fun write(address: String, str: String) {
        File(address).writeText(str)
    }

    fun read(address: String): String = File(address).readText()
}