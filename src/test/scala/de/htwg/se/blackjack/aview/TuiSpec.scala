package de.htwg.se.blackjack.aview

import de.htwg.se.blackjack.controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.blackjack.model.statusComponent.statusBaseImpl.{Status, StatusStrategy}
import org.scalatest.{Matchers, WordSpec}

class TuiSpec extends WordSpec with Matchers {
  "A Tui" when { "new" should {
    val status = new StatusStrategy
    val controller = new Controller(status)
    val tui = new Tui(controller)
    "have a Method to ask if Yes or No" in {
      tui.askYesNo("y") should be(true)
      tui.askYesNo("n") should be(false)
    }
    "have a Method to ask if Hit or Stand" in {
      tui.HitStand("h") should be(true)
      tui.HitStand("s") should be(false)
    }
  }}
}