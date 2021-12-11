package bho.harisont.aoc

import bho.harisont.aoc.day01.part1 as day01part1 
import bho.harisont.aoc.day01.part2 as day01part2 
import bho.harisont.aoc.day02.part1 as day02part1 
import bho.harisont.aoc.day02.part2 as day02part2 
import bho.harisont.aoc.day03.part1 as day03part1
import bho.harisont.aoc.day03.part2 as day03part2 
import bho.harisont.aoc.day04.part1 as day04part1 
import bho.harisont.aoc.day04.part2 as day04part2 
import bho.harisont.aoc.day05.part1 as day05part1 
import bho.harisont.aoc.day05.part2 as day05part2 
import bho.harisont.aoc.day06.part1 as day06part1 
import bho.harisont.aoc.day06.part2 as day06part2 
import bho.harisont.aoc.day07.part1 as day07part1
import bho.harisont.aoc.day07.part2 as day07part2 
import bho.harisont.aoc.day08.part1 as day08part1 
import bho.harisont.aoc.day08.part2 as day08part2  
import bho.harisont.aoc.day09.part1 as day09part1 
import bho.harisont.aoc.day09.part2 as day09part2 
import bho.harisont.aoc.day10.part1 as day10part1 
import bho.harisont.aoc.day10.part2 as day10part2 
import bho.harisont.aoc.day11.part1 as day11part1 
import bho.harisont.aoc.day11.part2 as day11part2

val funs = listOf(
    Pair(day01part1("../data/day01.txt"), day01part2("../data/day01.txt")),
    Pair(day02part1("../data/day02.txt"), day02part2("../data/day02.txt")),
    Pair(day03part1("../data/day03.txt"), day03part2("../data/day03.txt")),
    Pair(day04part1("../data/day04.txt"), day04part2("../data/day04.txt")),
    Pair(day05part1("../data/day05.txt"), day05part2("../data/day05.txt")),
    Pair(day06part1("../data/day06.txt"), day06part2("../data/day06.txt")),
    Pair(day07part1("../data/day07.txt"), day07part2("../data/day07.txt")),
    Pair(day08part1("../data/day08.txt"), day08part2("../data/day08.txt")),
    Pair(day09part1("../data/day09.txt"), day09part2("../data/day09.txt")),
    Pair(day10part1("../data/day10.txt"), day10part2("../data/day10.txt")),
    Pair(day11part1("../data/day11.txt"), day11part2("../data/day11.txt"))

)

val dailyFuns = (1..25).toList().zip(funs).toMap()

val todo = "not implemented yet"

fun main(args: Array<String>) {
    val range = 1..25
    val days = 
        if (args.size == 0) range.toList() 
        else args
                .map { it.toIntOrNull() }
                .filter { it != null && it in range }

    for (day in days) {
        println("Day $day:")
        println("- part 1: ${dailyFuns.get(day)?.first ?: todo}")
        println("- part 2: ${dailyFuns.get(day)?.second ?: todo}")
    }
}   