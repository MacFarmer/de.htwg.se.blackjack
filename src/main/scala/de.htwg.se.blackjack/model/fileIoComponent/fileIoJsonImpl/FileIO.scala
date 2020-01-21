package de.htwg.se.blackjack.model.fileIoComponent.fileIoJsonImpl

import com.google.inject.Guice
import  com.google.inject.name.Names
import de.htwg.se.blackjack.BlackjackModule
import de.htwg.se.blackjack.model.fileIoComponent.FileIOInterface
import de.htwg.se.blackjack.model.playerComponent.PlayerInterface
import de.htwg.se.blackjack.model.playerComponent.playerBaseImpl.Player
import play.api.libs.json.{JsString, JsValue, Json}
import net.codingwell.scalaguice.InjectorExtensions._
import play.api.libs.json._

import scala.io.Source

class FileIO extends FileIOInterface {


//  override def load: PlayerInterface = {
//    var player: PlayerInterface = null
//    val source: String = Source.fromFile("blackjack.json").getLines.mkString
//    val json: JsValue = Json.parse(source)
//    val injector  = Guice.createInjector(new BlackjackModule)
//    val playerData = (json \ "playerData" \ "playerName").get.toString()

//    player = injector.instance[PlayerInterface]

//    player
//  }

  override def save(player: Player, dealer: Player): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("BlackjackStatus.json"))
    pw.write(Json.prettyPrint(playertoJson(player, dealer)))
    pw.close()
  }

  def playertoJson(player: Player, dealer: Player) = {
    Json.obj(
      "playerData" -> Json.obj(
        "playerName" -> JsString(player.name),
        "playerValue" -> JsNumber(player.handValue()),
        "playerCards" -> JsString(player.karte.toString())),
      "dealerData" -> Json.obj(
        "dealerName" -> JsString(dealer.name),
        "dealerValue" -> JsNumber(dealer.handValue()),
        "dealerCards" -> JsString(dealer.karte.toString()))
      )
   }
}
