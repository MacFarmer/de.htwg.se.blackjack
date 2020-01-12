package de.htwg.se.blackjack.model

import org.scalatest.{Matchers, WordSpec}

class StatusSpec extends WordSpec with Matchers {
  "A Status" when { "new" should {
    val status = new Status
    status.generateDeck()
    val player = Array(status.draw())
    "should gerenate new Deck of Cards" in {
      status.generateDeck() should be()
    }
    "a player should have a card with Value" in {
     status.handValue(player) should be(10)
    }
    "also a nice String represantation" in {
      status.handValue(player).toString should be("10")
    }
  }}
}
