package domain.games

import domain.{Players, Score}

abstract class Game(private val players: Players) {
  protected var score = Score(players, 0, 0)

  def wonBy(): Option[String]

  def pointWonBy(player: String): Unit = {
    if (player == players._1) {
      score = score.addOnePointToPlayer(players._1)
      return
    }
    score = score.addOnePointToPlayer(players._2)
  }

  def pointsForPlayer(player: String): Int = {
    if (player == players._1) {
      return score.pointsFor(players._1)
    }
    score.pointsFor(players._2)
  }
}
