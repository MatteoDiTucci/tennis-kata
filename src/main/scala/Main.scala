import domain.{Match, Players, Printer}

object Main {

  def main(args: Array[String]): Unit = {
    val printer = Printer()
    val player1 = "player 1"
    val player2 = "player 2"
    val players = Players(player1, player2)

    val aMatch = Match(players, printer)
    aMatch.pointWonBy(player1)
    aMatch.pointWonBy(player2)
    // this will return "0-0, 15-15"
    println(aMatch.score())

    aMatch.pointWonBy(player1)
    aMatch.pointWonBy(player1)
    // this will return "0-0, 40-15"
    println(aMatch.score())

    aMatch.pointWonBy(player2)
    aMatch.pointWonBy(player2)
    // this will return "0-0, Deuce"
    println(aMatch.score())

    aMatch.pointWonBy(player1)
    // this will return "0-0, Advantage player 1"
    println(aMatch.score())

    aMatch.pointWonBy(player1)
    // this will return "1-0"
    println(aMatch.score())
  }
}
