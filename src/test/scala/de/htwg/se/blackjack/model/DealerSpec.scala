package de.htwg.se.blackjack.model

import de.htwg.se.cards.model.Dealer
import org.scalatest.{Matchers, WordSpec}

class DealerSpec extends WordSpec with Matchers {
  "A Talon" when {
    val d = Deck()
    val talon = Dealer(d.cards)
    "filled" should {
      "should shuffle" in {
        assert(!talon.equals(talon.shuffle()))
      }
    }
    "droped" should {
      val (droped, card) = talon.drop()
      "have one card less" in {
        droped.cards.size should be {
          talon.cards.size - 1
        }
      }
      "not contain droped card" in {
        droped.cards.contains(card.get) should be(false)
      }
      "still have same order" in {
        droped.cards should be(talon.cards.tail)
      }
    }
    "empty" should {
      val empty = Dealer(Nil)
      "return nothing when drop()" in {
        empty.drop() should be((empty, None))
      }
    }
  }
}
