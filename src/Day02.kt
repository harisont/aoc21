package bho.harisont.aoc.day02

import java.io.File

fun readRoute(path: String): List<Pair<String,Int>> {
    return File(path).readLines().map { 
        val split = it.split(" ")
        Pair(split[0], split[1].toInt()) 
    }
}

fun delta(route: List<Pair<String,Int>>, dir: String): Int {
    return route.filter { it.first == dir }.map { it.second }.sum()
}

fun finalPosition1(route: List<Pair<String,Int>>): Pair<Int,Int> {
    return Pair(
        delta(route,"forward"), 
        delta(route,"down") - delta(route,"up"))
}

fun finalPosition2(route: List<Pair<String,Int>>): Pair<Int,Int> {
    var aim = 0
    var h = 0
    var d = 0
    for ((dir, n) in route) {
        when (dir) {
            "down" -> aim += n
            "up" -> aim -= n
            "forward" -> {
                h += n
                d += aim * n
            }
        }
    }
    return Pair(h,d)
}

fun part1(path: String): Int {
    val route = readRoute(path)
    val (h1,d1) = finalPosition1(route)
    return h1 * d1
}

fun part2(path: String): Int {
    val route = readRoute(path)
    val (h1,d1) = finalPosition2(route)
    return h1 * d1
}