import  lab3.*


fun main() {
    val shapeCollector = ShapeCollector<Shape>()
    shapeCollector.add(Square(2.0))
    val list1 = listOf<Shape>(Square(3.0), Circle(7.0), Triangle(3.0, 4.0, 5.0), Circle(128.0))
    shapeCollector.addAll(list1)
    println("В любом порядке: ${shapeCollector.getAll()}")
    println("периметр по возрастанию: ${shapeCollector.getAllSorted(ShapeComporators.calcPerimeterIncrease)}")
    println("периметр по убыванию: ${shapeCollector.getAllSorted(ShapeComporators.calcPerimeterDescending)}")
    println("площадь по возрастанию: ${shapeCollector.getAllSorted(ShapeComporators.calcAreaIncrease)}")
    println("площадь по убыванию: ${shapeCollector.getAllSorted(ShapeComporators.calcAreaDescending)}")
    println("периметр по возрастанию:")
    for (sh in shapeCollector.getAllSorted(ShapeComporators.calcPerimeterIncrease)) {
        print("${sh.calcPerimeter()} |")
    }
    println()
    println("периметр по убыванию:")
    for (sh in shapeCollector.getAllSorted(ShapeComporators.calcPerimeterDescending)) {
        print("${sh.calcPerimeter()} |")
    }
    println()
    println("площадь по возрастанию:")
    for (sh in shapeCollector.getAllSorted(ShapeComporators.calcAreaIncrease)) {
        print("${sh.calcArea()} |")
    }
    println()
    println("площадь по убыванию:")
    for (sh in shapeCollector.getAllSorted(ShapeComporators.calcAreaDescending)) {
        print("${sh.calcArea()} |")
    }
    val circleCollector = ShapeCollector<Circle>()
    circleCollector.getAllSorted(ShapeComporators.calcAreaIncrease)
    circleCollector.add(Circle(2.0))
    circleCollector.add(Circle(3.5))
    circleCollector.add(Circle(4.0))
    circleCollector.add(Circle(200.0))
    println()
    println("радиус по возрастанию:")
    for (sh in circleCollector.getAllSorted(ShapeComporators.radiusIncrease)) {
        print("${sh.radius} |")
    }
    println()
    println("радиус по убыванию:")
    for (sh in circleCollector.getAllSorted(ShapeComporators.radiusDescending)) {
        print("${sh.radius} |")
    }
    println()
    for (sh in shapeCollector.getAllByClass(Square::class.java)) {
        println("$sh - ${sh.calcPerimeter()}")
    }

}