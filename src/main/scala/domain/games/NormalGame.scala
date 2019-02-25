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

    if (currentScore.hasPlayer1Points(4)) {
      return Some(players._1)
    }
    if (currentScore.hasPlayer2Points(4)) {
      return Some(players._2)
    }
    None
  }

  def leadingPlayer(): String = {
    if (currentScore.isPlayer1Leading) {
      return players._1
    }
    players._2
  }

  def isDeuce: Boolean =
    haveBothPlayersAtLeastPoints(3) && currentScore.isTie

  def isAdvantage: Boolean =
    haveBothPlayersAtLeastPoints(3) && currentScore.isPointsDifference(1)

  private def haveBothPlayersAtLeastPoints(points: Int) =
    currentScore.hasPlayer1AtLeastPoints(points) && currentScore.hasPlayer2AtLeastPoints(points)
}