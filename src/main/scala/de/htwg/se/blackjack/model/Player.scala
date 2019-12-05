package de.htwg.se.blackjack.model

case class Player(name: String) {

  /*def Hand(card: Option[Card]): Player = {
    card match {
      case Some(x) => this.copy(cards = x :: cards)
      case None => this
    }
  }

  def hit : Card = {
    val c = cards.head
    c
  }

  override def toString:String ={
    name + "'s cards: " + cards
  }

  def betGetDouble(): Integer = {
    chips*2
  }
*/

  val cards = collection.mutable.ArrayBuffer[Card]()
  val winningValue = 21

  // Function to determine if the hand has an Ace
  def containsAce(): Boolean = cards.exists(c => c.suit == Ace)

  // Method that adds a card to the existing hand
  def addCard (c: Card) = cards += c

  // Function that computes the value of the hand
  def value(): Int = cards.foldLeft(0)((result, card) => result + card.rank.value)

  //Function that computes the value of the hand with an ace valued at 11 instead of 1
  def specialValue(): Int = if(containsAce()) value + 10 else value()

  //Check if this hand has lost (value > 21)
  def isBust: Boolean = value() > winningValue

  //Check if this hand wins over the hand specified
  def winsOver(otherHand: Player): Boolean = {
    val opponenBestValue = List(otherHand.value(), otherHand.specialValue()).filter(v => v <= winningValue).max
    val bestValue = List(value(), specialValue()).filter(v => v <= winningValue).max
    // Return true if all of this hand's best value is higher than the other hand's best value
    bestValue > opponenBestValue
  }

  //Return the cards in the hand
  //If the dealer flag is true, only the first card is shown
  def showCard(dealer: Boolean = false): String = {
    if (dealer) s"${cards.head.rank.value} X" else cards.map(c => c.rank.value) mkString ", "
  }


}
