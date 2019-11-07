package de.htwg.se.blackjack

import de.htwg.se.blackjack.model.{Card, Player}

object  Blackjack {
  def main(args: Array[String]): Unit = {
    val a = scala.io.StdIn.readLine()
    val b = scala.io.StdIn.readLine()
    val daniel = Player(a)
    val marc = Player(b)
    println("Hi wir sind " + daniel + " und " + marc + " und wir Programmieren Blackjack in Scala !")
  }
}
