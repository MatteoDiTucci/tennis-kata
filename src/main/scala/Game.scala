import scala.collection.mutable

class Game(player1: String, player2: String) {

  private val playersPoints = mutable.Map(player1 -> 0, player2 -> 0)

  def pointWonBy(player: String): Unit =
    playersPoints.get(player).map(addOnePoint(player, _))

  def score(): Score =
    GameScore(pointsFor(player1), pointsFor(player2))

  def wonBy(): Option[String] = {
    if (wonBy(player1)) {
      return Some(player1)
    }
    if (wonBy(player2)) {
      return Some(player2)
    }
    None
  }

  private def addOnePoint(player: String, points: Int) =
    playersPoints += (player -> (points + 1))

  private def pointsFor(player: String): Int =
    playersPoints.getOrElse(player, 0)

  private def wonBy(player: String): Boolean =
    playersPoints.get(player).fold(false)(_ == 4)

}
