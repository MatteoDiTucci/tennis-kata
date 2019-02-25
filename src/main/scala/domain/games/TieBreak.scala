package domain.games

import domain.Players

class TieBreak(private val players: Players) extends Game(players) {

  def wonBy(): Option[String] = {
    if (score.hasPlayerAtLeastPoints(players._1, 7) && score.isPointsDifference(2)) {
      return Some(players._1)
    }

    if (score.hasPlayerAtLeastPoints(players._2, 7) && score.isPointsDifference(2)) {
      return Some(players._1)
    }

    None
  }
}