package de.htwg.se.blackjack.model

abstract class Deck {

  var blatt1:Blatt
  var wert1:Wert


  def initDeck() = {
    for {
      blatt <- List(blatt1.Herz, blatt1.Karo, blatt1.Pik, blatt1.Kreuz)
      rang <- List(wert1.King, wert1.Queen, wert1.Jack, wert1.Ten, wert1.Nine, wert1.Eight, wert1.Seven, wert1.Six, wert1.Five,
        wert1.Four, wert1.Three, wert1.Two, wert1.Ace1, wert1.Ace11)
    } yield Card(blatt, rang)
  }

  def main(args: Array[String]): Unit = {
    initDeck()
  }

}
