package bho.harisont.aoc

import java.io.File

typealias Lanternfish = Int

fun main() {
    val fish = File("../data/day06.txt")
                .readText()
                .replace("\n", "")
                .split(",")
                .map { it.toInt() }
                .toMutableList()
        
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

    println("Part 1: ${fish.size}")
}