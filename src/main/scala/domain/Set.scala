package domain

import domain.games.{Game, NormalGame, TieBreak}

import scala.collection.mutable.ListBuffer

case class Set(private val players: Players) {

  private val games: ListBuffer[Game] = ListBuffer()

  def pointWonBy(player: String): Unit = {
    if (games.isEmpty || hasCurrentGameEnded) {
      createNewGame(player)
    }
    addPointInCurrentGame(player)
  }

  def currentGame(): Option[Game] = {
    if (games.isEmpty) {
      return None
    }

    if (hasCurrentGameEnded) {
      return None
    }

    Some(games.last)
  }

  def gamesWonByPlayer(player: String): Int = {
    if (player == players._1) {
      return games.count(game => game.wonBy().fold(false)(_ == players._1))
    }
    games.count(game => game.wonBy().fold(false)(_ == players._2))
  }

  private def createNewGame(player: String): Unit = {
    if (gamesWonByPlayer(players._1) == 6 && gamesWonByPlayer(players._2) == 6) {
      games += new TieBreak(players)
      return
    }

    games += new NormalGame(players)
  }

  private def addPointInCurrentGame(player: String): Unit = {
    games.last.pointWonBy(player)
  }

  private def hasCurrentGameEnded: Boolean =
    games.last.wonBy().fold(false)(_ => true)

}
