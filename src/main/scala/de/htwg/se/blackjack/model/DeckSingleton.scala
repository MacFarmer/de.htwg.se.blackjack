package de.htwg.se.blackjack.model

import scala.util.Random



class DeckSingleton extends Suit with Rank {

  /*sealed trait Suit {

    case object Heart extends Suit

    case object Diamond extends Suit

    case object Spade extends Suit

    case object Club extends Suit

  }

   abstract class Rank(val value: Int) {
    case object King extends Rank(10)
    case object Queen extends Rank(10)
    case object Jack extends Rank(10)
    case object Ten extends Rank(10)
    case object Nine extends Rank(9)
    case object Eight extends Rank(8)
    case object Seven extends Rank(7)
    case object Six extends Rank(6)
    case object Five extends Rank(5)
    case object Four extends Rank(4)
    case object Three extends Rank(3)
    case object Two extends Rank(2)
    case object Ace extends Rank(1)
  }*/

  val cards = collection.mutable.ListBuffer() ++ Random.shuffle(initDeck)

  def dealCard: Option[Card] = cards.isEmpty match {
    case true => None
    case false =>
      val card = cards.head
      cards -= card
      Some(card)
  }

  def initDeck =
    for {
      suit <- List(Heart, Diamond, Spade, Club)
      rank <- List(King, Queen, Jack, Ten, Nine, Eight, Seven, Six, Five, Four, Three, Two, Ace)
    }
      yield new Card(suit, rank)


  /*   val face = List(" DIAMOND ", " HEART ", " PIKE ", " CLOVER ")
     val suit = List("King", "Queen", "Jack", "Ace", "2", "3", "4", "5", "6", "7", "8", "9")
     val initDeck: List[Card] = for {
       s <- face
       v <- suit
     } yield new Card(s, v)
*/

  /*def shuffle()  = {
    Random.shuffle(cards)
    }

    def draw(): Card = {
      assert(countOfDeck > 0)
      countOfDeck -= 1
      cards(countOfDeck)
    }

    def pop() = {
      val top = cards.head
      cards = (cards - top)
      cards
    }*/


}
