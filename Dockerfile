FROM hseeberger/scala-sbt
WORKDIR /de.htwg.se.blackjack
ADD . /de.htwg.se.blackjack
CMD sbt test