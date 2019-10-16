package de.htwg.se.blackjack

import de.htwg.se.blackjack.model.Player

object  Blackjack {
  def main(args: Array[String]): Unit = {
    val daniel = Player("Daniel")
    val marc = Player("Marc");
    println("Hi wir sind " + daniel + " und " + marc " !")
  }
}
