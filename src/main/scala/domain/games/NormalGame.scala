package domain.games

import domain.Players

class NormalGame(private val players: Players) extends Game(players) {
  def wonBy(): Option[String] = {
    if (isDeuce) {
      return None
    }

    if (isAdvantage) {
      return None
    }

    if (score.hasPlayerPoints(players._1, 4)) {
      return Some(players._1)
    }
    if (score.hasPlayerPoints(players._2, 4)) {
      return Some(players._2)
    }
    None
  }

  def leadingPlayer(): String = {
    if (score.isLeading(players._1)) {
      return players._1
    }
    players._2
  }

  def isDeuce: Boolean =
    haveBothPlayersAtLeastPoints(3) && score.isTie

  def isAdvantage: Boolean =
    haveBothPlayersAtLeastPoints(3) && score.isPointsDifference(1)

  private def haveBothPlayersAtLeastPoints(points: Int) =
    score.hasPlayerAtLeastPoints(players._1, points) && score.hasPlayerAtLeastPoints(players._2, points)
}