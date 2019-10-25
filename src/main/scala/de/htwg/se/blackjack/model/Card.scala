package de.htwg.se.blackjack.model

case class Card(card: String) {

  val clubs = Set("Ass Kreuz", "1 Kreuz", "2 Kreuz", "3 Kreuz", "4 Kreuz", "5 Kreuz", "6 Kreuz", "7 Kreuz", "8 Kreuz", "9 Kreuz",
                  "10 Kreuz", "Bube Kreuz", "Dame Kreuz", "König Kreuz")
  val diamond = Set("Ass Karo", "1 Karo", "2 Karo", "3 Karo", "4 Karo", "5 Karo", "6 Karo", "7 Karo", "8 Karo", "9 Karo",
                  "10 Karo", "Bube Karo", "Dame Karo", "König Karo")
  val heart = Set("Ass Herz", "1 Herz", "2 Herz", "3 Herz", "4 Herz", "5 Herz", "6 Herz", "7 Herz", "8 Herz", "9 Herz",
                  "10 Herz", "Bube Herz", "Dame Herz", "König Herz")
  val spade = Set("Ass Pik", "1 Pik", "2 Pik", "3 Pik", "4 Pik", "5 Pik", "6 Pik", "7 Pik", "8 Pik", "9 Pik",
                  "10 Pik", "Bube Pik", "Dame Pik", "König Pik")

  var currentCard = 0
}
