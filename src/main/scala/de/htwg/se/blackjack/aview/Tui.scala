package de.htwg.se.blackjack.aview

import de.htwg.se.sudoku.util.Observer

class Tui() extends Observer{

  def processInputLine(input: String) = {
    input match {
      case "q" => "Bye!"
      case "ng" => "New Game created!"
    }
  }

  override def update: Unit = ???
}
