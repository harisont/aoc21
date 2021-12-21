package bho.harisont.aoc.day20

import java.io.File
import kotlin.math.pow 

typealias Algorithm = List<Boolean>

typealias Image = List<List<Boolean>>

fun readImage(img: String): Image {
    return img.split("\n")
        .filter { it != "" }
        .map { it.toCharArray().map { it == '#' } }
}

fun readAlgorithm(alg: String): Algorithm = 
    alg.toCharArray().map { it == '#' }

fun readImageInput(path: String): Pair<Algorithm,Image> {
    val (part1,part2) = File(path).readText().split("\n\n")
    return Pair(readAlgorithm(part1), readImage(part2))
}

fun enhance(img: Image, alg: Algorithm): Image {

    fun get(i: Int, j: Int) = 
        if (i >= 0 && i < img.size && j >= 0 && j < img.size) 
            img[i][j] 
        else false

    fun toDec(bools: List<Boolean>): Int {
        var n = 0
        val rev = bools.reversed()
        for (i in 0..rev.size - 1) {
            val incr = if (rev[i]) 2.toDouble().pow(i).toInt() else 0
            n += incr
        }
        return n
    }

    var newImg: MutableList<MutableList<Boolean>> = mutableListOf()
    for (i in 0..img.size - 1) {
        var row: MutableList<Boolean> = mutableListOf()
        for (j in 0..img[0].size - 1) {
            val bin = listOf(get(-1,-1), get(-1,0), get(-1,1), 
                             get(0,-1), get(0,0), get(0,1), 
                             get(1,-1), get(1,0), get(1,1)
                             )
            row.add(alg[toDec(bin)])
        }
        newImg.add(row)
    }
    return newImg
}

fun part1(path: String): Int {
    val (alg,img) = readImageInput(path)
    val outImg = enhance(enhance(img, alg), alg)
    println(outImg)
    return outImg.map { it.filter { it }.count() }.sum()
}

fun part2(path: String): Int = 0

//fun main() {
//    println(part1("../data/day20.txt"))
//}