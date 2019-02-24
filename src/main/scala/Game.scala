class Game(players: Players) {

  var currentScore = Score(0, 0)

  def pointWonBy(player: String): Unit = {
    if (player == players._1) {
      currentScore = Score(currentScore.player1Points + 1, currentScore.player2Points)
      return
    }
    currentScore = Score(currentScore.player1Points, currentScore.player2Points + 1)
  }


  def score(): Score =
    currentScore

  def wonBy(): Option[String] = {
    if (isDeuce) {
      return None
    }

    if (isAdvantage) {
      return None
    }

    if (currentScore.player1Points == 4) {
      return Some(players._1)
    }
    if (currentScore.player2Points == 4) {
      return Some(players._2)
    }
    None
  }

  def isDeuce: Boolean =
    currentScore.moreThanThreePointsPerPlayer && currentScore.playersPointsAreEven

  def isAdvantage: Boolean =
    currentScore.moreThanThreePointsPerPlayer && currentScore.onePlayerLeadsByOnePoint

  def leadingPlayer(): String = {
    if (currentScore.player1Points == currentScore.player2Points) {
      return players._1
    }
    players._2
  }
}
