case class Match(private val players: Players, private val gamePrinter: GameScorePrinter) {

  private val set = Set(players)

  def pointWonBy(player: String): Unit =
    set.pointWonBy(player)

  def score(): String =
    s"$printGamesScore$printCurrentGameScore"

  private def printGamesScore: String =
    gamePrinter.printGamesScore(set.gamesScore)

  private def printCurrentGameScore: String = {
    gamePrinter.printCurrentGameScore(set.currentGame(), players)
  }

}

