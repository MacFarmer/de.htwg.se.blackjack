package de.htwg.se.blackjack.model

import de.htwg.se.cards.model.Dealer
import org.scalatest.{Matchers, WordSpec}

class DealerSpec extends WordSpec with Matchers {
  "A Deck" when {
    val d = Deck()
    val dealer = Dealer(d.cards)
    "filled" should {
      "should shuffle" in {
        assert(!dealer.equals(dealer.shuffle()))
      }
    }
    "droped" should {
      val (droped, card) = dealer.drop()
      "have one card less" in {
        droped.cards.size should be (dealer.cards.size - 1)
      }
      "not contain droped card" in {
        droped.cards.contains(card.get) should be(false)
      }
      "still have same order" in {
        droped.cards should be(dealer.cards.tail)
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
