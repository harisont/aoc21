import java.io.File

fun nIncreases(path: String): Int {
    val lines = File(path).readLines()
    var increases = 0
    for (i in 0..lines.size - 2) {
        if (lines[i + 1].toInt() > lines[i].toInt())
            increases++
    }
    return increases
}

fun n3Increases(path: String): Int {
    val lines = File(path).readLines()
    var increases = 0
    for (i in 0..lines.size - 4) {
        if (lines[i + 1].toInt() + lines[i + 2].toInt() + lines[i + 3].toInt() > lines[i].toInt() + lines[i + 1].toInt() + lines[i + 2].toInt())
            increases++
    }
    return increases
}

fun main() {
    println(nIncreases("input.txt"))
    println(n3Increases("input.txt"))
}