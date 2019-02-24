package domain

import domain.games.{Game, NormalGame, TieBreak}

case class Printer() {
  private val tennisPoints = Map(0 -> "0", 1 -> "15", 2 -> "30", 3 -> "40")

  def printCurrentGameScore(game: Option[Game], players: Players): String =
    game.fold("") {
      case normalGame: NormalGame => printNormalGame(normalGame, players)
      case tieBreak: TieBreak => printTieBreak(tieBreak)
    }

  def printGamesScore(set: Set) =
    s"${set.player1WonGames}-${set.player2WonGames}"

  private def printNormalGame(game: NormalGame, players: Players): String = {
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

  private def printTieBreak(game: TieBreak): String =
    s", ${game.player1Points()}-${game.player2Points()}"
}
