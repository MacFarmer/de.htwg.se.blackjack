package de.htwg.se.blackjack.model.playerComponent

import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory

import scala.collection.mutable.Stack
import scala.xml.Elem

trait PlayerInterface {
  def stack(): Stack[CardFactory]

  def addCard(cards: CardFactory): Unit

  def takeCardAway()

  def returnCard()

  def set(name: String, stackOfPlayer: CardFactory)

  def handValue(): Int

  //    for(karten <- karte)
  //      playerstack.push(karten)
  //    println(name + ":\t\t Your total is " + value)

  def getPlayerStack(): Stack[CardFactory]

  def draw(): CardFactory


}
