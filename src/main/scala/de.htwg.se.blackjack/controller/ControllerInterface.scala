package de.htwg.se.blackjack.controller

import de.htwg.se.blackjack.model.CardFactory

trait ControllerInterface {
  def shuffleDeck:Any
  def generateDeck:Any
  def handValue(hand: Array[CardFactory]):Any
  def draw():CardFactory
  def undo():Unit
  def redo():Unit
}
