package domain

case class Match(private val player1: String, private val player2: String, private val formatter: Formatter) {

  private val set = Set(player1, player2)

  def pointWonBy(name: String): Unit =
    set.pointWonBy(name)

  def score(): String =
    formatter.formatMatchScore(set, player1, player2)

}
