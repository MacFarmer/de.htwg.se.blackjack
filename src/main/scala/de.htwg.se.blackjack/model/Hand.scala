package de.htwg.se.blackjack.model

class Hand {
  // Compute the value of a hand of cards.
  def handValue(hand: Array[Card]): Int = {
    var value = 0
    for (card <- hand)
      value += card.value
    value
  }

}