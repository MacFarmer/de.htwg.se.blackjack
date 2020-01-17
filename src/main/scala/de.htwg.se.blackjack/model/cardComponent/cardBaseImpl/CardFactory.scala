package de.htwg.se.blackjack.model.cardComponent.cardBaseImpl

import de.htwg.se.blackjack.model.cardComponent.cardInterface

case class CardFactory(val face: String, val suit: String) extends cardInterface {
  override def toString: String = {
    val a = if (face == "Ace" || face == "8") "an " else "a "
    //Dialog.showMessage(message = null, icon = new ImageIcon("image\\cards\\"+face+suit+".jpg"))
    a + face + " of " + suit
  }
  def apply(value: Int) = face match {
    case "Ace" => 11
    case "Jack" => 10
    case "Queen" => 10
    case "King" => 10
    case _ => face.toInt
  }
}
