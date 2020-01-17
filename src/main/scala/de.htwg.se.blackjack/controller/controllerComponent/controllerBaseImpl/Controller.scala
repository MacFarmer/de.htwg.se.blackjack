package de.htwg.se.blackjack.controller

import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.statusComponent.statusBaseImpl.Status
import de.htwg.se.blackjack.util.{Observable, Observer, UndoManager}

class Controller(var status: Status) extends Observable with ControllerInterface {
  //var status: Status
  private val undoManager = new UndoManager

  def shuffleDeck = {
    status.shuffleDeck()
    notifyObservers
  }

  def generateDeck = {
    status.generateDeck()
    notifyObservers
  }

  def handValue(hand: Array[CardFactory]) = {
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

  //override def toString: String = status.toString
}
