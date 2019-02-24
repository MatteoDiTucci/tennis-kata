import scala.collection.mutable.ListBuffer

case class Set(player1: String, player2: String) {

  private val games: ListBuffer[Game] = ListBuffer()

  def pointWonBy(player: String): Unit = {
    if (games.isEmpty || hasCurrentGameEnded) {
      createNewGame(player)
    }
    addPointInCurrentGame(player)
  }

  private def createNewGame(player: String) = {
    games += new Game(player1, player2)
  }

  private def addPointInCurrentGame(player: String): Unit = {
    games.last.pointWonBy(player)
  }


  def currentGameScore: Option[Score] = {
    if (games.isEmpty) {
      return None
    }

    if (hasCurrentGameEnded) {
      return None
    }

    Some(games.last.score())
  }

  def score: Score = {
    val player1WonSets = games.count(game => game.wonBy().fold(false)(_ == player1))
    val player2WonSets = games.count(game => game.wonBy().fold(false)(_ == player2))
    SetScore(player1WonSets, player2WonSets)
  }

  private def hasCurrentGameEnded: Boolean =
    games.last.wonBy().fold(false)(_ => true)

}
