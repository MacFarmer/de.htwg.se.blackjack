package de.htwg.se.blackjack.model.playerComponent.playerBaseImpl

import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.deckComponent.deckBaseImpl.DeckSingleton
import de.htwg.se.blackjack.model.playerComponent.PlayerInterface

import scala.collection.mutable
import scala.collection.mutable.Stack
import scala.xml.{Elem, Node}

case class Player(name: String) extends PlayerInterface{
  var karte = Stack[CardFactory]()
  var playerstack = Stack[CardFactory]()

  def stack(): Stack[CardFactory] = {
    playerstack.push(karte.last)
  }

  def addCard(cards: CardFactory) = {
    karte.push(cards)
    println(name + ":\t\t You are dealt " + cards.toString)
  }

  def takeCardAway() = {
    playerstack.push(karte.pop())
  }

  def returnCard() = {
      karte.insert(0, playerstack.pop())
    }

  def handValue(): Int = {
    var value = 0
//    if (!isAce()) {
//      for (karten <- karte) {
//        value += karten.apply(value)
//      }
//    } else if (isAce() && value <= 21) {
//      for (karten <- karte) {
//        value += karten.apply(value)
//      }
//    } else if (isAce() && value > 21) {
//      for (karten <- karte) {
//        value += karten.apply(value)
//        value - 10
//      }
//    }
    for(karten <- karte) {

      if(!isAce()) {
        value += karten.apply(value)
      } else if (isAce() && value <= 21) {
        value += karten.apply(value)
      } else if (isAce() && value >= 21) {
        value += karten.apply(value)
        value- 10
      }
    }

    value
  }

  def getPlayerStack() = {
    playerstack
  }


//    for(karten <- karte)
//      playerstack.push(karten)
//    println(name + ":\t\t Your total is " + value)


  def draw(): CardFactory = {
    assert(DeckSingleton.count > 0)
    DeckSingleton.count -= 1
    DeckSingleton.cardsSingelton(DeckSingleton.count)
  }

  override def toString: String = {
    name + "s Hand: " + karte
  }

  def isAce(): Boolean = {
//    karte.top.face == "Ace"
//    karte.last.face == "Ace"
    if(karte.last.face.contains("Ace") || karte.head.face.contains("Ace")) {
      true
    }
    false
  }
}
