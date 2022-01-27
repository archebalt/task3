package lab3

fun main() {
    val shapeobject = ShapeFactoryImpl()
    var sumperimeter = 0.0
    var sumarea = 0.0
    var maxArea = 0.0
    var maxPerimeter = 0.0

    val shapearray = arrayOf(
        shapeobject.createRandomCircle(),
        shapeobject.createRandomSquare(),
        shapeobject.createRandomRectangle(),
        shapeobject.createRandomTriangle(),
        shapeobject.createRandomShape()
    )
    for (i in shapearray.indices) {
        sumperimeter += shapearray[i].calcPerimeter()
        sumarea += shapearray[i].calcArea()
        if (maxArea < shapearray[i].calcArea())
            maxArea = shapearray[i].calcArea()
        if (maxPerimeter < shapearray[i].calcPerimeter())
            maxPerimeter = shapearray[i].calcPerimeter()
    }
    println("Summa Perimeter: $sumperimeter")
    println("Summa Area: $sumarea")
    println("Max Perimeter: $maxPerimeter")
    println("Max Area: $maxArea")
}