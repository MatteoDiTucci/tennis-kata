case class Score(player1Points: Int, player2Points: Int) {

  def moreThanThreePointsPerPlayer(): Boolean = {
    player1Points >= 3 && player2Points >= 3
  }

  def playersPointsAreEven: Boolean = {
    player1Points == player2Points
  }

  def onePlayerLeadsByOnePoint(): Boolean = {
    if (Math.abs(player1Points - player2Points) == 1) {
      return true
    }
    false
  }

  def addOnePointToPlayer1: Score =
    Score(this.player1Points + 1, this.player2Points)

  def addOnePointToPlayer2: Score =
    Score(this.player1Points, this.player2Points + 1)

  def hasPlayer1FourPoints: Boolean =
    player1Points == 4

  def hasPlayer2FourPoints: Boolean =
    player1Points == 4

  def isPlayer1Leading: Boolean =
    player1Points >= player2Points
}
