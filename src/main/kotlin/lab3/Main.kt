package lab3

fun main() {
    val ShapeObject = ShapeFactoryImpl()
    var SumPerimeter = 0.0
    var SumArea = 0.0
    var maxArea = 0.0
    var maxPerimeter = 0.0

    val ShapeArray = arrayOf(
        ShapeObject.createRandomCircle(),
        ShapeObject.createRandomSquare(),
        ShapeObject.createRandomRectangle(),
        ShapeObject.createRandomTriangle(),
        ShapeObject.createRandomShape()
    )
    for (i in ShapeArray.indices) {
        SumPerimeter += ShapeArray[i].calcPerimeter()
        SumArea += ShapeArray[i].calcArea()
        if (maxArea < ShapeArray[i].calcArea())
            maxArea = ShapeArray[i].calcArea()
        if (maxPerimeter < ShapeArray[i].calcPerimeter())
            maxPerimeter = ShapeArray[i].calcPerimeter()
    }
    println("Summa Perimeter: $SumPerimeter")
    println("Summa Area: $SumArea")
    println("Max Perimeter: $maxPerimeter")
    println("Max Area: $maxArea")
}