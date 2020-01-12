package de.htwg.se.blackjack.aview.Gui

import de.htwg.se.blackjack.controller.Controller
import de.htwg.se.blackjack.model.{Card, Player, Status}
import javafx.event.ActionEvent
import scalafx.Includes.handle
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control._
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.{StackPane, VBox}
import scalafx.scene.paint.Color.Black

import scala.collection.mutable.Stack

object Gui extends JFXApp {
  val status = new Status
  val controller = new Controller(status)
  var dealerStack = Stack[Card]()
  var playerStack = Stack[Card]()
  stage = new PrimaryStage {
  val menuPane = new StackPane()

      val menubar = new MenuBar {

        menus = List(
          new Menu("Game") {
            items = List(
              new MenuItem {
                text = "New Game"
                onAction = handle {
//                  content = Seq(view, label, buttonStart)
                  menuPane
                }
              }
            )
          },
          new Menu("Help") {
            items = List(
              new MenuItem {
                text = "About"
                onAction = (e: ActionEvent) => {
                  new Alert(AlertType.Information, "Contributors:\t\t Daniel Bersuch & Marc Freibauer\n" +
                    "Class:\t\t\t Software Engineering by Marko Boger\n" +
                    "Version: \t\t\t 1.0\n").showAndWait()
                }
              },
              new MenuItem {
                text = "Rules"
                onAction = (e: ActionEvent) => {
                  new Alert(AlertType.Information, "In the First Round you and the Dealer get 2 Cards\n" +
                    "The Values of the Card will be automatically summed up\n" +
                    "You can choose between 'Hit: Take another Card' or 'Stand: stand with your current cards\n" +
                    "The Dealer must take as long as he is bellow 17\n" +
                    "The Goal is not to be above 21 before the Dealer ist\n" +
                    "You Win if the Dealer is above 21 or has lower Value than you\n" +
                    "But you will loose if you get above 21 before the Dealer does or when the Dealer has higher Value than you\n").showAndWait()
                }
              }
            )
          },
          new Menu("Quit") {
            items = List(
              new MenuItem {
                text = "Quit"
                onAction = handle {
                  sys.exit(0)
                }
              }
            )
          }
        )
      }
      menubar.setId("menubar")
      title = "Blackjack"
    scene = new Scene {
      fill = Black

      val pane = new StackPane()
      val stack = new Stack[ImageView]

      val img = new Image("file:image\\background\\greenback.jpg")
      val view = new ImageView(img)
      val contentPane = new VBox()
      val buttonStart = new Button("Start Game")
      // Game Starts here after clicking Start Game Button
      buttonStart.onAction = (e: ActionEvent) => {
        controller.generateDeck
        controller.shuffleDeck
        val CardImg = new ImageView(new Image("file:image\\cards\\red_back.png", 86, 110, false, true))
        CardImg.layoutX = 820
        CardImg.layoutY = 80

        val player = Player("Player")
        val dealer = Player("Dealer")

        player.addCard(controller.draw())
        val Playerimg1 = new ImageView(new Image("file:image\\cards\\" + player.karte.top.face + "" + player.karte.top.suit + ".png", 86, 110, false, true))
        Playerimg1.layoutX = 500
        Playerimg1.layoutY = 430
        dealer.addCard(controller.draw())
        val Dealerimg1 = new ImageView(new Image("file:image\\cards\\" + dealer.karte.top.face + "" + dealer.karte.top.suit + ".png", 86, 110, false, true))
        Dealerimg1.layoutX = 500
        Dealerimg1.layoutY = 80
        player.addCard(controller.draw())
        val Playerimg2 = new ImageView(new Image("file:image\\cards\\" + player.karte.top.face + "" + player.karte.top.suit + ".png", 86, 110, false, true))
        Playerimg2.layoutX = 560
        Playerimg2.layoutY = 430
        dealer.addCard(controller.draw())
        val Dealerimg2 = new ImageView(new Image("file:image\\cards\\" + dealer.karte.top.face + "" + dealer.karte.top.suit + ".png", 86, 110, false, true))
        Dealerimg2.layoutX = 560
        Dealerimg2.layoutY = 80
//        val Dealerimg2 = new ImageView(new Image("file:image\\cards\\" + dealer.karte.last.face + "" + dealer.karte.last.suit + ".png", 88, 62, false, true))

        //Player Label
        val playerLabel = new Label(player.name + ": " + player.handValue())
        playerLabel.layoutY = 550
        playerLabel.layoutX = 560

//        val img2 = new ImageView(new Image("file:image\\cards\\" + player.karte.last.face + "" + player.karte.last.suit + ".png", 88, 62, false, true))

        //Dealer Label
        val dealerLabel = new Label(dealer.name + " " + dealer.handValue())
        dealerLabel.layoutY = 35
        dealerLabel.layoutX = 560

        //
        val hitButton = new Button("Hit")
        hitButton.layoutY = 250
        hitButton.layoutX = 530

        val standButton = new Button("Stand")
        standButton.layoutY = 250
        standButton.layoutX = 590

        // Check if Player is below 21

          hitButton.onAction = (e: ActionEvent) => {
            if((player.handValue() < 21) && (dealer.handValue() <= 21)) {
            player.addCard(controller.draw())
//            hitButton.layoutY = 125
//            hitButton.layoutX = 560
              val img2 = new ImageView(new Image("file:image\\cards\\" + player.karte.top.face + "" + player.karte.top.suit + ".png", 88, 62, false, true))
              playerLabel.setText(player.name + ": " + player.handValue().toString)
//              val Playerimg2 = new ImageView(new Image("file:image\\cards\\" + player.karte.last.face + "" + player.karte.last.suit + ".png", 86, 95, false, true))
              Playerimg2.setImage(new Image("file:image\\cards\\" + player.karte.top.face + "" + player.karte.top.suit + ".png", 86, 110, false, true))
              content = List(view, menubar, hitButton, standButton, dealerLabel, Dealerimg1, Dealerimg2, playerLabel, Playerimg1, Playerimg2, CardImg)
          } else {
              if(player.handValue() > 21 && dealer.handValue() <= 21) {
                new Alert(AlertType.Information, "Player Bust!").showAndWait()
                content = Seq(view, menubar,  label, buttonStart)
              } else if (player.handValue() == 21 && dealer.handValue() != 21) {
                new Alert(AlertType.Information, "Player has a BLACKJACK!").showAndWait()
                content = Seq(view, menubar,  label, buttonStart)
              } else if (player.handValue() < dealer.handValue() && dealer.handValue() <= 21) {
                new Alert(AlertType.Information, "Dealer Wins!").showAndWait()
                content = Seq(view, menubar,  label, buttonStart)
              } else if (player.handValue() < dealer.handValue() && dealer.handValue() > 21) {
                new Alert(AlertType.Information, "Player Wins!").showAndWait()
                content = Seq(view, menubar,  label, buttonStart)
              } else if ((player.handValue() == dealer.handValue()) && player.handValue() <= 21) {
                new Alert(AlertType.Information, "You have a Tie!").showAndWait()
                content = Seq(view, menubar,  label, buttonStart)
              }
              content = Seq(view, menubar,  label, buttonStart)

            }
//              content = List(view, menubar, hitButton, standButton, dealerLabel, Dealerimg1, Dealerimg2, playerLabel, Playerimg1, Playerimg2, CardImg)


        }
        content = List(view, menubar, hitButton, standButton, dealerLabel, Dealerimg1, Dealerimg2, playerLabel, Playerimg1, Playerimg2, CardImg)

        standButton.onAction = (e: ActionEvent) => {
          while(dealer.handValue() < 17) {
            dealer.addCard(controller.draw())
            Dealerimg2.setImage(new Image("file:image\\cards\\" + dealer.karte.top.face + "" + dealer.karte.top.suit + ".png", 86, 110, false, true))
            dealerLabel.setText(dealer.name + ": " + dealer.handValue())
            content = List(view, menubar, hitButton, standButton, dealerLabel, Dealerimg1, Dealerimg2, playerLabel, Playerimg1, Playerimg2, CardImg)
          }

            if(dealer.handValue() > 21 && player.handValue() <= 21) {
              new Alert(AlertType.Information, "Dealer Bust!").showAndWait()
            } else if ((player.handValue() > dealer.handValue()) && player.handValue() < 21) {
              new Alert(AlertType.Information, "Player Wins 222!").showAndWait()
            } else if (player.handValue() == 21 && dealer.handValue() != 21) {
              new Alert(AlertType.Information, "Player has a BLACKJACK!").showAndWait()
            } else if (player.handValue() < dealer.handValue() && dealer.handValue() < 21) {
              new Alert(AlertType.Information, "Dealer Win!").showAndWait()
            } else if (dealer.handValue() == 21 && player.handValue() != 21) {
              new Alert(AlertType.Information, "Dealer has a BLACKJACK!").showAndWait()
            } else if (player.handValue() > dealer.handValue() && player.handValue() > 21) {
              new Alert(AlertType.Information, "Player Bust!").showAndWait()
            } else if (player.handValue() < dealer.handValue() && dealer.handValue() < 21) {
              new Alert(AlertType.Information, "Dealer Win!").showAndWait()
            } else if (player.handValue() == dealer.handValue() && dealer.handValue() <= 21) {
              new Alert(AlertType.Information, "You have a Tie!").showAndWait()
            }
          content = Seq(view, menubar,  label, buttonStart)

        }

        if (dealer.handValue() > 21) {
          new Alert(AlertType.Information, "Dealer Bust!").showAndWait()
          content = Seq(view, menubar,  label, buttonStart)
        }

        if (player.handValue() > 21) {
          new Alert(AlertType.Information, "Player Bust!").showAndWait()
          content = Seq(view, menubar,  label, buttonStart)
        }

      }


      buttonStart.layoutX = 550
      buttonStart.layoutY = 500
      val label = new Label("Welcome to Blackjack!") {
        style = "-fx-font-size: 48pt"
        padding = Insets(20)
      }
      label.layoutX = 250
      label.layoutY = 150
      //content = Seq(view, menubar, label, buttonStart)

      //val img = new Image("")
      //val view = new ImageView(img, img)
      //view.delegate
      pane.children = List(menubar, view, label)
      content = Seq(view, menubar,  label, buttonStart)
    }
  }


  def openImage(hand: Card) = {
    val img = new ImageView(new Image("file:image\\cards\\" + hand.face + "" + hand.suit + ".png", 88, 62, false, true))
  }
}
