case class Printer() {
  private val tennisPoints = Map(0 -> "0", 1 -> "15", 2 -> "30", 3 -> "40")

  def printCurrentGameScore(game: Option[Game], players: Players): String =
    game.fold("")(printCurrentGameScore(_, players))

  def printGamesScore(set: Set) =
    s"${set.player1WonGames}-${set.player2WonGames}"
  
  private def printCurrentGameScore(game: Game, players: Players): String = {
    if (game.isDeuce) {
      return ", Deuce"
    }
    if (game.isAdvantage) {
      return s", Advantage ${game.leadingPlayer()}"
    }

    s", ${toTennisPoints(game.player1Points())}-${toTennisPoints(game.player2Points())}"
  }

  private def toTennisPoints(points: Int): String =
    tennisPoints.get(points).fold("")(Predef.identity)
}

