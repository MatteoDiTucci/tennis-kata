package infrastructure

import domain.Set
import domain.TypeAlias.Player
import domain.games.{NormalGame, TieBreak}

case class Formatter() {
  private val tennisPoints = Map(0 -> "0", 1 -> "15", 2 -> "30", 3 -> "40")

  def formatMatchScore(set: Set, player1: Player, player2: Player): String = {
    gamesScore(set, player1, player2) + separator(set) + currentGameScore(set, player1, player2)
  }

  private def separator(set: Set): String = {
    set.currentGame().fold("")(_ => ", ")
  }

  private def gamesScore(set: Set, player1: Player, player2: Player) = {
    s"${set.gamesWonByPlayer(player1)}-${set.gamesWonByPlayer(player2)}"
  }

  private def currentGameScore(set: Set, player1: Player, player2: Player) = {
    set.currentGame().fold("") {
      case normal: NormalGame => normalGame(normal, player1, player2)
      case tieBreak: TieBreak => tieBreakGame(tieBreak, player1, player2)
    }
  }

  private def normalGame(game: NormalGame, player1: Player, player2: Player): String = {
    if (game.isDeuce) {
      return "Deuce"
    }

    if (game.isAdvantage) {
      return s"Advantage ${game.leadingPlayerName()}"
    }

    s"${toTennisPoints(game.pointsForPlayer(player1))}-${toTennisPoints(game.pointsForPlayer(player2))}"
  }

  private def toTennisPoints(points: Int): String =
    tennisPoints.get(points).fold("")(Predef.identity)

  private def tieBreakGame(game: TieBreak, player1: Player, player2: Player): String =
    s"${game.pointsForPlayer(player1)}-${game.pointsForPlayer(player2)}"
}
