case class SetScorePrinter() {

  def print(score: Score): String =
    s"${score.player1Points}-${score.player2Points}"

}
