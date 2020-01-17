package de.htwg.se.blackjack.model.statusComponent

import de.htwg.se.blackjack.controller.GameState
import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.deckComponent.deckBaseImpl.Deck

trait StatusInterface {
  def generateDeck()


  def shuffleDeck()

  def draw(): CardFactory

  def handValue(hand: Array[CardFactory]): Int

  // def isAce(cards : Card): Boolean = {
  //   cards.face == "Ace"
  //  }

  //    def handValue(hand: Array[Card]): Int = {
  //      var value = 0
  //      if (hand.exists(c => c.face != "Ace")) {
  //        for (card <- hand)
  //          value += card.value
  //      } else if ((hand.exists(c => c.face == "Ace") && value > 21)) {
  //        for (card <- hand)
  //          value += card.value - 10
  //      } else if ((hand.exists(c => c.face == "Ace") && value < 21)) {
  //        for (card <- hand)
  //          value += card.value
  //      }
  //      value
  //    }

  def WinLose(spieler: Integer, dealer: Integer): Int
}
