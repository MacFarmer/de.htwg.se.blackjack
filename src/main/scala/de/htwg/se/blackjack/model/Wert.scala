package de.htwg.se.blackjack.model

sealed abstract class Wert(val value: Int) {

  // repräsentiert die Kartenwerte je nach Rang
  case object King extends Wert(10)
  case object Queen extends Wert(10)
  case object Jack extends Wert(10)
  case object Ten extends Wert(10)
  case object Nine extends Wert(9)
  case object Eight extends Wert(8)
  case object Seven extends Wert(7)
  case object Six extends Wert(6)
  case object Five extends Wert(5)
  case object Four extends Wert(4)
  case object Three extends Wert(3)
  case object Two extends Wert(2)
  case object Ace1 extends Wert(1)
  case object Ace11 extends Wert(11)
}
