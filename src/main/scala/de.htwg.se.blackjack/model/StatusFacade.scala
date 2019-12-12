package de.htwg.se.blackjack.model

import scala.io.StdIn.readLine

class StatusFacade {

  def generateDeck(): Unit = {
    var i = 0
    for (suit <- DeckSingleton.Suits) {
      for (face <- DeckSingleton.Faces) {
        DeckSingleton.cards(i) = new Card(face, suit)
        i += 1
      }
    }
  }

  def shuffleDeck(): Unit = {
    for (i <- 1 to 52) {
      // 0..i-2 already shuffled
      val j = (math.random * i).toInt
      val cj = DeckSingleton.cards(j)
      DeckSingleton.cards(j) = DeckSingleton.cards(i-1)
      DeckSingleton.cards(i-1) = cj
    }
  }

  def draw(): Card = {
    assert(DeckSingleton.count > 0)
    DeckSingleton.count -= 1
    DeckSingleton.cards(DeckSingleton.count)
  }

  def handValue(hand: Array[Card]): Int = {
    var value = 0
    for (card <- hand)
      value += card.value
    value
  }
}
