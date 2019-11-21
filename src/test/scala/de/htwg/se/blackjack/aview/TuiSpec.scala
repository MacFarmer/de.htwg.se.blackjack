package de.htwg.se.blackjack.aview

import de.htwg.se.blackjack.controller.Controller
import de.htwg.se.blackjack.model.{Deck, Player, Status}
import de.htwg.se.cards.model.Dealer
import org.scalatest.{Matchers, WordSpec}

class TuiSpec extends WordSpec with Matchers {
  "A Tui" when  { "new" should {
    val list = List(Player("Daniel", Nil), Player("Marc", Nil))
    val dealer = Dealer(Deck().cards)
    val status = Status(dealer, list)
    val controller = new Controller(status)
    val tui = new Tui()
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
