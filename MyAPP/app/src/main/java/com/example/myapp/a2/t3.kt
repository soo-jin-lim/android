package com.example.myapp.a2

import com.example.myapp.a1
var //패키지안에 있는것들이 서로 공유되니깐 그냥 바로 쓰면됨
fun main(){
    print(a)
}
fun some1(){
    var data:Int=10
//    var data:Int=null //코틀린은 기본데이터 형도 전부 객체(이거는 오류임  널 허용 안함)
    var data3:Int?=null //값을 사용하다보면 null인 경우도 있는데 ?를 쓰면 null을 허용한다는 뜻
    data1=data1+10
    data1.plus(10)
    println(data1)
}

fun main{
    some1()
    //print(a)
    //정수형 변수에서 할 수 있는검 멀티플 여러가지 있음 데이타 1에다가 10을 더했다 저렇게대입하면 20이 됐다가
    //데이터는 보면 정수형을 사용해봄

}
fun some2(){
    var al:Byte=0b00001011//byte 2진수
    val a2:Int=123
    val a4:Long=12L//Long은 값을 넣을 때 L을 해줘야함
    val a5:Double=10.0
    var a6:Float=10.0F
    val a7:Boolean=true //true or False가 가능함
    val a8:Char='A'
    val a9:String="android"//따라서 데이터 형에 맞도록 상수를 어떻게 하는가
    val a10:String="""
        Hello
        world
        android
    """.trimIndent()
    println("$a1, $a2, $a3,$a4,$a5,$a6,$a7,$a8,$a9")
    println(a10)

}
fun main(){
    some2()
    some1()
}