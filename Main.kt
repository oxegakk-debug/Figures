
fun main() {
    val rect = Rect(10, 20, 40, 20)
    val circle = Circle(50, 50, 10)
    val square = Square(100, 100, 20)

    val figures: Array<Figure> = arrayOf(rect, circle, square)

    println("=== FIGURES BEFORE TRANSFORMATIONS ===")

    for (figure in figures) {
        println("${figure::class.simpleName}: area = ${figure.area()}")
    }

    println("\n=== MOVEMENT ===")

    rect.move(10, 5)
    circle.move(10, 5)
    square.move(10, 5)

    println("Rect position: x=${rect.x}, y=${rect.y}")
    println("Circle position: x=${circle.x}, y=${circle.y}")
    println("Square position: x=${square.x}, y=${square.y}")

    println("\n=== RESIZING ===")

    rect.resize(2)
    circle.resize(2)
    square.resize(2)

    println("Rect size: ${rect.width} x ${rect.height}")
    println("Circle radius: ${circle.radius}")
    println("Square side: ${square.side}")

    println("\n=== ROTATION ===")

    rect.rotate(RotateDirection.Clockwise, 0, 0)
    circle.rotate(RotateDirection.Clockwise, 0, 0)
    square.rotate(RotateDirection.Clockwise, 0, 0)

    println("Rect position: x=${rect.x}, y=${rect.y}")
    println("Circle position: x=${circle.x}, y=${circle.y}")
    println("Square position: x=${square.x}, y=${square.y}")

    println("\n=== AREAS AFTER TRANSFORMATIONS ===")

    for (figure in figures) {
        println("${figure::class.simpleName}: area = ${figure.area()}")
    }

    println("\nAll transformations completed!")
}
