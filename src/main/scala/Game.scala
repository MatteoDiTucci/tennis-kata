import scala.collection.mutable

class Game(players: Players) {

  private val playersPoints = mutable.Map(players._1 -> 0, players._2 -> 0)

  def pointWonBy(player: String): Unit =
    playersPoints.get(player).map(addOnePoint(player, _))

  def score(): Score =
    Score(pointsFor(players._1), pointsFor(players._2))

  def wonBy(): Option[String] = {
    if (moreThanThreePointsPerPlayer && playersPointsAreEven) {
      return None
    }

    if (moreThanThreePointsPerPlayer && onePlayerLeadsByOnePoint) {
      return None
    }

    if (hasWon(players._1)) {
      return Some(players._1)
    }
    if (hasWon(players._2)) {
      return Some(players._2)
    }
    None
  }

  def isDeuce: Boolean =
    moreThanThreePointsPerPlayer && playersPointsAreEven

  def isAdvantage: Boolean =
    moreThanThreePointsPerPlayer && onePlayerLeadsByOnePoint

  def leadingPlayer(): String = {
    if (pointsOf(players._1) == pointsOf(players._2)) {
      return players._1
    }
    players._2
  }

  private def addOnePoint(player: String, points: Int) =
    playersPoints += (player -> (points + 1))

  private def pointsFor(player: String): Int =
    playersPoints.getOrElse(player, 0)

  private def hasWon(player: String): Boolean =
    playersPoints.get(player).fold(false)(_ == 4)


  private def moreThanThreePointsPerPlayer: Boolean = {
    pointsOf(players._1) >= 3 && pointsOf(players._2) >= 3
  }

  private def playersPointsAreEven: Boolean = {
    pointsOf(players._1) == pointsOf(players._2)
  }

  private def onePlayerLeadsByOnePoint: Boolean = {
    if (Math.abs(pointsOf(players._1) - pointsOf(players._2)) == 1) {
      return true
    }
    false
  }

  private def pointsOf(player: String): Int =
    playersPoints.get(player).fold(0)(points => points)

}
