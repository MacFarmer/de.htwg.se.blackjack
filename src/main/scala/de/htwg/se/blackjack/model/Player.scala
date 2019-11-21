package de.htwg.se.blackjack.model

case class Player(name: String, cards: List[Card]) {
  def takeCard(card: Option[Card]): Player = {
    card match {
      case Some(x) => this.copy(cards = x :: cards)
      case None => this
    }
  }

  override def toString:String ={
    name + "'s cards: " + cards
  }
}
