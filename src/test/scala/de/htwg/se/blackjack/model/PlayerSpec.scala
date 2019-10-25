package de.htwg.se.blackjack.model

import org.scalatest._

class PlayerSpec extends WordSpec with Matchers {
  "A Player" when { "new" should {
    val daniel = Player("Daniel")
    val marc = Player("Marc")
    "have a name" in {
      daniel.name should be("Daniel")
    }
    "have also a name" in {
      marc.name should be("Marc")
    }
    "have a nice String representation" in {
      daniel.toString should be ("Daniel")
    }
    "have also a nice String representation" in {
      marc.toString should be ("Marc")
    }
  }}
}
