package de.htwg.se.blackjack

import de.htwg.se.blackjack.model.{Card, DeckSingleton, Player, Status}
import de.htwg.se.blackjack.aview.Tui
import de.htwg.se.blackjack.controller.Controller


object Blackjack {
  def main(args: Array[String]): Unit = {
    val daniel = Player("Daniel")
    val marc = Player("Marc")
    val testDealer = Dealer(DeckSingleton.cards)
    val status = Status(testDealer, List(daniel, marc))
    val controller = new Controller(status)
    val tui = new Tui(controller)
    //println("Hi wir sind " + daniel.name + " und " + marc.name + " und wir Programmieren Blackjack in Scala !")
    //println("Daniel Chips: " + daniel.chip + "\n" + "Marc Chips: " + marc.chip)

    def menu(): Unit = {
      println("Willkommen zu Blackjack!")
      println("ng: create New Game")
      println("h: Hit draw card")
      println("s: Stand with your current deck")
      println("q: Programm beenden.")
    }

    menu()
    while(true) {
      val input = scala.io.StdIn.readLine()
      println(tui.processInputLine(input))
    }
  }
}