import scala.collection.mutable.ListBuffer

case class Set(players: Players) {

  private val games: ListBuffer[Game] = ListBuffer()

  def pointWonBy(player: String): Unit = {
    if (games.isEmpty || hasCurrentGameEnded) {
      createNewGame(player)
    }
    addPointInCurrentGame(player)
  }

  private def createNewGame(player: String) = {
    games += new Game(players)
  }

  private def addPointInCurrentGame(player: String): Unit = {
    games.last.pointWonBy(player)
  }


  def currentGame(): Option[Game] = {
    if (games.isEmpty) {
      return None
    }

    if (hasCurrentGameEnded) {
      return None
    }

    Some(games.last)
  }

  def gamesScore: Score = {
    val player1WonSets = games.count(game => game.wonBy().fold(false)(_ == players._1))
    val player2WonSets = games.count(game => game.wonBy().fold(false)(_ == players._2))
    Score(player1WonSets, player2WonSets)
  }

  private def hasCurrentGameEnded: Boolean =
    games.last.wonBy().fold(false)(_ => true)

}
