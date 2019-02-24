class Game(private val players: Players) {

  private var currentScore = Score(0, 0)

  def pointWonBy(player: String): Unit = {
    if (player == players._1) {
      currentScore = currentScore.addOnePointToPlayer1
      return
    }
    currentScore = currentScore.addOnePointToPlayer2
  }

  def player1Points(): Int =
    currentScore.player1Points

  def player2Points(): Int =
    currentScore.player2Points

  def wonBy(): Option[String] = {
    if (isDeuce) {
      return None
    }

    if (isAdvantage) {
      return None
    }

    if (currentScore.hasPlayer1FourPoints) {
      return Some(players._1)
    }
    if (currentScore.hasPlayer2FourPoints) {
      return Some(players._2)
    }
    None
  }

  def isDeuce: Boolean =
    currentScore.moreThanThreePointsPerPlayer && currentScore.playersPointsAreEven

  def isAdvantage: Boolean =
    currentScore.moreThanThreePointsPerPlayer && currentScore.onePlayerLeadsByOnePoint

  def leadingPlayer(): String = {
    if (currentScore.isPlayer1Leading) {
      return players._1
    }
    players._2
  }
}
