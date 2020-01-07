package de.htwg.se.blackjack.controller

object GameState extends Enumeration {

  type GameState = Value
  val WON = Value(1)
  val LOST = Value(-1)
  val BUST = LOST
  val PUSH = Value(0)

}
