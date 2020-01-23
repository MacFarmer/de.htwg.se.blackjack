package de.htwg.se.blackjack.controller

import de.htwg.se.blackjack.aview.Tui
import de.htwg.se.blackjack.model.playerComponent.playerBaseImpl.Player
import de.htwg.se.blackjack.util.Command

import scala.collection.mutable.Stack

abstract class GameCommand(player: Player) extends Command {

  override def doStep(): Unit = player.draw()

  override def undoStep(): Unit = player.handValue()

  override def redoStep(): Unit = player.draw()

}
