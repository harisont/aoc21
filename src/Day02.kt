package bho.harisont.aoc.day02

import java.io.File

typealias Direction = Pair<String,Int>
typealias Route = List<Direction>


fun readRoute(path: String): Route {
    return File(path).readLines().map { 
        val split = it.split(" ")
        Pair(split[0], split[1].toInt()) 
    }
}

fun finalPosition1(route: Route): Pair<Int,Int> {

    fun delta(route: Route, dir: String): Int = 
        route.filter { it.first == dir }.map { it.second }.sum()
    
    return Pair(
            delta(route,"forward"), 
            delta(route,"down") - delta(route,"up"))
}

fun finalPosition2(route: Route): Pair<Int,Int> {
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