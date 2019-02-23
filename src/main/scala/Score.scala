case class Score(player1Points: Int, player2Points: Int) {

  private val pointsToTennisPoints = Map(0 -> "0", 1 -> "15", 2 -> "30", 3 -> "40")

  override def toString: String =
    s"${tennisPoints(player1Points)}-${tennisPoints(player2Points)}"

  private def tennisPoints(points: Int): String =
    pointsToTennisPoints.get(points).fold("")(e => e)
}
