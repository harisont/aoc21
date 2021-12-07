import java.io.File
import kotlin.math.abs

typealias Pos = Int

fun totCost(position: Pos, positions: List<Pos>): Pos {
    return positions.map { abs(it - position) }.sum()
}

fun minCost(positions: MutableList<Pos>): Pos {
    positions.sort()
    var minCost = totCost(positions[0], positions)
    for (position in positions.slice(1..positions.size - 1)) {
        val posCost = totCost(position, positions)
        if (posCost < minCost)
            minCost = posCost
    }
    return minCost
}

fun main () {
    // TODO: generalize to also use in Six (and more), readCommaSeparatedInts
    val positions = File("input.txt")
                        .readText()
                        .replace("\n", "")
                        .split(",")
                        .map { it.toInt() }
                        .toMutableList()
    println("Part 1: ${minCost(positions)}")
}