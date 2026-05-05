package com.example.playground

fun main(){
    //EX1
    val name = "Crina"
    var age = 20

    println("Name is $name")
    println("Age is $age")

    //EX2
    val c: String? = null
    val length = c?.length ?: 0
    println("The length of c is $length")

    //EX3
    val n = 9.99
    val d = n.toInt()
    println("The value converted is $d")

    //EX4
    val code = 404
    val message = when(code){
        200 -> "Success"
        404 -> "Not Found"
        508 -> "Server Error"
        else -> "Unknown code"
    }
    println("HTTP response: $message")

    //EX5
    val array = intArrayOf(1,2,3,4,5)
    for(i in array){
        if(i % 2 == 0){
            println(i)
        }
    }

    //EX6
    val result = multiply(3,4)
    println("The result is: $result")

    //EX7
    for(i in 10 downTo 1){
        println(i)
    }
    println("Launch!")

    //EX8
    val address = """{city: Iasi, street: Lalelelor, number: 22}""".trimIndent()
    println(address)

    //EX9
    val a = "Claudia"
    // a = "Jennifer"
    //'val' cannot be reassigned.
}

//the function for EX5 (multiply)
fun multiply(a: Int, b: Int): Int{
    return a * b
}