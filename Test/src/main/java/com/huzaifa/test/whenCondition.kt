package com.huzaifa.test

fun main(){
    println("Hello World")

    val age = 55;

    // When can act as a Switch Statement:
    when(age){
        18 -> println("You are too young to vote")
        50 -> println("You can vote now")
        else -> println("Age not found")
    }

    // Range:
    val isValid = age in 1..100;
    println(isValid);

    val isLessThan100 = age in 1 until 100;
    println(isLessThan100);
}