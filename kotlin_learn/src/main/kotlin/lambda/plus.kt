package com.suda.lambda

/**
 *
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/11/22$
 */
class HTML {
    fun body() {}
}

fun main() {
    val sum: Int.(Int) -> Int = {other -> plus(other)}
    var x = 2
    x = x.sum(1)
    println(x)
    val html = HTML()
    fun html(init: HTML.() -> Unit): HTML{
        val html = HTML()
        html.init()
        return html
    }
    html{
        body()
    }
    val arr = arrayOf(1, 2, 3, 4)
    var list = arr.map { it -> it * 2 }

}