import scala.collection.mutable

case class Game(player1: String, player2: String) {

  private val currentScore: mutable.Map[String, Int] =
    mutable.Map(player1 -> 0, player2 -> 0)

  def scoresPoint(player: String): Unit =
    currentScore.get(player).fold()(points => addOnePoint(player, points))

  def score(): Score = {
    val player1Points = currentScore.getOrElse(player1, 0)
    val player2Points = currentScore.getOrElse(player2, 0)
    Score(player1, player1Points, player2, player2Points)
  }

  private def addOnePoint(player: String, currentPoints: Int) = {
    currentScore += (player -> (currentPoints + 1))
  }

}
