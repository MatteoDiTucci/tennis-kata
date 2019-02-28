package domain.games

import domain.{Player, Score}

abstract class Game(private val player1: Player, private val player2: Player) {
  protected var score = Score(player1, player2, 0, 0)

  def wonBy(): Option[Player]

  def pointWonBy(player: Player): Unit = {
    score = player.addOnePointTo(score)
  }

  def pointsForPlayer(player: Player): Int = {
    score.pointsFor(player)
  }

  def leadingPlayerName(): String =
    score.leader().name

}
