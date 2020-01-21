//package de.htwg.se.blackjack.model.fileIoComponent.fileIoXmlImpl
//
//import java.io.{File, PrintWriter}
//
//import com.google.inject.Guice
//import de.htwg.se.blackjack.BlackjackModule
//import de.htwg.se.blackjack.model.cardComponent.cardBaseImpl.CardFactory
//import de.htwg.se.blackjack.model.fileIoComponent.FileIOInterface
//import de.htwg.se.blackjack.model.handComponent.HandInterface
//import de.htwg.se.blackjack.model.playerComponent.PlayerInterface
//import de.htwg.se.blackjack.model.playerComponent.playerBaseImpl.Player
//import de.htwg.se.blackjack.model.statusComponent.StatusInterface
//import de.htwg.se.blackjack.model.statusComponent.statusBaseImpl.StatusStrategy
//
//import scala.xml.{Elem, Node, PrettyPrinter}
//
//class FileIO extends FileIOInterface {
//
//  override def save(player: Player, dealer: Player): Unit = {
//    val pw = new PrintWriter((new File("BlackjackStatus.xml")))
//    val prettyPrinter = new PrettyPrinter(120, 4)
//    val xml = prettyPrinter.format(playerToXmL(player, dealer))
//    pw.write(xml)
//    pw.close
//  }
//
//  def playerToXmL(player: Player, dealer: Player) = {
//    <game>
//      <player>
//        <name player={player.name}></name>
//        <value playerValue={player.handValue().toString}></value>
//        <card playerCards={player.karte.toString}></card>
//      </player>
//      <dealer>
//        <name dealer={dealer.name}></name>
//       <value dealerValue={dealer.handValue().toString}></value>
//       <card dealerCards={dealer.karte.toString}></card>
//      </dealer>
//    </game>
//  }
//}