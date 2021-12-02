import java.io.File

fun readInts(path: String): List<Int> {
    return File(path).readLines().map{ it.toInt() }
}

fun nIncreases(ints: List<Int>): Int {
    var increases = 0
    for (i in 0..ints.size - 2) {
        if (ints[i + 1] > ints[i])
            increases++
    }
    return increases
}

fun n3Increases(ints: List<Int>): Int {
    var increases = 0
    for (i in 0..ints.size - 4) {
        if (ints.slice(i + 1..i + 3).sum() > ints.slice(i..i + 2).sum())
            increases++
    }
    return increases
}

fun test01(ints: List<Int>) {
    assert(nIncreases(ints) == 1696)
    assert(n3Increases(ints) == 1737)
}

fun main() {
    val ints = readInts("input.txt")
    test01(ints)
    println("Part 1: ${nIncreases(ints)}")
    println("Part 2: ${n3Increases(ints)}")
}