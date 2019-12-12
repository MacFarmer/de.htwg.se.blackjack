package de.htwg.se.blackjack.model

class Card(val face: String, val suit: String) {
  override def toString: String = {
    val a = if (face == "Ace" || face == "8") "an " else "a "
    a + face + " of " + suit
  }
  def value: Int = face match {
    case "Ace" => 11
    case "Jack" => 10
    case "Queen" => 10
    case "King" => 10
    case _ => face.toInt
  }
}