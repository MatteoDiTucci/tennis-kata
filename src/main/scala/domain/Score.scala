package domain

case class Score(
                  private val player1: Player,
                  private val player2: Player,
                  private val player1Points: Int,
                  private val player2Points: Int
                ) {

  def addOnePointToPlayer(player: Player): Score = {
    if (isPlayer1(player)) {
      return Score(player1, player2, player1Points + 1, player2Points)
    }
    Score(player1, player2, player1Points, player2Points + 1)
  }

  def hasPlayerAtLeastPoints(player: Player, points: Int): Boolean = {
    if (isPlayer1(player)) {
      return player1Points >= points
    }
    player2Points >= points
  }

  def leader(): Player = {
    if (player1Points >= player2Points) {
      return player1
    }
    player2
  }

  def isTie: Boolean =
    player1Points == player2Points

  def isPointsDifference(difference: Int): Boolean =
    Math.abs(player1Points - player2Points) == 1

  def pointsFor(player: Player): Int = {
    if (isPlayer1(player)) {
      return player1Points
    }
    player2Points
  }

  private def isPlayer1(player: Player) = {
    player == player1
  }
}
