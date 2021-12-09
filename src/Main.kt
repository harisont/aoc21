package bho.harisont.aoc

import bho.harisont.aoc.day01.part1 as day1part1 
import bho.harisont.aoc.day01.part2 as day1part2 
import bho.harisont.aoc.day02.part1 as day2part1 
import bho.harisont.aoc.day02.part2 as day2part2 
import bho.harisont.aoc.day03.part1 as day3part1
import bho.harisont.aoc.day03.part2 as day3part2 
import bho.harisont.aoc.day04.part1 as day4part1 
import bho.harisont.aoc.day04.part2 as day4part2 
import bho.harisont.aoc.day05.part1 as day5part1 
import bho.harisont.aoc.day05.part2 as day5part2 
import bho.harisont.aoc.day06.part1 as day6part1 
import bho.harisont.aoc.day06.part2 as day6part2 
import bho.harisont.aoc.day07.part1 as day7part1
import bho.harisont.aoc.day07.part2 as day7part2 
import bho.harisont.aoc.day08.part1 as day8part1 
import bho.harisont.aoc.day08.part2 as day8part2  
import bho.harisont.aoc.day09.part1 as day9part1 
import bho.harisont.aoc.day09.part2 as day9part2 

val funs = listOf(
    Pair(day1part1("../data/day01.txt"), day1part2("../data/day01.txt")),
    Pair(day2part1("../data/day02.txt"), day2part2("../data/day02.txt")),
    Pair(day3part1("../data/day03.txt"), day3part2("../data/day03.txt")),
    Pair(day4part1("../data/day04.txt"), day4part2("../data/day04.txt")),
    Pair(day5part1("../data/day05.txt"), day5part2("../data/day05.txt")),
    Pair(day6part1("../data/day06.txt"), day6part2("../data/day06.txt")),
    Pair(day7part1("../data/day07.txt"), day7part2("../data/day07.txt")),
    Pair(day8part1("../data/day08.txt"), day8part2("../data/day08.txt")),
    Pair(day9part1("../data/day09.txt"), day9part2("../data/day09.txt"))
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