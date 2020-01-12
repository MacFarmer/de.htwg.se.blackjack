package de.htwg.se.blackjack.aview

import de.htwg.se.blackjack.util.{Observable, Observer}
import de.htwg.se.blackjack.controller.Controller
import de.htwg.se.blackjack.model.{Card, Player, Status}

import scala.collection.mutable.Stack
import scala.io.StdIn._



class Tui(controller: Controller) extends Observer {
  controller.add(this)
  var status = new Status()


  // initial cards
  status.generateDeck()
  // shuffle cards
  status.shuffleDeck()


  // Ask Player if he wants to play another round
  def askYesNo(prompt: String): Boolean = {
    while (true) {
      //val user_input = readLine(prompt)
      prompt match {
        case "y" => return true
        case "n" => return false
        case _ => println("You stupid!")
      }
    }
    true // to make compiler happy
  }

  // Ask Player if Hit = Take another card or Stand = stand with the current value of cards
  def HitStand(prompt: String): Boolean = {
    while (true) {
      //val user_input = readLine(prompt)
      prompt match {
        case "h" => return true
        case "s" => return false
        case "undo" => controller.undo()
        case "redo" => controller.redo()
        case _ => println("You stupid!")
      }
    }
    true // to make compiler happy
  }

  def processInput(input: String): Card = {
    input match {
      case "h" => controller.draw()
    }
}

  def gameStart(): Int = {

    var player = Player("Player")
    var dealer = Player("Dealer")

    player.addCard(controller.draw())
    dealer.addCard(controller.draw())
    player.addCard(controller.draw())
    dealer.addCard(controller.draw())
    printf("Player:\t\tYour total is %d\n", player.handValue())

    var want = true
    while (want && player.handValue() < 21) {
      println("[H]it or [S]tand?: ")
      var input = readLine()
      if (input.equals("h")) {
        want = true
        player.addCard(controller.draw())
        printf("Daniel:\t\tYour total is %d\n", player.handValue())
        if (player.handValue() > 21) {
          println("Player:\t\tYou Bust! Sorry you lost right away!")
          return -1
        }
      } else if(input.equals("s")) {
        want = false
      } else if(input.equals("undo")) {
        player.takeCardAway()
        println(player.name + player.karte.reverse)
        printf("Daniel:\t\tYour total is %d\n", player.handValue())
      } else if (input.equals("redo")) {
        player.returnCard()
        printf("Daniel:\t\tYour total is %d\n", player.handValue())
      }
    }
    while (dealer.handValue() < 17) {
      dealer.addCard(controller.draw())
    }

    printf("Dealer:\t\tThe dealer's total is %d\n", dealer.handValue())

    // summary
    println("Summary:\n")
    val player_total = player.handValue()
    val dealer_total = dealer.handValue()
    printf("\nPlayer:\t\tYour total is %d\n", player_total)
    printf("Dealer:\t\tThe dealer's total is %d\n", dealer_total)

    status.WinLose(player_total, dealer_total)
  }




  override def update: Boolean = {
   // println(controller.toString)
    true
  }
}
