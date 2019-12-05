package de.htwg.se.blackjack.model

import org.scalatest.{Matchers, WordSpec}

class CardSpec extends WordSpec with Matchers {
  "A Card" when { "new "should {
    val card = Card("DIAMOND", "2")
    "have a suit" in {
      card.face should be ("DIAMOND")
    }
    "have a value" in {
      card.suit should be ("2")
    }
    "method getSuit() should get suit of Card" in {
      card.face should be("DIAMOND")
    }
    "method getValue() should get value of Card" in {
      card.suit should be("2")
    }
    "toString should get all Parameters" in {
      card.toString should be("DIAMOND2")
    }
  }}
}
