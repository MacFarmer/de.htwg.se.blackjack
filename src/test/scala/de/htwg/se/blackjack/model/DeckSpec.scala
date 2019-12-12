package de.htwg.se.blackjack.model

import org.scalatest.{Matchers, WordSpec}

class DeckSpec extends WordSpec with Matchers {
  "A Deck" when { "new" should {
    val deck = DeckSingleton
    "should not yet contain" in {
      deck.cards.contains(new Card("Hearts", "8")) should be (false)
    }
  }}
}
