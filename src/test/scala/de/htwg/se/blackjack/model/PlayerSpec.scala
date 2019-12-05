package de.htwg.se.blackjack.model

import org.scalatest._

import scala.collection.immutable

class PlayerSpec extends WordSpec with Matchers {
  "A Player" when { "new" should {
    val daniel = Player("Daniel", Nil, 100)
    val marc = Player("Marc", Nil, 50)
    "have a name" in {
      daniel.name should be("Daniel")
      daniel.cards should be(Nil)
    }
    "have also a name" in {
      marc.name should be("Marc")
      marc.cards should be(Nil)
    }
    "have a nice String representation" in {
      daniel.toString should be (daniel.name + "'s cards: " + daniel.cards)
    }
    "have also a nice String representation" in {
      marc.toString should be (marc.name + "'s cards: " + marc.cards)
    }

  }}
}
