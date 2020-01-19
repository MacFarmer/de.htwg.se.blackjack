package de.htwg.se.blackjack

import com.google.inject.AbstractModule
import de.htwg.se.blackjack.controller.controllerComponent.ControllerInterface
import de.htwg.se.blackjack.model.deckComponent.DeckInterface
import de.htwg.se.blackjack.model.handComponent.HandInterface
import de.htwg.se.blackjack.model.playerComponent.PlayerInterface
import de.htwg.se.blackjack.model.statusComponent.StatusInterface
import net.codingwell.scalaguice.ScalaModule

class BlackjackModule extends AbstractModule with ScalaModule{

  override def configure(): Unit = {

    bind[ControllerInterface].to[controller.controllerComponent.controllerBaseImpl.Controller]
    bind[HandInterface].to[model.handComponent.handBaseImpl.Hand]
    bind[StatusInterface].to[model.statusComponent.statusBaseImpl.StatusStrategy]
   // bind[DeckInterface].to[model.deckComponent.deckBaseImpl.Deck]
    bind[PlayerInterface].to[model.playerComponent.playerBaseImpl.Player]
  }
}
