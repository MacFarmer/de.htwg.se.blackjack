package de.htwg.se.blackjack.controller

import de.htwg.se.blackjack.model.Card

trait ControllerInterface {
  def shuffleDeck:Any
  def generateDeck:Any
  def handValue(hand: Array[Card]):Any
  def draw():Card
  def undo():Unit
  def redo():Unit
}
