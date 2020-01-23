package de.htwg.se.blackjack

import com.google.inject.AbstractModule
import de.htwg.se.blackjack.controller.controllerComponent.ControllerInterface
import de.htwg.se.blackjack.model.deckComponent.DeckInterface
import de.htwg.se.blackjack.model.fileIoComponent.FileIOInterface

import de.htwg.se.blackjack.model.playerComponent.PlayerInterface
import de.htwg.se.blackjack.model.statusComponent.StatusInterface
import de.htwg.se.blackjack.model.fileIoComponent._
import net.codingwell.scalaguice.ScalaModule

class BlackjackModule extends AbstractModule with ScalaModule{

  override def configure(): Unit = {

    bind[ControllerInterface].to[controller.controllerComponent.controllerBaseImpl.Controller]
    bind[StatusInterface].to[model.statusComponent.statusBaseImpl.StatusStrategy]
 //   bind[FileIOInterface].to[fileIoJsonImpl.FileIO]
   // bind[DeckInterface].to[model.deckComponent.deckBaseImpl.Deck]
   // bind[PlayerInterface].to[model.playerComponent.playerBaseImpl.Player]
    bind[FileIOInterface].to[model.fileIoComponent.fileIoXmlImpl.FileIO]
  }
}

