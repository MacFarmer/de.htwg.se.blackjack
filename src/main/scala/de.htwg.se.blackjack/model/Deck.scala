package de.htwg.se.blackjack.model

object Deck {
   val cards = new Array[CardFactory](52)
   var count = 52


  val Suits = Array("Clubs", "Spades", "Hearts", "Diamonds")
  val Faces = Array("2", "3", "4", "5", "6", "7", "8", "9", "10",
    "Jack", "Queen", "King", "Ace")
}