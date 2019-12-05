package de.htwg.se.blackjack.controller

import de.htwg.se.blackjack.model.Status
import de.htwg.se.cards.util.Observable

class Controller(var status: Status) extends Observable {
  def nextPlayer: Unit = {
    status = status.nextPlayer
    notifyObservers
  }

  def hit: Unit = {
    status = status.hit
    notifyObservers
  }



  /*def shuffle: Unit = {
    status = status.shuffle
    notifyObservers
  }*/

 /* def hit: Unit = {
    status = status.hit
    notifyObservers
  } */

  def statToString: String = status.toString
}
