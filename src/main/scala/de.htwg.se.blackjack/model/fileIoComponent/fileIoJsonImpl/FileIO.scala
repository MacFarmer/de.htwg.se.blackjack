package de.htwg.se.blackjack.model.fileIoComponent.fileIoJsonImpl

import com.google.inject.Guice
import de.htwg.se.blackjack.BlackjackModule
import de.htwg.se.blackjack.model.fileIoComponent.FileIOInterface
import de.htwg.se.blackjack.model.playerComponent.PlayerInterface
import de.htwg.se.blackjack.model.playerComponent.playerBaseImpl.Player
import play.api.libs.json.{JsString, JsValue, Json}

import com.google.inject.Guice
import com.google.inject.name.Names
import net.codingwell.scalaguice.InjectorExtensions._
import play.api.libs.json._

import scala.io.Source

class FileIO extends FileIOInterface {


  override def load: PlayerInterface = {
    var player: PlayerInterface = null
    val source: String = Source.fromFile("blackjack.json").getLines.mkString
    val json: JsValue = Json.parse(source)
    val injector  = Guice.createInjector(new BlackjackModule)
    val playerData = (json \ "playerData" \ "playerName").get.toString()

    player = injector.instance[PlayerInterface]

    player
  }

  override def save(player: PlayerInterface): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("blackjack.json"))
    pw.write(Json.prettyPrint(playertoJson(player)))
    pw.close()
  }

  def playertoJson(player: PlayerInterface) = {

    Json.obj(
      "playerData" -> Json.obj(
        "playerName" -> JsString(player.getName()),
        "playerCards" -> JsString(player.getPlayerStack().toString())
      )
    )
  }

}
