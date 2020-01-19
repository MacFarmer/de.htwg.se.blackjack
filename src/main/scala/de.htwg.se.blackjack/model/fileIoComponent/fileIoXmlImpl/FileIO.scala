package de.htwg.se.blackjack.model.fileIoComponent.fileIoXmlImpl

import java.io.{File, PrintWriter}

import com.google.inject.Guice
import de.htwg.se.blackjack.BlackjackModule
import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
import de.htwg.se.blackjack.model.fileIoComponent.FileIOInterface
import de.htwg.se.blackjack.model.handComponent.HandInterface
import de.htwg.se.blackjack.model.playerComponent.PlayerInterface
import de.htwg.se.blackjack.model.playerComponent.playerBaseImpl.Player
import de.htwg.se.blackjack.model.statusComponent.StatusInterface
import de.htwg.se.blackjack.model.statusComponent.statusBaseImpl.StatusStrategy

import scala.xml.{Elem, Node, PrettyPrinter}

class FileIO extends FileIOInterface {
  //  override def load: PlayerInterface = {
  //    val file: Elem = scala.xml.XML.loadFile("player.xml")
  //    val injector = Guice.createInjector(new BlackjackModule)
  //  }

  override def save(status: StatusStrategy): Unit = {
    val pw = new PrintWriter((new File("status.xml")))
    val prettyPrinter = new PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(statusToXml(status))
    pw.write(xml)
    pw.close
  }

  def statusToXml(status: StatusStrategy) = {
      <value>{status.handValue2()}</value>
  }
}