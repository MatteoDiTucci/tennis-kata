import org.scalatest.{MustMatchers, WordSpec}

class MatchSpec extends WordSpec with MustMatchers {

  "Match" when {

    "a new game is started" should {

      "return 0-0 score" in {
        val aMatch = Match("Player A", "Player B")

        aMatch.currentGameScore() mustBe Score("Player A", 0, "Player B", 0)
      }
    }
  }


  "first player scores 2 points and second player scores 1 point" should {

    "return 2-1 score" in {
      val aMatch = Match("Player A", "Player B")

      aMatch.scoresPoint("Player A")
      aMatch.scoresPoint("Player A")
      aMatch.scoresPoint("Player B")

      aMatch.currentGameScore() mustBe Score("Player A", 2, "Player B", 1)
    }
  }
}

