// --------------------------------------------------------------------
// BlackJack Game as a compiled application
// --------------------------------------------------------------------

import com.google.inject.Guice
import de.htwg.se.blackjack.BlackjackModule
import de.htwg.se.blackjack.aview.Tui
import de.htwg.se.blackjack.controller.controllerComponent.ControllerInterface
import de.htwg.se.blackjack.controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.blackjack.model.statusComponent.statusBaseImpl.{Status, StatusStrategy}
import de.htwg.se.blackjack.model.fileIoComponent.FileIOInterface


import scala.io.StdIn.readLine





object BlackJack {

  /* Display the text prompt and let's the user enter a string.  If the
   user enters "y", the function returns "true", and if the user enters
   "n", the function returns "false" If the user enters anything else,
   the function prints "I beg your pardon!", and asks again, repeating
   this until the user has entered a correct string.  */




  def main(args: Array[String]) : Unit ={
//    val injector = Guice.createInjector(new BlackjackModule)
//    val controller = injector.getInstance(classOf[ControllerInterface])
    val status = new StatusStrategy
    val controller = new Controller(status)
    val tui = new Tui(controller)
    println("Welcome to Blackjack!")
    while(true) {
      tui.gameStart()
      println("--- Wanna play another Game? Press [y]es or [n]o! ---")
      if(!tui.askYesNo(readLine()))
        return
    }
  }
}