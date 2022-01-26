import  lab3.*


fun main() {
    val shapeCollector = ShapeCollector<Shape>()
    shapeCollector.add(Square(2.0))
    val list1 = listOf<Shape>(Square(3.0), Circle(7.0), Triangle(3.0, 4.0, 5.0), Circle(128.0))
    shapeCollector.addAll(list1)
    println(shapeCollector.getAllSorted(ShapeComporators.calcPerimeterIncrease))

}