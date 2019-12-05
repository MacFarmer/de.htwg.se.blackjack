package de.htwg.se.blackjack.aview

import de.htwg.se.blackjack.controller.Controller
import de.htwg.se.blackjack.model.{DeckSingleton, Player, Status}
import org.scalatest.{Matchers, WordSpec}

class TuiSpec extends WordSpec with Matchers {
  "A Tui" when  { "new" should {
    val list = List(Player("Daniel", Nil, 100), Player("Marc", Nil, 50))
    val dealer = Dealer(DeckSingleton.cards)
    val status = Status(dealer, list)
    val controller = new Controller(status)
    val tui = new Tui(controller)
    "create New Game 'ng' " in  {
      tui.processInputLine("ng")
    }
    "have a nice String represantation" in {
      tui.processInputLine("ng") should be ("New Game created!")
    }
    "game should quit when" in {
      tui.processInputLine("q") should be ("Bye!")
    }
  }}
}
