case class GameScorePrinter() {
  private val tennisGamePoints = Map(0 -> "0", 1 -> "15", 2 -> "30", 3 -> "40")

  def print(score: Score, players: Players): String = {
    if (score.moreThanThreePointsPerPlayer() && score.playerPointsAreEven) {
      return ", Deuce"
    }
    if (score.moreThanThreePointsPerPlayer() && score.onePlayerLeadsByOnePoint()) {
      return s", Advantage ${leadingPlayer(score, players)}"
    }

    s", ${tennisPoints(score.player1Points)}-${tennisPoints(score.player2Points)}"
  }

  private def leadingPlayer(score: Score, players: Players): String = {
    if (score.isPlayer1Winning) {
      return players._1
    }
    players._2
  }

  private def tennisPoints(points: Int): String =
    tennisGamePoints.get(points).fold("")(e => e)
}
