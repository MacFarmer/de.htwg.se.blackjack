package de.htwg.se.blackjack.model.deckComponent.deckBaseImpl

import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory

object DeckSingleton {
  val cardsSingelton = new Array[CardFactory](52)
  var count = 52

  DeckSingleton.cardsSingelton

  val Suits = Array("Clubs", "Spades", "Hearts", "Diamonds")
  val Faces = Array("2", "3", "4", "5", "6", "7", "8", "9", "10",
    "Jack", "Queen", "King", "Ace")
}
