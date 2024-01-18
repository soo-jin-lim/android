package com.example.myapp.a3

fun main(){
    var data:IntArray= intArrayOf(10,20,30)

    for(i in data){
        println(i)
    }

    for((index, value )in data.withIndex()){//data의 값과 index를 함께 가져옴
        print(value)
        if(index!==data.size-1){
            print(",")
        }
    }


    for(i in data.indices){
        print(data[i])
        if(i!==data.size-1){
            print(",")
        }
    }


    for (i in 1..5) {
        for (j in 1 .. i) {
            print("*")
        }
        println("")
    }
}
