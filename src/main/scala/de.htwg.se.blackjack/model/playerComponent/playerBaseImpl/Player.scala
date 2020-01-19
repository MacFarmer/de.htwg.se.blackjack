package de.htwg.se.blackjack.model.playerComponent.playerBaseImpl

import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.deckComponent.deckBaseImpl.Deck
import de.htwg.se.blackjack.model.playerComponent.PlayerInterface

import scala.collection.mutable.Stack

case class Player(name: String) extends PlayerInterface{
  var karte = Stack[CardFactory]()
  var playerstack = Stack[CardFactory]()

  def stack(): Stack[CardFactory] = {
    playerstack.push(karte.last)
  }

  def getName: String = name

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
    for (karten <- karte) {
      value += karten.apply(value)
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
    assert(Deck.count > 0)
    Deck.count -= 1
    Deck.cards(Deck.count)
  }

  override def toString: String = {
    name + "s Hand: " + karte
  }

  def toXml = {
    <player>
      <name>{name}</name>
      <value>{handValue()}</value>
    </player>
  }

}
