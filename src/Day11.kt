package bho.harisont.aoc.day11

import bho.harisont.aoc.day09.readIntGrid

typealias OctoGrid = MutableList<MutableList<Int>>

fun step(g: OctoGrid): Int {
    var flashes = 0
    
    for (i in 0..g.size - 1)
        for (j in 0..g.size - 1)
            g[i][j]++

    fun incrNeighbours(i: Int,j: Int) {
        for (x in (i - 1)..(i + 1))
            for (y in (j - 1)..(j + 1))
                if (x in 0..g.size - 1 && y in 0..g[0].size - 1)
                    if (g[x][y] >= 0)
                        g[x][y]++
    }

    fun flash() {
        if (g.any { it.any {it > 9} })
            for (i in 0..g.size - 1)
                for (j in 0..g.size - 1)
                    if (g[i][j] > 9) {
                        flashes++
                        g[i][j] = -1
                        incrNeighbours(i,j)
                        flash()
                    }
        return
    }

    flash()

    for (i in 0..g.size - 1)
        for (j in 0..g.size - 1)
            if (g[i][j] == -1)
                g[i][j]++

    return flashes
}

fun part1(path: String): Int {
    val grid = readIntGrid(path).map {it.toMutableList() }.toMutableList()
    var tot = 0
    for (i in 1..100) {
        tot += step(grid)
    }
    return tot
}

fun part2(path: String): Int? = null