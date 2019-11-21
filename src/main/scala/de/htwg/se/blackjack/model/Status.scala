package de.htwg.se.blackjack.model

import de.htwg.se.cards.model.Dealer

case class Status(dealer: Dealer, list: List[Player]) {

  def drawCard: Status = {
    var(drop, card) = dealer.drop()
    this.copy(drop, list.head.takeCard(card) :: list.tail)
  }

  def shuffle: Status = {
    this.copy(dealer = dealer.shuffle())
  }

  def nextPlayer: Status = {
    this.copy(list = list.tail :+ list.head)
  }

  def current: Player = {
    list.head
  }

}
