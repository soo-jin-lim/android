package com.example.myapp.a3

fun main(){
    var data=10


    if(data>0){
        println("data>0")
    }else{
        println("data<=0")
    }

    if(data>9){
        println("9이상")
    }else if(data>8){
        println("9보다 작고 8보다 크거나 같다")
    }else if(data>=7){
        println("8보다 작고 7보다 크거나 같다")
    }else{
        println("7미만")
    }

}