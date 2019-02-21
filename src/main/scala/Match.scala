import scala.collection.mutable

case class Match(player1: String, player2: String) {

  private val score: mutable.Map[String, Int] = mutable.Map(player1 -> 0, player2 -> 0)

  def scoresPoint(player: String): Unit =
    score.get(player).fold()(points => addOnePoint(player, points))

  def currentGameScore(): Score = {
    val player1Score = score.getOrElse(player1, 0)
    val player2Score = score.getOrElse(player2, 0)
    Score(player1, player1Score, player2, player2Score)
  }

  private def addOnePoint(player: String, points: Int) = {
    score += (player -> (points + 1))
  }
}

