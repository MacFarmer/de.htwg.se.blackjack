package de.htwg.se.blackjack.model.statusComponent.statusBaseImpl

import de.htwg.se.blackjack.controller.GameState
import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.deckComponent.deckBaseImpl.DeckSingleton
import de.htwg.se.blackjack.model.playerComponent.PlayerInterface
import de.htwg.se.blackjack.model.playerComponent.playerBaseImpl.Player
import de.htwg.se.blackjack.model.statusComponent.StatusInterface

import scala.collection.mutable.Stack
import scala.xml.Elem

class StatusStrategy extends StatusInterface {

  var karte = Stack[CardFactory]()
  var deck = DeckSingleton

  def generateDeck(): Unit = {
    var i = 0
    for (suit <- deck.Suits) {
      for (face <- deck.Faces) {
        deck.cardsSingelton(i) = new CardFactory(face, suit)
        i += 1
      }
    }
  }

  def shuffleDeck(): Unit = {
    for (i <- 1 to 52) {
      // 0..i-2 already shuffled
      val j = (math.random * i).toInt
      val cj = deck.cardsSingelton(j)
      deck.cardsSingelton(j) = deck.cardsSingelton(i-1)
      deck.cardsSingelton(i-1) = cj
    }
  }

  def draw(): CardFactory = {
    assert(DeckSingleton.count > 0)
    deck.count -= 1
    deck.cardsSingelton(deck.count)
  }

  def handValue(hand: Array[CardFactory]): Int = {
    var value = 0
    for (card <- hand)
      value += card.apply(value)
    value
  }

  def handValue2(): Int = {
    var value = 0
    for (karten <- karte) {
      value += karten.apply(value)
    }
    value
  }

  def getName(p: Player): String = p.name


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
