package domain.games

import domain.Players

class TieBreak(private val players: Players) extends Game(players) {

  def wonBy(): Option[String] = {
    if (currentScore.player1Points >= 7 && isAtLeastTwoPointsDifference) {
      return Some(players._1)
    }

    if (currentScore.player2Points >= 7 && isAtLeastTwoPointsDifference) {
      return Some(players._1)
    }

    None
  }

  private def isAtLeastTwoPointsDifference =
    Math.abs(currentScore.player1Points - currentScore.player2Points) >= 2
}