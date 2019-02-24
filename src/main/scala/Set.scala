import scala.collection.mutable.ListBuffer

case class Set(private val players: Players) {

  private val games: ListBuffer[Game] = ListBuffer()

  def pointWonBy(player: String): Unit = {
    if (games.isEmpty || hasCurrentGameEnded) {
      createNewGame(player)
    }
    addPointInCurrentGame(player)
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

  def player1WonGames: Int =
    games.count(game => game.wonBy().fold(false)(_ == players._1))

  def player2WonGames: Int =
    games.count(game => game.wonBy().fold(false)(_ == players._2))


  private def createNewGame(player: String) = {
    games += new Game(players)
  }

  private def addPointInCurrentGame(player: String): Unit = {
    games.last.pointWonBy(player)
  }

  private def hasCurrentGameEnded: Boolean =
    games.last.wonBy().fold(false)(_ => true)

}
