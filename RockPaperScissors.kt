package com.example.rockpaperscissors

fun main(){
    var computerChoice = ""
    var playerChoice = ""
    println("Rock , Paper or Scissor; Which you wanna choose")
    playerChoice = readln()
    while(playerChoice != "Rock" && playerChoice !=  "Paper" && playerChoice != "Scissors"){
        playerChoice = readln()
    }
    when ((1..3).random()) {
        1 -> {
            computerChoice = "Rock"
        }
        2 -> {
            computerChoice = "Paper"
        }
        3 -> {
            computerChoice = "Scissors"
        }
    }
    println(computerChoice)
    val winner = when{
        playerChoice == computerChoice -> "Tie"
        playerChoice == "Rock" && computerChoice == "Scissors" -> "Player"
        playerChoice == "Paper" && computerChoice == "Rock" -> "Player"
        playerChoice == "Scissors" && computerChoice == "Paper" -> "PLayer"
        else -> "Computer"
    }
    if (winner == "Tie"){
        println("It's a Tie")
    }else if (winner == "Player"){
        println("$winner Won")
    }else{
        println("$winner Won")
    }
}