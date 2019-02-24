case class Match(player1: String, player2: String) {

  private val set = Set(player1, player2)

  def pointWonBy(player: String): Unit =
    set.pointWonBy(player)

  def score(): String =
    s"$setScore$currentGameScore"

  private def setScore: String =
    set.score.toString

  private def currentGameScore: String =
    set.currentGameScore.fold("")(score => s", $score")

}

