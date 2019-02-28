package domain.games

import domain.Player

class NormalGame(private val player1: Player, private val player2: Player) extends Game(player1, player2) {

  def wonBy(): Option[Player] = {
    if (isDeuce) {
      return None
    }

    if (isAdvantage) {
      return None
    }

    if (player1.hasAtLeastPoints(score, 4)) {
      return Some(player1)
    }

    if (player2.hasAtLeastPoints(score, 4)) {
      return Some(player2)
    }

    None
  }

  def isDeuce: Boolean =
    haveBothPlayersAtLeastPoints(3) && score.isTie

  def isAdvantage: Boolean =
    haveBothPlayersAtLeastPoints(3) && score.isPointsDifference(1)

  private def haveBothPlayersAtLeastPoints(points: Int) =
    player1.hasAtLeastPoints(score, points) && player2.hasAtLeastPoints(score, points)
}