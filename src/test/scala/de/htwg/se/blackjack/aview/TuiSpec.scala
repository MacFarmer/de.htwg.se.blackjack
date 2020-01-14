package de.htwg.se.blackjack.aview

import de.htwg.se.blackjack.controller.Controller
import de.htwg.se.blackjack.model.Status
import org.scalatest.{Matchers, WordSpec}

class TuiSpec extends WordSpec with Matchers {
  "A Tui" when { "new" should {
    val status = new Status
    val controller = new Controller(status)
    val tui = new Tui(controller)
    "have a Method to ask if Yes or No" in {
      tui.askYesNo("y") should not be(true)
      tui.askYesNo("n") should not be(false)
    }
    "have a Method to ask if Hit or Stand" in {
      tui.HitStand("h") should be(true)
      tui.HitStand("s") should be(false)
    }
  }}
}