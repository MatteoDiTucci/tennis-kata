case class GameScorePrinter() {
  private val tennisGamePoints = Map(0 -> "0", 1 -> "15", 2 -> "30", 3 -> "40")

  def printCurrentGameScore(game: Option[Game], players: Players): String =
    game.fold("")(printCurrentGameScore(_, players))

  private def printCurrentGameScore(game: Game, players: Players): String = {
    if (game.isDeuce) {
      return ", Deuce"
    }
    if (game.isAdvantage) {
      return s", Advantage ${game.leadingPlayer()}"
    }

    s", ${tennisPoints(game.score().player1Points)}-${tennisPoints(game.score().player2Points)}"
  }

  private def tennisPoints(points: Int): String =
    tennisGamePoints.get(points).fold("")(e => e)

  def printGamesScore(score: Score): String =
    s"${score.player1Points}-${score.player2Points}"
}

