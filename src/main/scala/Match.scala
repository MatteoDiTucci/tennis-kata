import scala.collection.mutable

case class Match(player1: String, player2: String) {

  private val game = Game(player1, player2)

  def scoresPoint(player: String): Unit =
    game.scoresPoint(player)

  def currentGameScore(): Score =
    game.score()
}

