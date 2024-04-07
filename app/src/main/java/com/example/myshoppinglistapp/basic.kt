package com.example.myshoppinglistapp

import androidx.compose.ui.text.toUpperCase

fun main(){
//    val number = listOf(1,2,3)
//    val double = number.map { it*2 }
//    println(double)
//    println(number)

//    val bluRose = Vase(color = "Blue", design = "Rose")
//    val redRoseVase = bluRose.copy(color = "red" , design = "Sun")
//    println(bluRose)
//    println(redRoseVase)
    //nullable string
    val name : String? = "Ella "
    name?.let {
        println(it.lowercase())
    }

}
data class Vase(val color : String, val design:String)