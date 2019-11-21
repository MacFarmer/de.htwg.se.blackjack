package de.htwg.se.blackjack

import de.htwg.se.blackjack.model.{Card, Deck, Player, Status}
import de.htwg.se.blackjack.aview.Tui
import de.htwg.se.blackjack.controller.Controller
import de.htwg.se.cards.model.Dealer



object Blackjack {
  def main(args: Array[String]): Unit = {
    val name1 = Player("Daniel", Nil)
    val name2 = Player("Marc", Nil)
    val testDealer = Dealer(Deck().cards.take(10))
    val status = Status(testDealer, List(name1, name2))
    val controller = new Controller(status)
    val tui = new Tui()

    def menu(): Unit = {
      println("Willkommen zu Blackjack!")
      println("<Name1>_<Name2>: Beide Spieler werden ausgegeben")
      println("ng: create New Game")
      println("q: Programm beenden.")
    }

    menu()
    val input = scala.io.StdIn.readLine()
    if (input.length < 1) {
      tui.processInputLine(input)
      println("Hi wir sind " + name1 + " und " + name2 + " und wir Programmieren Blackjack in Scala !")
    }
  }
}
