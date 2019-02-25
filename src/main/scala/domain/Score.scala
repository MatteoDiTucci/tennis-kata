package domain

case class Score(player1Points: Int, player2Points: Int) {

  def addOnePointToPlayer1(): Score =
    Score(this.player1Points + 1, this.player2Points)

  def addOnePointToPlayer2(): Score =
    Score(this.player1Points, this.player2Points + 1)

  def hasPlayer1AtLeastPoints(points: Int): Boolean =
    player1Points >= points

  def hasPlayer2AtLeastPoints(points: Int): Boolean =
    player2Points >= points

  def hasPlayer1Points(points: Int): Boolean =
    player1Points == points

  def hasPlayer2Points(points: Int): Boolean =
    player2Points == points

  def isPlayer1Leading: Boolean =
    player1Points >= player2Points

  def isTie: Boolean =
    player1Points == player2Points

  def isPointsDifference(difference: Int): Boolean =
  Math.abs(player1Points - player2Points) == 1

}
