package de.htwg.se.blackjack.controller

import de.htwg.se.blackjack.model.{DeckSingleton, Player, Status}
import de.htwg.se.cards.util.Observer
import org.scalatest.{Matchers, WordSpec}

class ControllerSpec extends WordSpec with Matchers {
  "A Controller" when {
    "observed by an Observer" should {
      val daniel = Player("Daniel", Nil, 100)
      val marc = Player("Marc", Nil, 50)
      val dealer = Dealer(DeckSingleton.cards)
      val list = List(daniel, marc)
      val status = Status(dealer, list)

      val controller = new Controller(status)
      val observer = new Observer {
        var updated: Boolean = false
        def isUpdated: Boolean = updated

        override def update: Boolean = {updated = true; updated}
      }
      controller.add(observer)
     /* "notify its Observer after shuffle" in {
        controller.shuffle
        observer.updated should be(true)
        controller.status.dealer should not be dealer.shuffle()
      }*/
      "notify its observer after draw" in {
        controller.hit
        observer.updated should be(true)
        status.hit.dealer.cards.size should be(status.dealer.cards.size-1)
        status.hit.current.cards.size should be(status.current.cards.size+1)
      }
      "notify its Observer after nextPlayer" in {
        controller.nextPlayer
        observer.updated should be(true)
        controller.status.current should be(status.list.tail.head)
      }
    }
  }
}
