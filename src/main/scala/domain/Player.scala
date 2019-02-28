package domain

case class Player(name: String) {

  def hasAtLeastPoints(score: Score, points: Int): Boolean =
    score.hasPlayerAtLeastPoints(this, points)

  def addOnePointTo(score: Score): Score =
    score.addOnePointToPlayer(this)

}
