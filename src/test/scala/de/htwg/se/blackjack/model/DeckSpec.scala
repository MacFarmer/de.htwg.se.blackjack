package de.htwg.se.blackjack.model

import org.scalatest.{Matchers, WordSpec}

class DeckSpec extends WordSpec with Matchers {
  "A Deck" when { "new" should {
    val deck = Deck()
    "have a Card of a 52 Deck" in {
      deck.cards.contains(Card(" <> ", "2")) should be(true)
    }
    "have 52 Cards" in {
      deck.cards.size should be(52)
    }
    "not allowed to have other cards" in {
      deck.cards.contains(Card("hfwsiubnhfw", "sdhfish")) should be(false)
    }
    "have a nice List represantation" in {
      deck.cards.toString() should be("List( <> King,  <> Queen,  <> Jack,  <> Ace,  " +
        "<> 2,  <> 3,  <> 4,  <> 5,  <> 6,  <> 7,  <> 8,  <> 9,  <> 10,  <3 King,  " +
        "<3 Queen,  <3 Jack,  <3 Ace,  <3 2,  <3 3,  <3 4,  <3 5,  <3 6,  <3 7,  " +
        "<3 8,  <3 9,  <3 10,  .^. King,  .^. Queen,  .^. Jack,  .^. Ace,  " +
        ".^. 2,  .^. 3,  .^. 4,  .^. 5,  .^. 6,  .^. 7,  .^. 8,  .^. 9,  " +
        ".^. 10,  .*. King,  .*. Queen,  .*. Jack,  .*. Ace,  .*. 2,  " +
        ".*. 3,  .*. 4,  .*. 5,  .*. 6,  .*. 7,  .*. 8,  .*. 9,  .*. 10)")
    }
  }}
}
