package de.htwg.se.blackjack.model

import org.scalatest.{Matchers, WordSpec}

class DeckSpec extends WordSpec with Matchers {
  "A Deck" when { "new" should {
    val deck = Deck
    "should not yet contain" in {
      deck.cards.contains(new Card("Hearts", "8")) should be (false)
    }
    "have 48 Cards after draw() was used" in {
      deck.count should be(52)
    }
    "have some card less" in {
      deck.count -1 should be(51)
    }
  }}
}
