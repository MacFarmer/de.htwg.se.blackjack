package de.htwg.se.blackjack.model

import org.scalatest.{Matchers, WordSpec}

class CardSpec extends WordSpec with Matchers {
  "A Card" when { "new "should {
    val card = Card("<>", "2")
    "have a suit" in {
      card.suit should be ("<>")
    }
    "have a value" in {
      card.value should be ("2")
    }
    "method getSuit() should get suit of Card" in {
      card.getSuit() should be("<>")
    }
    "method getValue() should get value of Card" in {
      card.getValue() should be("2")
    }
    "toString should get all Parameters" in {
      card.toString should be("<>2")
    }
  }}
}
