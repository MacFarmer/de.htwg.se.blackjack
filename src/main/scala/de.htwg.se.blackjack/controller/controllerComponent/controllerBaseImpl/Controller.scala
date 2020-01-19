package de.htwg.se.blackjack.controller.controllerComponent.controllerBaseImpl

import com.google.inject.{Guice, Inject, Injector}
import de.htwg.se.blackjack.BlackjackModule
import de.htwg.se.blackjack.controller.controllerComponent.ControllerInterface
import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.fileIoComponent.FileIOInterface
import de.htwg.se.blackjack.model.playerComponent.PlayerInterface
import de.htwg.se.blackjack.model.statusComponent.statusBaseImpl.StatusStrategy
import de.htwg.se.blackjack.util.{Observable, UndoManager}

class Controller @Inject() (var status: StatusStrategy) extends Observable with ControllerInterface {
  //var status: Status
  private val undoManager = new UndoManager
  //val injector = Guice.createInjector(new BlackjackModule)

  def shuffleDeck: Unit = {
    status.shuffleDeck()
    notifyObservers
  }

  def generateDeck: Unit = {
    status.generateDeck()
    notifyObservers
  }

  def handValue(hand: Array[CardFactory]): Int = {
    notifyObservers
    status.handValue(hand)
  }

  def draw(): CardFactory = {
    notifyObservers
    status.draw()
  }

  def undo(): Unit = {
    undoManager.undoStep()
    notifyObservers
  }

  def redo(): Unit = {
    undoManager.redoStep()
    notifyObservers
  }

  def save: Unit = {

  }

  //override def toString: String = status.toString
}
