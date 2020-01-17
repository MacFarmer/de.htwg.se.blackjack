package de.htwg.se.blackjack.model

import de.htwg.se.blackjack.controller.Controller

object DealerStrategy {

  var dealer = Player("Dealer")

  val status = new Status
  val controller = new Controller(status)

  var strategy = if (dealer.handValue() < 17 ) takeCard else noCard

  def takeCard = dealer.addCard(controller.draw())

  def noCard = printf("Dealer:\t\t The dealer's total is %d\n", dealer.handValue())
}
