package de.htwg.se.blackjack.controller.controllerComponent

import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory

import scala.xml.Elem

trait ControllerInterface {
  def shuffleDeck:Any
  def generateDeck:Any
  def handValue(hand: List[CardFactory]):Any
  def draw():CardFactory
  def undo():Unit
  def redo():Unit
//  def load():Unit
  def save: Unit
}
