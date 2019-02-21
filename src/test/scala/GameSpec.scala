import org.scalatest.{MustMatchers, WordSpec}

class GameSpec extends WordSpec with MustMatchers {

  val playerA = "Player A"
  val playerB = "Player B"

  "Game" when {

    "is started" should {

      "return 0-0 score" in {
        val game = Game(playerA, playerB)

        game.score() mustBe Score(playerA, 0, playerB, 0)
      }
    }
  }


  "first player scores 2 points and second player scores 1 point" should {

    "return 2-1 score" in {
      val game = Game(playerA, playerB)

      game.scoresPoint(playerA)
      game.scoresPoint(playerA)
      game.scoresPoint(playerB)

      game.score() mustBe Score(playerA, 2, playerB, 1)
    }
  }
}
