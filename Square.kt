
class Square(
    var x: Int = 0,
    var y: Int = 0,
    var side: Int = 10
) : Movable, Transforming, Figure(0) {

    override fun area(): Float {
        return (side * side).toFloat()
    }

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun resize(zoom: Int) {
        require(zoom > 0) { "Zoom must be positive" }
        side *= zoom
    }

    override fun rotate(
        direction: RotateDirection,
        centerX: Int,
        centerY: Int
    ) {
        val cx = x + side / 2
        val cy = y + side / 2

        val dx = cx - centerX
        val dy = cy - centerY

        when (direction) {
            RotateDirection.Clockwise -> {
                x = centerX - dy - side / 2
                y = centerY + dx - side / 2
            }

            RotateDirection.CounterClockwise -> {
                x = centerX + dy - side / 2
                y = centerY - dx - side / 2
            }
        }
    }
}
