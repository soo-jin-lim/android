package com.example.myapp.a2

fun some3(){
    val data1:Any=10
    data1="Hello"
    data1=10.1

}

fun func3():Nothing?{
    throw Exception()
}

fun func2():Nothing?{
    return null
}

fun func1(data1:Int,data2:Double):Double{//함수의 매개변수는 val 나 var를 붙이면 안됨
    return data1+data2
}

fun main(){
    var data= func1(10,10.5)
    println(data)
}

fun func4(data:Int){
    val data1=data+10
}
fun func5(data1: Int, data2: Int=10){
    return data1+data2
}

fun main(){
    println(func5(10,20))
    println(func5(10,20))
    println(func5(10))

    var data= func1(10,10.5)
    println(data)
    println(func2())
}

