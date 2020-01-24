package de.htwg.se.blackjack.controller.GameStateComponent.GameStateImpl

import de.htwg.se.blackjack.controller.GameState
import org.scalatest.{Matchers, WordSpec}

class GameStateSpec extends WordSpec with Matchers {
  " A GameState " when {
    " new " should {
      val won = GameState.WON
      val lost = GameState.LOST.id
      val bust = GameState.BUST.id
      val push = GameState.PUSH.id
    }
    "Won" in {
       GameState.WON.id should be(1)
    }
    "Lost" in {
      GameState.LOST.id should be(-1)
    }
    "Bust" in {
      GameState.BUST.id should be(-1)
    }
    "Push" in {
      GameState.PUSH.id should be(0)
    }
  }
}
