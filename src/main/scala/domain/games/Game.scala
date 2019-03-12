package domain.games

import domain.TypeAlias.Player
import domain.Score

sealed abstract class Game(private val player1: Player, private val player2: Player) {
  protected var score = Score(player1, player2, 0, 0)

  def wonBy(): Option[Player]

  def pointWonBy(player: Player): Unit = {
    score = score.addOnePointToPlayer(player)
  }

  def pointsForPlayer(player: Player): Int = {
    score.pointsFor(player)
  }

  def leadingPlayerName(): String =
    score.leader()

}

class NormalGame(private val player1: Player, private val player2: Player) extends Game(player1, player2) {

  def wonBy(): Option[Player] = {
    if (isDeuce) {
      return None
    }

    if (isAdvantage) {
      return None
    }

    if (score.hasPlayerAtLeastPoints(player1, 4)) {
      return Some(player1)
    }

    if (score.hasPlayerAtLeastPoints(player2, 4)) {
      return Some(player2)
    }

    None
  }

  def isDeuce: Boolean =
    haveBothPlayersAtLeastPoints(3) && score.isTie

  def isAdvantage: Boolean =
    haveBothPlayersAtLeastPoints(3) && score.isPointsDifference(1)

  private def haveBothPlayersAtLeastPoints(points: Int) =
    score.hasPlayerAtLeastPoints(player1, points) && score.hasPlayerAtLeastPoints(player2, points)
}

class TieBreak(private val player1: Player, player2: Player) extends Game(player1, player2) {

  def wonBy(): Option[Player] = {
    if (score.hasPlayerAtLeastPoints(player1, 7) && score.isPointsDifference(2)) {
      return Some(player1)
    }

    if (score.hasPlayerAtLeastPoints(player1, 7) && score.isPointsDifference(2)) {
      return Some(player2)
    }

    None
  }
}
