case class Match(private val players: Players, private val gamePrinter: GameScorePrinter, setScorePrinter: SetScorePrinter) {

  private val set = Set(players._1, players._2)

  def pointWonBy(player: String): Unit =
    set.pointWonBy(player)

  def score(): String =
    s"$setScore$currentGameScore"

  private def setScore: String =
    setScorePrinter.print(set.score)

  private def currentGameScore: String = {
    set.currentGameScore.fold("")(score => gamePrinter.print(score, players))
  }

}

