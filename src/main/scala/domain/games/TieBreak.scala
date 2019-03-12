package domain.games

import domain.Player

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