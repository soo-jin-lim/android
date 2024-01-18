package com.example.myapp.a3

for main(){
    val a=Array<Int>(10,{0})
    println(a)
    println(a.size)
    println(a.contentToString())
    a[0]=10
    a[1]=20
    a.set(2,30)
    println(a.contentToString())
    println("$a{[0]},$a{[1]},${a.get(2)}"

    '''')

    fun main(){
        var map= mapOf<String,Int>(Pair("kim",80),"lee" to 85)
        println(map.get("kim"))
    }
}