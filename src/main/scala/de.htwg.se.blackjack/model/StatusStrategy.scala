package de.htwg.se.blackjack.model

import scala.io.StdIn.readLine

class StatusStrategy {

  var deck = DeckSingleton

  def generateDeck(): Unit = {
    var i = 0
    for (suit <- deck.Suits) {
      for (face <- deck.Faces) {
        deck.cardsSingelton(i) = new CardFactory(face, suit)
        i += 1
      }
    }
  }

  def shuffleDeck(): Unit = {
    for (i <- 1 to 52) {
      // 0..i-2 already shuffled
      val j = (math.random * i).toInt
      val cj = deck.cardsSingelton(j)
      deck.cardsSingelton(j) = deck.cardsSingelton(i-1)
      deck.cardsSingelton(i-1) = cj
    }
  }

  def draw(): CardFactory = {
    assert(DeckSingleton.count > 0)
    deck.count -= 1
    deck.cardsSingelton(deck.count)
  }

  def handValue(hand: Array[CardFactory]): Int = {
    var value = 0
    for (card <- hand)
      value += card.apply(value)
    value
  }
}
