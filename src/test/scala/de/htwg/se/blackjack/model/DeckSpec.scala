package de.htwg.se.blackjack.model

import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.deckComponent.deckBaseImpl.DeckSingleton
import org.scalatest.{Matchers, WordSpec}

class DeckSpec extends WordSpec with Matchers {
  "A Deck" when { "new" should {
    val deck = DeckSingleton
    "should not yet contain" in {
      deck.cardsSingelton.contains(new CardFactory("Hearts", "8")) should be (false)
    }
    "have 52 Cards" in {
      deck.cardsSingelton.size should be (52)
    }
    "have some card less" in {
      deck.cardsSingelton.size -1 should be(51)
    }
  }}
}
