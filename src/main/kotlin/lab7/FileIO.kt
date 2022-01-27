package lab7

import java.io.File

class FileIO {
    fun write(path: String, str: String) {
        File(path).writeText(str)
    }

    fun read(path: String): String = File(path).readText()
}