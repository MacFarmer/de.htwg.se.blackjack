package de.htwg.se.blackjack.model

import de.htwg.se.blackjack.controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.blackjack.model.playerComponent.playerBaseImpl.Player
import de.htwg.se.blackjack.model.statusComponent.statusBaseImpl.StatusStrategy
import org.scalatest.{Matchers, WordSpec}

class PlayerDeck extends WordSpec with Matchers {
  "A Player" when { "new" should {
    val status = new StatusStrategy
    val controller = new Controller(status)
    // initial cards
    status.generateDeck()
    // shuffle cards
    status.shuffleDeck()
    val player = Player("Player")
    val dealer = Player("Dealer")
    dealer.addCard(controller.draw())
    "when Player has drawn a Card" in {
        player.addCard(controller.draw()) should be ()
    }
    "size of player should be seen" in {
      player.karte.size should be(1)
    }
    "name of player should be seen" in {
      player.name should be("Player")
    }
    "size of dealer should be seen" in {
      dealer.karte.size should be(1)
    }
    "name of dealer should be seen" in {
      dealer.name should be("Dealer")
    }
    "playerStack should be empty" in {
      player.playerstack.size should be(0)
    }

  }

  }
}
