package lab7

import lab3.*

fun main() {
    val pathRead = "C:\\task31\\src\\main\\kotlin\\lab7\\JsonRead.json"
    val pathWrite = "C:\\task31\\src\\main\\kotlin\\lab7\\JsonWrite.json"

    val jsonCoder = SerializersModule()
    val fileFunction = FileIO()

    val shapesArray = (
            listOf(
                Circle(2.0),
                Triangle(1.0, 1.0, 1.5),
                Rectangle(6.0, 10.0)
            )
            )

    val newShapesArray = jsonCoder.decode(fileFunction.read(pathRead)).toMutableList()

    fileFunction.write(pathWrite, jsonCoder.encode(newShapesArray + shapesArray))

}