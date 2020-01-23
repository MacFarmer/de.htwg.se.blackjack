package de.htwg.se.blackjack.controller

import de.htwg.se.blackjack.controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.blackjack.model.statusComponent.statusBaseImpl.StatusStrategy
import org.scalatest.{Matchers, WordSpec}

class ControllerSpec extends WordSpec with Matchers {
  "A Controller" when { "new" should {
    val status = new StatusStrategy
    val controller = new Controller(status)
    val player = Array(controller.draw())
    "should gerenate new Deck of Cards" in {
      controller.generateDeck should be()
    }
    "draw card from deck" in {
      controller.draw() should not be("a King of Diamonds")
    }
    "redo() should return nothing" in {
      controller.redo() should be()
    }
//    "load() should return nothing" in {
//      controller.load() should be()
//    }
  }}
}
