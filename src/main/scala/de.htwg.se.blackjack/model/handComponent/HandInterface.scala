package de.htwg.se.blackjack.model.handComponent

import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory

trait HandInterface {
  def handValue(hand: Array[CardFactory]): Int
}
