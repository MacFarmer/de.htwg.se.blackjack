package de.htwg.se.blackjack.model.fileIoComponent

import de.htwg.se.blackjack.model.playerComponent.PlayerInterface
import de.htwg.se.blackjack.model.statusComponent.StatusInterface


trait FileIOInterface {

  def load: PlayerInterface
  def save(player: PlayerInterface): Unit

}
