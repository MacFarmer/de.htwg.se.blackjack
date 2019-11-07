package de.htwg.se.blackjack.model



sealed trait Blatt {

  //repräsentiert Kartendeck - Herz, Karo, Pik, Kreuz

  case object Herz extends Blatt
  case object Karo extends Blatt
  case object Pik extends Blatt
  case object Kreuz extends Blatt
}
