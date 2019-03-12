package domain

import domain.games.{NormalGame, TieBreak}

case class Formatter() {
  private val tennisPoints = Map(0 -> "0", 1 -> "15", 2 -> "30", 3 -> "40")

  def printMatchScore(set: Set, player1: Player, player2: Player): String = {
    printGamesScore(set, player1, player2) + printCurrentGameScore(set, player1, player2)
  }

  private def printGamesScore(set: Set, player1: Player, player2: Player) = {
    s"${set.gamesWonByPlayer(player1)}-${set.gamesWonByPlayer(player2)}"
  }

  private def printCurrentGameScore(set: Set, player1: Player, player2: Player) = {
    set.currentGame().fold("") {
      case normalGame: NormalGame => printNormalGame(normalGame, player1, player2)
      case tieBreak: TieBreak => printTieBreak(tieBreak, player1, player2)
    }
  }

  private def printNormalGame(normalGame: NormalGame, player1: Player, player2: Player): String = {
    if (normalGame.isDeuce) {
      return ", Deuce"
    }

    if (normalGame.isAdvantage) {
      return s", Advantage ${normalGame.leadingPlayerName()}"
    }

    s", ${toTennisPoints(normalGame.pointsForPlayer(player1))}-${toTennisPoints(normalGame.pointsForPlayer(player2))}"
  }

  private def toTennisPoints(points: Int): String =
    tennisPoints.get(points).fold("")(Predef.identity)

  private def printTieBreak(game: TieBreak, player1: Player, player2: Player): String =
    s", ${game.pointsForPlayer(player1)}-${game.pointsForPlayer(player2)}"
}
