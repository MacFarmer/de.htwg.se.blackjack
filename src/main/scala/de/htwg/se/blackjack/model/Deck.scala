package de.htwg.se.blackjack.model

case class Deck() {

  var count = 56

      val suit = List(" <> ", " <3 ", " .^. ", " .*. ")
      val value =  List("King", "Queen", "Jack", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10")
      val cards: List[Card] = for {
    s <- suit
    v <- value
    } yield Card(s, v)



}
