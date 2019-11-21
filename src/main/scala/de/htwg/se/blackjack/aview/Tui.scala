package de.htwg.se.blackjack.aview

import de.htwg.se.blackjack.controller.Controller
import de.htwg.se.cards.util.Observer

class Tui(){
  //controller.add(this)
  def processInputLine(input: String) = {
    input match {
      case "q" => "Bye!"
      case "ng" => "New Game created!"
    }
  }

  //override def update: Boolean = ???
}
