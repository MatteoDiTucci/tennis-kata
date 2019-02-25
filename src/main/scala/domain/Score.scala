package domain

case class Score(private val players: Players, private val player1Points: Int, private val player2Points: Int) {

  def addOnePointToPlayer(player: String): Score = {
    if (player == players._1) {
      return Score(this.players, this.player1Points + 1, player2Points)
    }
    Score(this.players, this.player1Points, player2Points + 1)
  }

  def hasPlayerAtLeastPoints(player: String, points: Int): Boolean = {
    if (player == players._1) {
      return player1Points >= points
    }
    player2Points >= points
  }


  def hasPlayerPoints(player: String, points: Int): Boolean = {
    if (player == players._1) {
      return player1Points == points
    }
    player2Points == points
  }

  def isLeading(player: String): Boolean = {
    if (player == players._1) {
      return player1Points >= player2Points
    }
    player2Points >= player1Points
  }

  def isTie: Boolean =
    player1Points == player2Points

  def isPointsDifference(difference: Int): Boolean =
    Math.abs(player1Points - player2Points) == 1

  def pointsFor(player: String): Int = {
    if (player == players._1) {
      return player1Points
    }
    player2Points
  }

}
