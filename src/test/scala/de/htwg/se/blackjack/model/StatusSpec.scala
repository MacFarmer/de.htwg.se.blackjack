package de.htwg.se.blackjack.model

import org.scalatest.{Matchers, WordSpec}

class StatusSpec extends WordSpec with Matchers{
  "A status" when {
    val daniel = Player("Daniel", Nil, 100)
    val marc = Player("Marc", Nil, 50)
    val dealer = Dealer(DeckSingleton.cards)
    val list = List(daniel, marc)
    val status = Status(dealer, list)
    "new" should {
      "Have a Dealer" in {
        status.dealer should be(dealer)
      }
      "Have some Players" in {
        status.list should be(list)
      }
      "Have a current Player" in {
        status.current should be(daniel)
      }
    }
    "next player" should {
      "return status with next player at front of list" in {
        status.nextPlayer.current should be(marc)
      }
      "return status with last player in list" in {
        status.nextPlayer.list.last should be(daniel)
      }
    }
    "shuffle" should {
      /*"return status with same sized deck" in {
        status.shuffle.dealer.cards.size should be(status.dealer.cards.size)
      }*/
    }
    "draw card" should {
      val drawStatus = status.hit
      "shrink the deck" in {
        drawStatus.dealer.cards.size should be(status.dealer.cards.size-1)
      }
    }
  }
}
