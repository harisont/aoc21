package bho.harisont.aoc.day06

import java.io.File

typealias Lanternfish = Int

fun readCommaSeparatedInts(path: String) = File(path)
                                            .readText()
                                            .replace("\n", "")
                                            .split(",")
                                            .map { it.toInt() }
                                            .toMutableList()

fun nFish80(fish: MutableList<Int>): Int {    
    for (i in 1..80) {
        var nNews = 0
        for (f in 0..fish.size - 1) {
            if (fish[f] == 0) {
                fish[f] = 6
                nNews += 1
            }
            else
                fish[f] -= 1
        }
        for (f in 1..nNews) {
            fish.add(8)
        }
    }
    return fish.size
}


fun part1(path: String): Int = nFish80(readCommaSeparatedInts(path))
fun part2(path: String): Int? = null