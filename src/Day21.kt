package bho.harisont.aoc.day21

import java.io.File


fun part1(path: String): Int {
    var (p1,p2) = File(path).readLines().map { 
        val tokens = it.split(" ")
        tokens[tokens.size - 1].toInt()
    }
    var s1 = 0
    var s2 = 0
    var t = 0
    var sum: Int
    
    while (true) {
        sum = 0
        for (i in 1..3) {
            t++
            sum += t
        }
        p1 = if ((p1 + sum) % 10 == 0) 10 else (p1 + sum) % 10 
        s1 += p1
        if (s1 >= 1000) 
            return t * s2
        sum = 0
        for (i in 1..3) {
            t++
            sum += t
        }
        p2 = if ((p2 + sum) % 10 == 0) 10 else (p2 + sum) % 10 
        s2 += p2
        if (s2 >= 1000) 
            return t * s1
    }
}

fun part2(path: String): Int = 0

//fun main() {
//    println(part1("../data/day21.txt"))
//}