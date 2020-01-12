package de.htwg.se.blackjack.model

import scala.io.StdIn.readLine

class StatusStrategy {

  var deck = DeckSingleton

  def generateDeck(): Unit = {
    var i = 0
    for (suit <- deck.Suits) {
      for (face <- deck.Faces) {
        deck.cards(i) = new Card(face, suit)
        i += 1
      }
    }
  }

  def shuffleDeck(): Unit = {
    for (i <- 1 to 52) {
      // 0..i-2 already shuffled
      val j = (math.random * i).toInt
      val cj = deck.cards(j)
      deck.cards(j) = deck.cards(i-1)
      deck.cards(i-1) = cj
    }
  }

  def draw(): Card = {
    assert(DeckSingleton.count > 0)
    deck.count -= 1
    deck.cards(deck.count)
  }

  def handValue(hand: Array[Card]): Int = {
    var value = 0
    for (card <- hand)
      value += card.value
    value
  }
}
