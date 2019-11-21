package de.htwg.se.blackjack

import de.htwg.se.blackjack.model.{Card, Player}
import de.htwg.se.blackjack.aview.Tui



object  Blackjack {
  def main(args: Array[String]): Unit = {
    val tui = new Tui()

    def menu(): Unit = {
      println("Willkommen zu Blackjack!")
      println("<Name1>_<Name2>: Beide Spieler werden ausgegeben")
      println("ng: create New Game")
      println("q: Programm beenden.")
    }

    menu()
    val input = scala.io.StdIn.readLine()
    if(input.length < 2) {
      tui.processInputLine(input)
    } else {
      val split = input.split(" ")
      val name1 = Player(split(0), Nil)
      val name2 = Player(split(1), Nil)
      println("Hi wir sind " + name1 + " und " + name2 + " und wir Programmieren Blackjack in Scala !")
    }
  }
}
