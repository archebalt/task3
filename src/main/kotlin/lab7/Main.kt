package lab7

import lab3.*

fun main() {
    val AddressRead = "D:\\kotlinProjects\\kotlin10\\src\\main\\kotlin\\lab7\\JsonRead.json"
    val AddressWrite = "D:\\kotlinProjects\\kotlin10\\src\\main\\kotlin\\lab7\\JsonWrite.json"

    val FJ = FunJSON()
    val FF = funFile()

    val ShapeArray = (
            listOf(
                Circle(2.0),
                Triangle(1.0, 1.0, 1.5),
                Rectangle(6.0, 10.0)
            )
            )

    val ShepeArray2 = FJ.decode(FF.read(AddressRead)).toMutableList()

    FF.write(AddressWrite, FJ.encode(ShepeArray2 + ShapeArray))

}