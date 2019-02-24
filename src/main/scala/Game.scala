import scala.collection.mutable

class Game(private val player1: String, private val player2: String) {

  private val playersPoints = mutable.Map(player1 -> 0, player2 -> 0)

  def pointWonBy(player: String): Unit =
    playersPoints.get(player).map(addOnePoint(player, _))

  def score(): Score =
    Score(pointsFor(player1), pointsFor(player2))

  def wonBy(): Option[String] = {
    if (moreThanThreePointsPerPlayer && playersPointsAreEven) {
      return None
    }

    if (moreThanThreePointsPerPlayer && onePlayerLeadsByOnePoint) {
      return None
    }

    if (hasWon(player1)) {
      return Some(player1)
    }
    if (hasWon(player2)) {
      return Some(player2)
    }
    None
  }

  private def addOnePoint(player: String, points: Int) =
    playersPoints += (player -> (points + 1))

  private def pointsFor(player: String): Int =
    playersPoints.getOrElse(player, 0)

  private def hasWon(player: String): Boolean =
    playersPoints.get(player).fold(false)(_ == 4)


  private def moreThanThreePointsPerPlayer: Boolean = {
    pointsOf(player1) >= 3 && pointsOf(player2) >= 3
  }

  private def playersPointsAreEven: Boolean = {
    pointsOf(player1) == pointsOf(player2)
  }

  private def onePlayerLeadsByOnePoint: Boolean = {
    if (Math.abs(pointsOf(player1) - pointsOf(player2)) == 1) {
      return true
    }
    false
  }

  private def pointsOf(player: String): Int =
    playersPoints.get(player).fold(0)(points => points)

}
