// companion object are static variables

// 'private constructor()' makes the class private so only the factory function 'createStudent()' can create student
class Student private constructor() {
    companion object {
        const val ID_COUNTER = "ID_Counter"
        fun createStudent() : Student {
          return Student()
        }

    }
}

// you can name the companion object
class Student2 private constructor() {

    var firstname : String? = null
    var lastname : String? = null

    companion object Loader {
        fun loadStudent(data: Pair<String, String>) : Student2 {
            var student2 = Student2()
            student2.firstname = data.first
            student2.lastname = data.second
            return student2
        }
//        const val ID_COUNTER = "ID_Counter"

    }
}
// companion object could be a nice helper tool

// ----------------------interface----------------------
interface Shape {
    var width: Int
    var height: Int
    fun draw()
}

class Circle(override var width: Int, override var height: Int) : Shape {
    override fun draw() {
        println("draw circle")
    }

}

class Line(override var width: Int, override var height: Int) : Shape {
    override fun draw() {
        println("draw line")
    }
}

// -----------------------Enum---------------------------
enum class Direction {
    NORTH, SOUTH, WEST, EAST;

    fun printDirection() {
        println("I am going $this")
    }
}

fun drive(direction: Direction) {
    when (direction) {
        Direction.NORTH -> println("Drive NORTH")
        Direction.SOUTH -> println("Drive SOUTH")
        Direction.WEST -> println("Drive WEST")
        Direction.EAST -> println("Drive EAST")
    }
}

// Extension
fun String.lastChar() : Char = this.get(this.length - 1)

fun main(args: Array<String>) {

    // -----------------companion object-------------------
    val student = Student2.loadStudent(Pair("Harry", "Potter"))

    // --------------------interface----------------------
    val circle = Circle(3, 3)
    var line = Line(1, 5)
    circle.draw()
    line.draw()

    // ----------------------ENUM--------------------------
    drive(Direction.NORTH)                                  // Drive NORTH
    println(Direction.SOUTH.printDirection())               // I am going SOUTH
    println(Direction.EAST.ordinal)                         // 3
    println(Direction.valueOf("EAST"))                // EAST

    // --------------------Extension----------------------
    println("abcdefg".lastChar())

}