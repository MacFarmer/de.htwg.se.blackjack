package de.htwg.se.blackjack.aview

import org.scalatest.{Matchers, WordSpec}

class TuiSpec extends WordSpec with Matchers {
  "A Tui" should {
    val tui = new Tui()
    "create New Game 'ng' " in  {
      tui.processInputLine("ng")
    }
    "have a nice String represantation" in {
      tui.processInputLine("ng") should be ("ng")
    }
  }
}
