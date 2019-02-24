sealed abstract class Score(player1Points: Int, player2Points: Int)

case class GameScore(player1Points: Int, player2Points: Int) extends Score(player1Points, player1Points){

  private val tennisGamePoints = Map(0 -> "0", 1 -> "15", 2 -> "30", 3 -> "40")

  override def toString: String =
    s"${tennisPoints(player1Points)}-${tennisPoints(player2Points)}"

  private def tennisPoints(points: Int): String =
    tennisGamePoints.get(points).fold("")(e => e)
}

case class SetScore(player1Points: Int, player2Points: Int) extends Score(player1Points, player1Points){
  override def toString: String =
    s"$player1Points-$player2Points"
}
