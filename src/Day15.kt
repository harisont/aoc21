package bho.harisont.aoc.day15

import bho.harisont.aoc.day09.readIntGrid

typealias Graph = List<List<Int>>
typealias Node = Pair<Int,Int>

fun dijkstra(graph: Graph, src: Node, dst: Node) {
    val queue = listOf(Pair(0, src))
    
}

fun part1(path: String): Int {
    val graph = readIntGrid(path)
    val (h,w) = Pair(graph.size, graph[0].size)
    dijkstra(graph, Pair(0,0), Pair(h - 1, w - 1))
    return 0
}
fun part2(path: String): Int = 0
