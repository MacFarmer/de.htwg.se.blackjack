package de.htwg.se.blackjack.model

import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.deckComponent.deckBaseImpl.Deck
import org.scalatest.{Matchers, WordSpec}

class DeckSpec extends WordSpec with Matchers {
  "A Deck" when { "new" should {
    val deck = Deck
    "should not yet contain" in {
      deck.cards.contains(new CardFactory("Hearts", "8")) should be (false)
    }
//    "have 48 Cards after draw() was used" in {
//      deck.count should be(51)
//    }
//    "have some card less" in {
//      deck.count -1 should be(50)
//    }
  }}
}
