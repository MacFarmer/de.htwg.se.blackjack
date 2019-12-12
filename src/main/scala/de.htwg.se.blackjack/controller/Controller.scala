package de.htwg.se.blackjack.controller

import de.htwg.se.blackjack.model.{Card, StatusFacade}
import de.htwg.se.blackjack.util.{Observable, UndoManager}

class Controller(var status: StatusFacade) extends Observable {
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

  def draw(): Card = {
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
}
