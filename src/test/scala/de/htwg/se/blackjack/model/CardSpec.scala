package de.htwg.se.blackjack.model

import org.scalatest.{Matchers, WordSpec}

class CardSpec extends WordSpec with Matchers {
  "A Card" when { "new" should {
    val card1 = new Card("Diamonds", "8")
    val card2 = new Card("Hearts", "2")
    val card3 = new Card("Spades", "4")
    val card4 = new Card("Clubs", "3")
    //val card5 = new Card("Hearts", "Jack")
    "have a face" in {
      card1.face should be("Diamonds")
      card2.face should be("Hearts")
      card3.face should be("Spades")
      card4.face should be("Clubs")
      //card5.face should be("Hearts")
    }
    "have a suit" in {
      card1.suit should be("8")
      card2.suit should be("2")
      card3.suit should be("4")
      card4.suit should be("3")
      //card5.suit should be("Jack")
    }
    "also have value" in {
      card1.suit.toInt should be(8)
      card2.suit.toInt should be(2)
      card3.suit.toInt should be(4)
      card4.suit.toInt should be(3)
    }
    "also have a nice String represantation" in {
      card1.toString should be("a Diamonds of 8")
      card2.toString should be("a Hearts of 2")
      card3.toString should be("a Spades of 4")
      card4.toString should be("a Clubs of 3")
      //card5.toString should be("a Diamond of 8")
    }
  }}
}
