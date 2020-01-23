package de.htwg.se.blackjack.model.fileIoComponent.fileIoXmlImpl

import java.io.{File, PrintWriter}

import com.google.inject.Guice
import de.htwg.se.blackjack.BlackjackModule
import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.fileIoComponent.FileIOInterface
import de.htwg.se.blackjack.model.playerComponent.PlayerInterface
import de.htwg.se.blackjack.model.playerComponent.playerBaseImpl.Player
import de.htwg.se.blackjack.model.statusComponent.StatusInterface
import de.htwg.se.blackjack.model.statusComponent.statusBaseImpl.StatusStrategy
import scala.collection.mutable.Stack
import scala.collection.mutable
import scala.xml.{Elem, Node, PrettyPrinter}

class FileIO extends FileIOInterface {

  override def save(player: Player, dealer: Player): Unit = {
    val pw = new PrintWriter((new File("BlackjackStatus.xml")))
    val prettyPrinter = new PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(playerToXmL(player, dealer))
    pw.write(xml)
    pw.close
  }

  def load() = {
    var player: Player = null
    val injector = Guice.createInjector(new BlackjackModule)
    val file = scala.xml.XML.loadFile("Blackjackstatus.xml")
    val playerName = (file \\ "game" \ "player" \ "name").text.toString()
    val playerValue = (file \\ "game" \ "player" \ "value").text.toInt
    val playerCards = (file \\ "game" \ "player" \ "@card")
    //player.karte.empty
   // player.karte.insert(0, playerCards.head)
    val dealerName = (file \\ "game" \ "dealer" \ "name").text.toString()
    val dealerValue = (file \\ "game" \ "player" \ "value").text.toInt
    //println(playerName + playerValue + dealerName + dealerValue + playerCards.getClass)
    //player.set(playerName, playerCards)
  }

  def playerToXmL(player: Player, dealer: Player) = {
    <game>
      <player>
        <name>{player.name}</name>
        <value>{player.handValue().toString}</value>
        <card>{player.karte}</card>
      </player>
      <dealer>
        <name>{dealer.name}</name>
       <value>{dealer.handValue().toString}</value>
       <card>{dealer.karte.toString()}</card>
      </dealer>
    </game>
  }
}