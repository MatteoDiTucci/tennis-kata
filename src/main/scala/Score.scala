case class Score(player1Points: Int, player2Points: Int) {
  def moreThanThreePointsPerPlayer(): Boolean = {
    player1Points >= 3 && player2Points >= 3
  }

  def playerPointsAreEven: Boolean = {
    player1Points == player2Points
  }

  def onePlayerLeadsByOnePoint(): Boolean = {
    if (Math.abs(player1Points - player2Points) == 1) {
      return true
    }
    false
  }

  def isPlayer1Winning: Boolean =
    player1Points >= player2Points
}
