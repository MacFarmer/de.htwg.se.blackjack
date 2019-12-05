package de.htwg.se.blackjack.aview

import de.htwg.se.blackjack.controller.Controller
import de.htwg.se.cards.util.Observer

class Tui(controller: Controller) extends Observer {
  controller.add(this)
  def processInputLine(input: String) = {
    input match {
      case "s" => "No Card will be drawn"
      case "h" => controller.hit
      case "q" => "Bye!"
      case "ng" => "New Game created!"
      case _ => None
    }
  }

  override def update: Boolean = {
    println(controller.statToString)
    true
  }
}
