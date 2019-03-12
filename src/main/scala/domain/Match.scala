package domain

case class Match(private val player1: String, private val player2: String, private val formatter: Formatter) {

  private val set = Set(Player(player1), Player(player2))

  def pointWonBy(name: String): Unit =
    set.pointWonBy(Player(name))

  def score(): String =
    formatter.printMatchScore(set, Player(player1), Player(player2))

}
