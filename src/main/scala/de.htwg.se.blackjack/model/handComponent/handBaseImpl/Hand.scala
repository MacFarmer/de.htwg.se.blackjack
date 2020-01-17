package de.htwg.se.blackjack.model.handComponent.handBaseImpl

import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.handComponent.HandInterface

class Hand extends HandInterface {
  // Compute the value of a hand of cards.
  def handValue(hand: Array[CardFactory]): Int = {
    var value = 0
    for (card <- hand)
      value += card.apply(value)
    value
  }
}