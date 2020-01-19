package de.htwg.se.blackjack.model.fileIoComponent.fileIoXmlImpl

import java.io.{File, PrintWriter}

import com.google.inject.Guice
import de.htwg.se.blackjack.BlackjackModule
import de.htwg.se.blackjack.model.fileIoComponent.FileIOInterface
import de.htwg.se.blackjack.model.playerComponent.PlayerInterface

import scala.xml.{Elem, Node, PrettyPrinter}

class FileIO extends FileIOInterface {
  override def load: PlayerInterface = {
    var player: PlayerInterface = null
    val file: Elem = scala.xml.XML.loadFile("player.xml")
    val injector = Guice.createInjector(new BlackjackModule)
    player = injector.instance[PlayerInterface]
  }

}
