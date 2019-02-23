case class Match(player1: String, player2: String) {

  private val game = Game(player1, player2)

  def pointWonBy(player: String): Unit =
    game.pointWonBy(player)

  def score(): String =
    game.score().toString
}

