package de.htwg.se.blackjack.controller.controllerComponent

import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory

trait ControllerInterface {
  def shuffleDeck:Any
  def generateDeck:Any
  def handValue(hand: Array[CardFactory]):Any
  def draw():CardFactory
  def undo():Unit
  def redo():Unit
//  def load():Unit
//  def save():Unit
}
