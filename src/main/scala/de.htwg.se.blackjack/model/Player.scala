package de.htwg.se.blackjack.model

import scala.collection.mutable.Stack

case class Player(name: String) {
  var karte = Stack[Card]()
  var playerstack = Stack[Card]()

  def stack(): Stack[Card] = {
    playerstack.push(karte.last)
  }



  def addCard(cards: Card) = {
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
      value += karten.value
    }
//    for(karten <- karte)
//      playerstack.push(karten)
//    println(name + ":\t\t Your total is " + value)
    value
  }

  def draw(): Card = {
    assert(Deck.count > 0)
    Deck.count -= 1
    Deck.cards(Deck.count)
  }

  override def toString: String = {
    name + "s Hand: " + karte
  }

}
