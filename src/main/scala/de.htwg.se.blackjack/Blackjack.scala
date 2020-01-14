// --------------------------------------------------------------------
// BlackJack Game as a compiled application
// --------------------------------------------------------------------

import de.htwg.se.blackjack.aview.Tui
import de.htwg.se.blackjack.controller.Controller
import de.htwg.se.blackjack.model.{Deck, Status}

import scala.io.StdIn.readLine





object BlackJack {

  /* Display the text prompt and let's the user enter a string.  If the
   user enters "y", the function returns "true", and if the user enters
   "n", the function returns "false" If the user enters anything else,
   the function prints "I beg your pardon!", and asks again, repeating
   this until the user has entered a correct string.  */




  def main(args: Array[String]) {
    val status = new Status
    val controller = new Controller(status)
    val tui = new Tui(controller)
    println("Welcome to Blackjack!")
    while(true) {
      tui.gameStart()
      println("---Wanna play another Game? Press [y]es or [n]o! ---")
      if(!tui.askYesNo(readLine()))
        return
    }
  }
}