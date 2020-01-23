package de.htwg.se.blackjack.controller.controllerComponent

import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.fileIoComponent.FileIOInterface
import de.htwg.se.blackjack.model.playerComponent.playerBaseImpl.Player

import scala.xml.Elem

trait ControllerInterface {
  def shuffleDeck:Any
  def generateDeck:Any
  def draw():CardFactory
  def undo():Unit
  def redo():Unit
  def save(player: Player, dealer: Player): Unit
  def load

}
