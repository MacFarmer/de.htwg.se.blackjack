package de.htwg.se.blackjack

import de.htwg.se.blackjack.model.{Card, Player}



object  Blackjack {
  def main(args: Array[String]): Unit = {
    def menu(): Unit = {
      println("Willkommen zu Blackjack!")
      println("<Name1>_<Name2>: Beide Spieler werden ausgegeben")
      println("q: Programm beenden.")
    }
    menu()
    val input = scala.io.StdIn.readLine()


    if(input.equals("q")) {
      println("Bye!")
    } else {
      val split = input.split(" ")
      val daniel = Player(split(0))
      val marc = Player(split(1))
        println("Hi wir sind " + daniel + " und " + marc + " und wir Programmieren Blackjack in Scala !")
    }
  }
}
