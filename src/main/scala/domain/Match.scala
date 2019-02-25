package domain

case class Match(private val players: Players, private val printer: Printer) {

  private val set = Set(players)

  def pointWonBy(player: String): Unit =
    set.pointWonBy(player)

  def score(): String =
    printer.printMatchScore(set, players)

}
