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

    if (currentScore.player1Points == 4) {
      return Some(players._1)
    }
    if (currentScore.player2Points == 4) {
      return Some(players._2)
    }
    None
  }

  def isDeuce: Boolean =
    hasBothPlayersAtLeastPoints(3) && currentScore.player1Points == currentScore.player2Points

  def isAdvantage: Boolean =
    hasBothPlayersAtLeastPoints(3) && Math.abs(currentScore.player1Points - currentScore.player2Points) == 1

  def leadingPlayer(): String = {
    if (currentScore.player1Points >= currentScore.player2Points) {
      return players._1
    }
    players._2
  }

  private def hasBothPlayersAtLeastPoints(points: Int) =
    currentScore.player1Points >= points && currentScore.player2Points >= points
}