package de.htwg.se.blackjack.model.fileIoComponent.fileIoXmlImpl

import java.io.{File, PrintWriter}

import com.google.inject.Guice
import de.htwg.se.blackjack.BlackjackModule
import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.fileIoComponent.FileIOInterface
import de.htwg.se.blackjack.model.playerComponent.PlayerInterface

import scala.xml.{Elem, Node, PrettyPrinter}

class FileIO extends FileIOInterface {
  override def load: PlayerInterface = {
    val file: Elem = scala.xml.XML.loadFile("player.xml")
    val injector = Guice.createInjector(new BlackjackModule)
  }

  override def save(player: PlayerInterface): Unit = {
    val pw = new PrintWriter(new File("player.xml"))
    val prettyPrinter = new PrettyPrinter(120,4)
    val xml = prettyPrinter.format(playerToXml(player))
    pw.write(xml)
    pw.close()
  }

  def nameToXml(p: PlayerInterface): Elem = {
    <player name={p.getName}>
      <value>
        {p.handValue().toString}
      </value>
    </player>
  }

  def cardToXml(c: CardFactory): Elem = {
    <card suit={c.suit} face={c.face}>
    </card>
  }

  def handValueToXml(p: PlayerInterface): Elem = {
    <value handValue={p.handValue}>
    </value>
  }

}
