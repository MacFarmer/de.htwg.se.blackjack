package de.htwg.se.blackjack.model.statusComponent

import de.htwg.se.blackjack.controller.GameState
import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.playerComponent.playerBaseImpl.Player
import de.htwg.se.blackjack.model.statusComponent.statusBaseImpl.StatusStrategy

import scala.xml.Elem

trait StatusInterface {

  def generateDeck()

  def shuffleDeck()

  def draw(): CardFactory

  def WinLose(spieler: Integer, dealer: Integer): Int

}
