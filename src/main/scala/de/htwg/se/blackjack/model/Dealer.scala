package de.htwg.se.cards.model
import de.htwg.se.blackjack.model.Card

import scala.util.Random

case class Dealer(cards: List[Card]) {
  def drop(): (Dealer, Option[Card]) = {
    if (this.cards.isEmpty) {
      (this, None)
    } else {
      (Dealer(this.cards.tail), Some(this.cards.head))
    }
  }

  def shuffle(): Dealer = {
    Dealer(Random.shuffle(this.cards))
  }
}