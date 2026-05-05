//EX1
class Car(val model: String)

//EX2
data class Book(val title: String)

//EX3
open class Animal {
    fun sound(){
        println("Animal sound")
    }
}
class Cat : Animal()

//EX9
object Logger{
    fun log(msg: String){
        println("LOG: $msg")
    }
}

fun main(){
    //EX1
    val car = Car("Mercedes")
    println(car.model)

    //EX2
    val book = Book("Atomic Habits")
    println(book)

    //EX3
    val cat = Cat()
    cat.sound()

    //EX4
    val fruits = listOf("Apple", "Orange", "Banana")
    println(fruits[1])

    //EX5
    val numbers = mutableListOf(1,2,3)
    numbers.add(22)
    println(numbers)

    //EX6
    fruits.forEach{
        println(it.uppercase())
    }

    //EX7
    val a = listOf(1,3,5,7,9,2,8)
    val filtered = a.filter{it > 5}
    println(filtered)

    //EX8
    val b = listOf(1,2)
    val strings = b.map {it.toString()}
    println(strings)

    //EX9
    Logger.log("Application started")

}