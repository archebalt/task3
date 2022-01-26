import lab3.*

class ShapeCollector<T : Shape> {
    private var shapes = mutableListOf<T>()
    fun add(shape: T) {
        shapes.add(shape)
    }

    fun addAll(shapesList: List<T>) {
        shapes.addAll(shapesList)
    }

    fun getAll(): List<T> {
        return shapes.toList()
    }

    fun getAllSorted(comporator: Comparator<in T>): List<T> {
        return shapes.sortedWith(comporator).toList()
    }

    fun getAllByClass(shape: Class<out T>): List<T> {
        return shapes.filterIsInstance(shape)
    }

}

object ShapeComporators {
    val calcPerimeterIncrease = compareBy<Shape> { it.calcPerimeter() }
    val calcPerimeterDescending = compareByDescending<Shape> { it.calcPerimeter() }
    val calcAreaIncrease = compareBy<Shape> { it.calcArea() }
    val calcAreaDescending = compareByDescending<Shape> { it.calcArea() }
    val radiusIncrease = compareBy<Circle> { it.r }
    val radiusDescending = compareByDescending<Circle> { it.r }
}