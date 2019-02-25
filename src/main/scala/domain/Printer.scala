package domain

import domain.games.{NormalGame, TieBreak}

case class Printer() {
  private val tennisPoints = Map(0 -> "0", 1 -> "15", 2 -> "30", 3 -> "40")

  def printMatchScore(set: Set, players: Players): String = {
    gamesScore(set) + currentGameScore(set, players)
  }

  private def gamesScore(set: Set) = {
    s"${set.player1WonGames}-${set.player2WonGames}"
  }

  private def currentGameScore(set: Set, players: Players) = {
    set.currentGame().fold("") {
      case normalGame: NormalGame => printNormalGame(normalGame, players)
      case tieBreak: TieBreak => printTieBreak(tieBreak)
    }
  }

  private def printNormalGame(normalGame: NormalGame, players: Players): String = {
    if (normalGame.isDeuce) {
      return ", Deuce"
    }

    if (normalGame.isAdvantage) {
      return s", Advantage ${normalGame.leadingPlayer()}"
    }

    s", ${toTennisPoints(normalGame.player1Points())}-${toTennisPoints(normalGame.player2Points())}"
  }

  private def toTennisPoints(points: Int): String =
    tennisPoints.get(points).fold("")(Predef.identity)

  private def printTieBreak(game: TieBreak): String =
    s", ${game.player1Points()}-${game.player2Points()}"
}
