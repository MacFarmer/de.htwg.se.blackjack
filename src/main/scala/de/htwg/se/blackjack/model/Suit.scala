package de.htwg.se.blackjack.model

sealed trait Suit {

  case object Heart extends Suit

  case object Diamond extends Suit

  case object Spade extends Suit

  case object Club extends Suit

}