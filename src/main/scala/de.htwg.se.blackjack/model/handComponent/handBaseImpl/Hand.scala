package de.htwg.se.blackjack.model

class Hand {
  // Compute the value of a hand of cards.
  def handValue(hand: Array[CardFactory]): Int = {
    var value = 0
    for (card <- hand)
      value += card.apply(value)
    value
  }
}