package domain.games

import domain.{Players, Score}

abstract class Game(private val players: Players) {
  protected var currentScore = Score(0, 0)

  def wonBy(): Option[String]

  def pointWonBy(player: String): Unit = {
    if (player == players._1) {
      currentScore = currentScore.addOnePointToPlayer1()
      return
    }
    currentScore = currentScore.addOnePointToPlayer2()
  }

  def player1Points(): Int =
    currentScore.player1Points

  def player2Points(): Int =
    currentScore.player2Points
}
