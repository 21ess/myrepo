package com.suda.lambda.collection_enhance

import java.util.TreeSet

/**
 *
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/11/22$
 */

data class student(val name: String, val age: Int, var sex: String, val score: Int)

fun main() {
    // 构造集合的方法
    // 1. listOf, setOf, mutableListOf mutableSetOf
    val list = listOf(1, 2, 3)
    val set = setOf(1, 1, 2, 2, 3, 3)
    // 使用to infix 函数会产生Pair类型，有额外的消耗
    val mutableMap1 = mutableMapOf(1 to 'a', 2 to 'b', 3 to 'c')
    val mutableMap2 = mutableMapOf<Int?, String?>().apply { this[1] = "a"; this[2] = "b"; this[3] = "c" }
    println(list)
    println(set)
    println(mutableMap1)
    println(mutableMap2)

    // 2. 使用builder来创建集合
    var map = buildMap<Int?, String?> {
        put(1, "a")
        put(2, "b")
        put(3, "c")
    }
    println(map)

    // 3. 使用
}