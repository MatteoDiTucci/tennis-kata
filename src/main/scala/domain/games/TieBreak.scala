package domain.games

import domain.Players

class TieBreak(private val players: Players) extends Game(players) {

  def wonBy(): Option[String] = {
    if (currentScore.hasPlayer1AtLeastPoints(7) && currentScore.isPointsDifference(2)) {
      return Some(players._1)
    }

    if (currentScore.hasPlayer2AtLeastPoints(7) && currentScore.isPointsDifference(2)) {
      return Some(players._1)
    }

    None
  }
}