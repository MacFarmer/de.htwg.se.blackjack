package de.htwg.se.blackjack.model

import org.scalatest.{Matchers, WordSpec}

class DeckSpec extends WordSpec with Matchers {
  "A Deck" when { "new" should {
    val deck = DeckSingleton
    "have a Card of a 52 Deck" in {
      deck.cards.contains(Card(" DIAMOND ", "2")) should be(true)
    }
    "have 52 Cards" in {
      deck.cards.size should be(52)
    }
    "not allowed to have other cards" in {
      deck.cards.contains(Card("hfwsiubnhfw", "sdhfish")) should be(false)
    }
    "have a nice List represantation" in {
      deck.cards.toString() should be("List( DIAMOND King,  DIAMOND Queen,  DIAMOND Jack,  DIAMOND Ace,  " +
        "DIAMOND 2,  DIAMOND 3,  DIAMOND 4,  DIAMOND 5,  DIAMOND 6,  DIAMOND 7,  DIAMOND 8,  DIAMOND 9,  DIAMOND 10,  HEART King,  " +
        "HEART Queen,  HEART Jack,  HEART Ace,  HEART 2,  HEART 3,  HEART 4,  HEART 5,  HEART 6,  HEART 7,  " +
        "HEART 8,  HEART 9,  HEART 10,  PIKE King,  PIKE Queen,  PIKE Jack,  PIKE Ace,  " +
        "PIKE 2,  PIKE 3,  PIKE 4,  PIKE 5,  PIKE 6,  PIKE 7,  PIKE 8,  PIKE 9, " +
        " PIKE 10,  CLOVER King,  CLOVER Queen,  CLOVER Jack,  CLOVER Ace,  CLOVER 2,  " +
        "CLOVER 3,  CLOVER 4,  CLOVER 5,  CLOVER 6,  CLOVER 7,  CLOVER 8,  CLOVER 9,  CLOVER 10)")

    }
  }}
}
