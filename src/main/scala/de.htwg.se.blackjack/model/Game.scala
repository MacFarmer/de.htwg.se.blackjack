package de.htwg.se.blackjack.model

object Game {

  def rules() = {
    println("In the First Round you and dealer get 2 Cards\n"
    + "Dealers First Card is shown but the second Card is hidden\n"
    + "You will see 2 Cards which their Value will be summed together\n"
    + "You either can (Hit): Take another Card\n"
    + "Or (Stand) in which you will stay with your current Cards\n"
    + "the Dealer will take more Cards as long as he is under 17\n")
  }

  def info() = {
    println("Contributors:\t\t Daniel Bersuch & Marc Freibauer\n")
    println("Class:\t\t Software Engineering - Marko Boger\n")
    println("Date: \t\t 18.12.2019\n")
    println("Version:\t\t 1.0\n")
  }

}
