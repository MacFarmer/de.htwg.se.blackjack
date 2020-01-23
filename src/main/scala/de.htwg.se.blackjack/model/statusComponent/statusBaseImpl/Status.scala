package de.htwg.se.blackjack.model.statusComponent.statusBaseImpl

import de.htwg.se.blackjack.controller.GameState
import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.deckComponent.deckBaseImpl.Deck

class Status {

  def generateDeck() = {
    var i = 0
    for (suit <- Deck.Suits) {
      for (face <- Deck.Faces) {
        Deck.cards(i) = new CardFactory(face, suit)
        i += 1
      }
    }
  }

  def shuffleDeck() = {
    for (i <- 1 to 52) {
      // 0..i-2 already shuffled
      val j = (math.random * i).toInt
      val cj = Deck.cards(j)
      Deck.cards(j) = Deck.cards(i-1)
      Deck.cards(i-1) = cj
    }
  }

  def draw(): CardFactory = {
    assert(Deck.count > 0)
    Deck.count -= 1
    Deck.cards(Deck.count)
  }

  def handValue(hand: Array[CardFactory]): Int = {
    var value = 0
    for (card <- hand)
      value += card.apply(value)
    value
  }

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

  def WinLose(spieler: Integer, dealer: Integer): Int = {
    if (dealer > 21) {
      println("Dealer Bust! You win!")
      GameState.WON.id
    } else if (spieler > 21) {
      println("You Bust! Dealer wins!")
      GameState.LOST.id
    } else if (spieler > dealer && spieler <= 21) {
      println("You win!")
      GameState.WON.id
    } else if (spieler < dealer && dealer <= 21) {
      println("You lost!")
      GameState.LOST.id
    } else if (spieler == 21 && dealer != 21) {
      println("You have a Blackjack!!!")
      GameState.WON.id
    } else if (dealer == 21 && spieler != 21) {
      println("Dealer has a Blackjack!!!")
      GameState.LOST.id
    } else {
      println("You have a tie!")
      GameState.PUSH.id
    }
  }
}
