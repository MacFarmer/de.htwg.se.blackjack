package de.htwg.se.blackjack.model

case class Card(suit: String, value: String) {
  override def toString: String = {
    String.format(suit+value)
  }

  def getSuit(): String = {
    suit
  }

  def getValue(): String = {
    value
  }

  def test() = {
    ()
  }
}






