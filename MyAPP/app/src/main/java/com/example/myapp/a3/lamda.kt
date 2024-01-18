package com.example.myapp.a3

fun sum(num1:Int, num2:Int):Int{
    return num1+num2
}
val result2={num1:Int, num2:Int -> num1+num2}
fun main(){
    val result=sum(10,20)
    println("result:$result")
    println("result2:${result2(10,20)}")

}