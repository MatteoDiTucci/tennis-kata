case class Match(private val player1: String, private val player2: String) {

  private val set = Set(player1, player2)
  private val tennisGamePoints = Map(0 -> "0", 1 -> "15", 2 -> "30", 3 -> "40")

  def pointWonBy(player: String): Unit =
    set.pointWonBy(player)

  def score(): String =
    s"$setScore$currentGameScore"

  private def setScore: String =
    s"${set.score.player1Points}-${set.score.player2Points}"

  private def currentGameScore: String = {
    set.currentGameScore.fold("")(score => printCurrentGameScore(score))
  }

  private def printCurrentGameScore(score: Score): String = {
    if (score.moreThanThreePointsPerPlayer() && score.playerPointsAreEven) {
      return ", Deuce"
    }
    if (score.moreThanThreePointsPerPlayer() && score.onePlayerLeadsByOnePoint()) {
      return s", Advantage ${leadingPlayer(score)}"
    }

    s", ${tennisPoints(score.player1Points)}-${tennisPoints(score.player2Points)}"
  }

  private def leadingPlayer(score: Score): String = {
    if (score.isPlayer1Winning) {
      return player1
    }
    player2
  }

  private def tennisPoints(points: Int): String =
    tennisGamePoints.get(points).fold("")(e => e)

}

