package bho.harisont.aoc.day14

import java.io.File

typealias Template = CharArray
typealias Left = Pair<Char,Char>
typealias Right = Char
typealias Rule = Pair<Left,Right>

fun readPolymerInput(path: String): Pair<Template,Map<Left,Right>> {
    val (part1,part2) = File(path).readText().split("\n\n")
    val rules = part2.split("\n")
                .filter{ it != "" }
                .map { it.split(" -> ") }
                .map { 
                    Pair(
                        Pair(
                            it[0].toCharArray()[0],it[0].toCharArray()[1]), 
                            it[1].toCharArray()[0]
                        )
                    }
    return Pair(part1.toCharArray(), rules.toMap())
}

fun step(temp: Template, rules: Map<Left,Right>): Template {
    var newTemp: MutableList<Char> = mutableListOf(temp[0])
    for (i in 0..temp.size - 2) {
        val first = temp[i]
        val second = temp[i + 1]
        val left = Pair(first, second)
        if (left in rules) {
            //newTemp.add(first)
            newTemp.add(rules[left]!!)
            newTemp.add(second)
        }
    }
    return newTemp.toCharArray()
}

fun part1(path: String): Int {
    var (temp, rules) = readPolymerInput(path)
    for (i in 1..10) {
        temp = step(temp, rules)
    }
    val groups = temp.toList().groupingBy { it }.eachCount()
    val max = groups.maxByOrNull { it.value }
    val min = groups.minByOrNull { it.value }
    return max!!.value - min!!.value 
}

fun part2(path: String): Int = 0