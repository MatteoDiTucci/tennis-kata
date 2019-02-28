package domain

import domain.games.{Game, NormalGame, TieBreak}

import scala.collection.mutable.ListBuffer

case class Set(private val player1: Player, private val player2: Player) {

  private val games: ListBuffer[Game] = ListBuffer()

  def pointWonBy(player: Player): Unit = {
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

  def gamesWonByPlayer(player: Player): Int = {
    if (player == player1) {
      return games.count(game => game.wonBy().fold(false)(_ == player1))
    }
    games.count(game => game.wonBy().fold(false)(_ == player2))
  }

  private def createNewGame(player: Player): Unit = {
    if (gamesWonByPlayer(player1) == 6 && gamesWonByPlayer(player2) == 6) {
      games += new TieBreak(player1, player2)
      return
    }

    games += new NormalGame(player1, player2)
  }

  private def addPointInCurrentGame(player: Player): Unit = {
    games.last.pointWonBy(player)
  }

  private def hasCurrentGameEnded: Boolean =
    games.last.wonBy().fold(false)(_ => true)

}
