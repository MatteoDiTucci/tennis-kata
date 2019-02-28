import domain.{Match, Printer}
import org.scalatest.{MustMatchers, WordSpec}

class MatchSpec extends WordSpec with MustMatchers {

  private val printer = Printer()
  private val player1 = "Player A"
  private val player2 = "Player B"

  "Match" when {

    "a new match is started" should {

      "return 0-0" in {
        val aMatch = Match(player1, player2, printer)

        aMatch.score() mustBe "0-0"
      }
    }

    "Player1 scores 2 points and Player2 scores 1 point" should {

      "return 0-0, 30-15" in {
        val aMatch = Match(player1, player2, printer)

        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player2)

        aMatch.score() mustBe "0-0, 30-15"
      }
    }

    "Player1 scores 2 points and Player2 scores 3 point" should {

      "return 0-0, 30-40" in {
        val aMatch = Match(player1, player2, printer)

        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player2)
        aMatch.pointWonBy(player2)
        aMatch.pointWonBy(player2)

        aMatch.score() mustBe "0-0, 30-40"
      }
    }

    "Player1 scores 4 points and Player2 scores 0 point" should {

      "return 1-0" in {
        val aMatch = Match(player1, player2, printer)

        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player1)

        aMatch.score() mustBe "1-0"
      }
    }

    "Player1 scores 3 points and Player2 scores 3 points" should {

      "return 0-0, Deuce" in {
        val aMatch = Match(player1, player2, printer)

        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player2)
        aMatch.pointWonBy(player2)
        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player2)

        aMatch.score() mustBe "0-0, Deuce"
      }
    }

    "Player1 scores 4 points and Player2 scores 3 points" should {

      "return 0-0, Advantage Player 2" in {
        val aMatch = Match(player1, player2, printer)

        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player2)
        aMatch.pointWonBy(player2)
        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player2)
        aMatch.pointWonBy(player2)

        aMatch.score() mustBe "0-0, Advantage " + player2
      }
    }

    "Player1 has won 6 games and Player2 has won 6 games" when {
      val aMatch = Match(player1, player2, printer)
      playerWinsNGames(aMatch, player1, 6)
      playerWinsNGames(aMatch, player2, 6)

      "Player1 scores 1 point and Player2 scores 2 points" should {
        aMatch.pointWonBy(player1)
        aMatch.pointWonBy(player2)
        aMatch.pointWonBy(player2)

        "return 6-6, 1-2" in {
          aMatch.score() mustBe "6-6, 1-2"
        }
      }
    }

    "Player1 has won 1 set" when {

      "Player1 scores 1 point and the Player2 scores 1 point" should {

        "return 1-0, 15-15" in {
          val aMatch = Match(player1, player2, printer)

          aMatch.pointWonBy(player1)
          aMatch.pointWonBy(player1)
          aMatch.pointWonBy(player1)
          aMatch.pointWonBy(player1)
          aMatch.pointWonBy(player2)
          aMatch.pointWonBy(player1)

          aMatch.score() mustBe "1-0, 15-15"
        }
      }
    }
  }

  private def playerWinsNGames(aMatch: Match, player: String, n: Int): Unit = {
    1 to n foreach { _ =>
      aMatch.pointWonBy(player)
      aMatch.pointWonBy(player)
      aMatch.pointWonBy(player)
      aMatch.pointWonBy(player)
    }
  }
}

