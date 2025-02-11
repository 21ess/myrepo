package com.suda.typesys

/**
 *
 * @author alien
 * @program myrepo
 * @description
 * @date 2024/11/17$
 */

data class Teacher(val name: String) : Human(){

}

open class Human()

fun getTeacher() : Human {
    return Teacher("kotlin")
}

fun main() {

}