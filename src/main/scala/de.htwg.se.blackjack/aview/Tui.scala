package de.htwg.se.blackjack.aview

import de.htwg.se.blackjack.util.{Observable, Observer}
import de.htwg.se.blackjack.controller.Controller
import de.htwg.se.blackjack.model.{StatusFacade, Card}

import scala.io.StdIn._



class Tui(controller: Controller) extends Observer {
  controller.add(this)
  var status = new StatusFacade()

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
        case _ => println("You stupid!")
      }
    }
    true // to make compiler happy
  }

  def gameStart(): Int = {

    var player = Array(controller.draw())
    println("Player:\t\tYou are dealt " + player.head)
    var dealer = Array(controller.draw())
    println("Dealer:\t\tDealer is dealt a hidden card")

    player = player :+ controller.draw()
    println("Player:\t\tYou are dealt " + player.last)
    dealer = dealer :+ controller.draw()
    println("Dealer:\t\tDealer is dealt " + dealer.last)
    printf("Player:\t\tYour total is %d\n", status.handValue(player))

    // player's turn to draw cards
    var want = true
    while (want && status.handValue(player) < 21) {
      println("[H]it or [S]tand?: ")
      want = HitStand(readLine())
      if (want) {
        player = player :+ controller.draw()
        println("Player:\t\tYou are dealt " + player.last)
        printf("Player:\t\tYour total is %d\n", status.handValue(player))

        // if the player's score is over 21, the player loses immediately.
        if (status.handValue(player) > 21) {
          println("Player:\t\tYou Bust! Sorry you lost right away!")
          return -1
        }
      }
    }

    println("Dealer:\t\tThe dealer's hidden card was " + dealer.head)
    while (status.handValue(dealer) < 17) {
      dealer = dealer :+ controller.draw()
      println("Dealer:\t\tDealer is dealt " + dealer.last)
    }
    printf("Dealer:\t\tThe dealer's total is %d\n", status.handValue(dealer))

    // summary
    println("Summary:\n")
    val player_total = status.handValue(player)
    val dealer_total = status.handValue(dealer)
    printf("\nPlayer:\t\tYour total is %d\n", player_total)
    printf("Dealer:\t\tThe dealer's total is %d\n", dealer_total)

    if (dealer_total > 21) {
      println("Dealer Bust! You win!")
      1
    } else if (player_total > dealer_total) {
      println("You win!")
      1
    } else if (player_total < dealer_total) {
      println("You lost!")
      -1
    } else if (player_total == 21) {
      println("Blackjack!!!")
      -1
    } else {
      println("You have a tie!")
      0
    }
  }




  override def update: Boolean = {
    //println(controller.toString)
    true
  }
}
