package de.htwg.se.blackjack.model

case class Status(player: Player, list: List[Player]) {

  val deck: DeckSingleton

  def hit: Status = {
    val list = player.addCard(deck.dealCard)
    this.copy(list)
  }

  def nextPlayer: Status = {
    this.copy(list = list.tail :+ list.head)
  }

  def current: Player = {
    list.head
  }

}
