package de.htwg.se.blackjack.model.fileIoComponent

import de.htwg.se.blackjack.model.playerComponent.PlayerInterface
import de.htwg.se.blackjack.model.playerComponent.playerBaseImpl.Player
import de.htwg.se.blackjack.model.statusComponent.StatusInterface
import de.htwg.se.blackjack.model.statusComponent.statusBaseImpl.StatusStrategy


trait FileIOInterface {


  //  def load: StatusInterface

def save(player: Player, dealer: Player): Unit
}
