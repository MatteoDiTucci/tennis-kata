import scala.collection.mutable

case class Game(player1: String, player2: String) {

  private val playersPoints = mutable.Map(player1 -> 0, player2 -> 0)

  def pointWonBy(player: String): Unit =
    playersPoints.get(player).map(addOnePoint(player, _))

  def score(): Score =
    Score(pointsFor(player1), pointsFor(player2))

  private def addOnePoint(player: String, points: Int) =
    playersPoints += (player -> (points + 1))

  private def pointsFor(player: String): Int =
    playersPoints.getOrElse(player, 0)
}
