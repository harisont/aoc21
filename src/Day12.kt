package bho.harisont.aoc.day12

import java.io.File
import com.sun.tools.attach.AgentLoadException

typealias Edge<T> = Pair<T,T>
typealias AdjList<T> = MutableMap<T,MutableList<T>>

fun readGraph(path: String): List<Edge<String>> {
    return File(path).readLines().map {
        val split = it.split("-")
        Pair(split[0],split[1])
    }  
} 

fun edges2adjList(edges: List<Edge<String>>): AdjList<String> {
    var revEdges = edges.map { Pair(it.second, it.first)} 
    var adj: AdjList<String> = mutableMapOf()
    for (edge in edges + revEdges) { // cause it's an undirected graph
        if (edge.first in adj.keys) 
            adj[edge.first]?.add(edge.second)
        else
            adj.put(edge.first, mutableListOf(edge.second))
    }
    return adj
}

fun allPaths(
    adj: AdjList<String>,
    visited: MutableList<String>,
    path: MutableList<String>,
    paths: MutableList<MutableList<String>>,
    src: String="start",
    dst: String="end"
) {
    if (src == dst) {
        paths.add(path)
        return
    }
    else {
        visited.add(src)
        for (nxt in adj[src]!!) {
            if (!(nxt in visited && nxt.lowercase() == nxt)) {
                path.add(nxt)
                allPaths(adj, visited, path, paths, nxt, dst)
                path.remove(nxt)
            }
        }
        visited.remove(src)
    }
}

fun part1(path: String): Int {
    var paths: MutableList<MutableList<String>> = mutableListOf(mutableListOf("start"))
    allPaths(edges2adjList(readGraph(path)), mutableListOf(), mutableListOf(), paths)
    return 0
}
fun part2(path: String): Int? = null