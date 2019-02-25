package domain

import domain.games.{NormalGame, TieBreak}

case class Printer() {
  private val tennisPoints = Map(0 -> "0", 1 -> "15", 2 -> "30", 3 -> "40")

  def printMatchScore(set: Set, players: Players): String = {
    gamesScore(set, players) + currentGameScore(set, players)
  }

  private def gamesScore(set: Set, players: Players) = {
    s"${set.gamesWonByPlayer(players._1)}-${set.gamesWonByPlayer(players._2)}"
  }

  private def currentGameScore(set: Set, players: Players) = {
    set.currentGame().fold("") {
      case normalGame: NormalGame => printNormalGame(normalGame, players)
      case tieBreak: TieBreak => printTieBreak(tieBreak, players)
    }
  }

  private def printNormalGame(normalGame: NormalGame, players: Players): String = {
    if (normalGame.isDeuce) {
      return ", Deuce"
    }

    if (normalGame.isAdvantage) {
      return s", Advantage ${normalGame.leadingPlayer()}"
    }

    s", ${toTennisPoints(normalGame.pointsForPlayer(players._1))}-${toTennisPoints(normalGame.pointsForPlayer(players._2))}"
  }

  private def toTennisPoints(points: Int): String =
    tennisPoints.get(points).fold("")(Predef.identity)

  private def printTieBreak(game: TieBreak, players: Players): String =
    s", ${game.pointsForPlayer(players._1)}-${game.pointsForPlayer(players._2)}"
}
