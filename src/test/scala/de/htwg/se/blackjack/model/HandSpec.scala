package de.htwg.se.blackjack.model

import de.htwg.se.blackjack.model.handComponent.handBaseImpl.Hand
import de.htwg.se.blackjack.model.statusComponent.statusBaseImpl.StatusStrategy
import org.scalatest.{Matchers, WordSpec}

class HandSpec extends WordSpec with Matchers {
  "A Hand" when { "new" should {
    var hand = new Hand
    var status = new StatusStrategy
    status.generateDeck()
    var player = Array(status.draw())
    "a handvalue" in {
     // hand.handValue(player) should be(11)
    }
  }}
}
