import org.scalatest.{MustMatchers, WordSpec}

class MatchSpec extends WordSpec with MustMatchers {

  private val gameScorePrinter = GameScorePrinter()
  private val setScorePrinter = SetScorePrinter()

  "Match" when {

    "a new match is started" should {

      "return 0-0" in {
        val aMatch = Match("Player A", "Player B", gameScorePrinter, setScorePrinter)

        aMatch.score() mustBe "0-0"
      }
    }
  }

  "first player scores 2 points and second player scores 1 point" should {

    "return 0-0, 30-15" in {
      val aMatch = Match("Player A", "Player B", gameScorePrinter, setScorePrinter)

      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player B")

      aMatch.score() mustBe "0-0, 30-15"
    }
  }

  "first player scores 2 points and second player scores 3 point" should {

    "return 0-0, 30-40" in {
      val aMatch = Match("Player A", "Player B", gameScorePrinter, setScorePrinter)

      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player B")
      aMatch.pointWonBy("Player B")
      aMatch.pointWonBy("Player B")

      aMatch.score() mustBe "0-0, 30-40"
    }
  }

  "first player scores 4 points and second player scores 0 point" should {

    "return 1-0" in {
      val aMatch = Match("Player A", "Player B", gameScorePrinter, setScorePrinter)

      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player A")

      aMatch.score() mustBe "1-0"
    }
  }

  "first player scores 3 points and second player scores 3 points" should {

    "return 0-0, Deuce" in {
      val aMatch = Match("Player A", "Player B", gameScorePrinter, setScorePrinter)

      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player B")
      aMatch.pointWonBy("Player B")
      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player B")

      aMatch.score() mustBe "0-0, Deuce"
    }
  }

  "first player scores 4 points and second player scores 3 points" should {

    "return 0-0, Advantage Player 2" in {
      val aMatch = Match("Player A", "Player B", gameScorePrinter, setScorePrinter)

      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player B")
      aMatch.pointWonBy("Player B")
      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player B")
      aMatch.pointWonBy("Player B")

      aMatch.score() mustBe "0-0, Advantage Player B"
    }
  }

  "first player has won 1 set, then " when {

    "the first player scores 1 point and the second player scores 1 point" should {

      "return 1-0, 15-15" in {
        val aMatch = Match("Player A", "Player B", gameScorePrinter, setScorePrinter)

        aMatch.pointWonBy("Player A")
        aMatch.pointWonBy("Player A")
        aMatch.pointWonBy("Player A")
        aMatch.pointWonBy("Player A")
        aMatch.pointWonBy("Player B")
        aMatch.pointWonBy("Player A")

        aMatch.score() mustBe "1-0, 15-15"
      }
    }
  }
}

