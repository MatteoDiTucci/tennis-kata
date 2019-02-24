case class Match(private val player1: String, private val player2: String, private val gamePrinter: GameScorePrinter) {

  private val set = Set(player1, player2)

  def pointWonBy(player: String): Unit =
    set.pointWonBy(player)

  def score(): String =
    s"$setScore$currentGameScore"

  private def setScore: String =
    s"${set.score.player1Points}-${set.score.player2Points}"

  private def currentGameScore: String = {
    set.currentGameScore.fold("")(score => gamePrinter.print(score, player1, player2))
  }

}

