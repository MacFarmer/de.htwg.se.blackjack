package de.htwg.se.blackjack.model

import org.scalatest._

class PlayerSpec extends WordSpec with Matchers {
  "A Player" when { "new" should {
    val player = Player("Daniel")
    "have a name" in {
      player.name should be("Daniel")
    }
    "have a nice String representation" in {
      player.toString should be ("Daniel")
    }
  }}
}
