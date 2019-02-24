package domain.games

import domain.{Players, Score}

abstract class Game(private val players: Players) {
  protected var currentScore = Score(0, 0)

  def wonBy(): Option[String]

  def pointWonBy(player: String): Unit = {
    if (player == players._1) {
      currentScore = Score(currentScore.player1Points + 1, currentScore.player2Points)
      return
    }
    currentScore = Score(currentScore.player1Points, currentScore.player2Points + 1)
  }

  def player1Points(): Int =
    currentScore.player1Points

  def player2Points(): Int =
    currentScore.player2Points
}
