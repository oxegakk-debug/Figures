
class Rect(
    var x: Int,
    var y: Int,
    var width: Int,
    var height: Int
) : Movable, Transforming, Figure(0) {

    var color: Int = -1
    lateinit var name: String

    constructor(rect: Rect) : this(
        rect.x,
        rect.y,
        rect.width,
        rect.height
    )

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun area(): Float {
        return (width * height).toFloat()
    }

    override fun resize(zoom: Int) {
        require(zoom > 0) { "Zoom must be positive" }

        width *= zoom
        height *= zoom
    }

    override fun rotate(
        direction: RotateDirection,
        centerX: Int,
        centerY: Int
    ) {
        val cx = x + width / 2
        val cy = y + height / 2

        val dx = cx - centerX
        val dy = cy - centerY

        when (direction) {
            RotateDirection.Clockwise -> {
                x = centerX - dy - height / 2
                y = centerY + dx - width / 2
            }

            RotateDirection.CounterClockwise -> {
                x = centerX + dy - height / 2
                y = centerY - dx - width / 2
            }
        }

        val oldWidth = width
        width = height
        height = oldWidth
    }
}
