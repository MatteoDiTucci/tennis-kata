import org.scalatest.{MustMatchers, WordSpec}

class MatchSpec extends WordSpec with MustMatchers {

  "Match" when {

    "a new game is started" should {

      "returns 0-0 score" in {
        val aMatch = Match("Player A", "Player B")

        aMatch.score() mustBe "0-0"
      }
    }
  }


  "first player scores 2 points and second player scores 1 point" should {

    "returns 30-15 score" in {
      val aMatch = Match("Player A", "Player B")

      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player B")

      aMatch.score() mustBe "30-15"
    }
  }

  "first player scores 2 points and second player scores 3 point" should {

    "returns 30-40 score" in {
      val aMatch = Match("Player A", "Player B")

      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player A")
      aMatch.pointWonBy("Player B")
      aMatch.pointWonBy("Player B")
      aMatch.pointWonBy("Player B")

      aMatch.score() mustBe "30-40"
    }
  }
}

