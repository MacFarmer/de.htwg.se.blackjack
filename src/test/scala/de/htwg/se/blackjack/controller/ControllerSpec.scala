package de.htwg.se.blackjack.controller

import de.htwg.se.blackjack.model.{Deck, Player, Status}
import de.htwg.se.cards.model.Dealer
import de.htwg.se.cards.util.Observer
import org.scalatest.{Matchers, WordSpec}

class ControllerSpec extends WordSpec with Matchers {
  "A Controller" when {
    "observed by an Observer" should {
      val daniel = Player("Daniel", Nil)
      val marc = Player("Marc", Nil)
      val dealer = Dealer(Deck().cards)
      val list = List(daniel, marc)
      val status = Status(dealer, list)

      val controller = new Controller(status)
      val observer = new Observer {
        var updated: Boolean = false
        def isUpdated: Boolean = updated

        override def update: Boolean = {updated = true; updated}
      }
      controller.add(observer)
      "notify its Observer after shuffle" in {
        controller.shuffle
        observer.updated should be(true)
        controller.status.dealer should not be dealer.shuffle()
      }
      "notify its observer after draw" in {
        controller.drawCard
        observer.updated should be(true)
        status.drawCard.dealer.cards.size should be(status.dealer.cards.size-1)
        status.drawCard.current.cards.size should be(status.current.cards.size+1)
      }
      "notify its Observer after nextPlayer" in {
        controller.nextPlayer
        observer.updated should be(true)
        controller.status.current should be(status.list.tail.head)
      }
    }
  }
}
