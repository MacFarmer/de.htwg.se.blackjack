package de.htwg.se.blackjack.model

import org.scalatest.{Matchers, WordSpec}

class StatusSpec extends WordSpec with Matchers {
  "A Status" when { "new" should {
    val status = new StatusFacade
    status.generateDeck()
    val player = Array(status.draw())
    "should gerenate new Deck of Cards" in {
      status.generateDeck() should be()
    }
  }}
}
