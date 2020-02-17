package com.bnpp.kata.tennisgame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bnpp.kata.tennisgame.TennisGame.GameScore;

public class TennisGameTest {

	private TennisGame tennisGame;

	@Before
	public void init() {
		tennisGame = new TennisGame("First Player", "Second Player");
	}

	@Test
	public void scoreShouldBeLoveAllBeforeGameStarts() {
		assertEquals(GameScore.LOVE + TennisGame.ALL, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFifteenLoveIfFirstPlayerWinsOnePoint() {
		tennisGame.setFirstPlayerScore(1);
		assertEquals(GameScore.FIFTEEN + " " + GameScore.LOVE,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeThirtyLoveIfFirstPlayerWinsTwoPoints() {
		tennisGame.setFirstPlayerScore(2);
		assertEquals(GameScore.THIRTY + " " + GameScore.LOVE,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFortyLoveIfFirstPlayerWinsThreePoints() {
		tennisGame.setFirstPlayerScore(3);
		assertEquals(GameScore.FORTY + " " + GameScore.LOVE,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveFifteenIfSecondPlayerWinsOnePoint() {
		tennisGame.setSecondPlayerScore(1);
		assertEquals(GameScore.LOVE + " " + GameScore.FIFTEEN,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveThirtyIfSecondPlayerWinsTwoPoints() {
		tennisGame.setSecondPlayerScore(2);
		assertEquals(GameScore.LOVE + " " + GameScore.THIRTY,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveFortyIfSecondPlayerWinsThreePoints() {
		tennisGame.setSecondPlayerScore(3);
		assertEquals(GameScore.LOVE + " " + GameScore.FORTY,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFiftenAllIfBothPlayerWinOnePoint() {
		tennisGame.setFirstPlayerScore(1);
		tennisGame.setSecondPlayerScore(1);
		assertEquals(GameScore.FIFTEEN + TennisGame.ALL, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeThirtyAllIfBothPlayerWinTwoPoints() {
		tennisGame.setFirstPlayerScore(2);
		tennisGame.setSecondPlayerScore(2);
		assertEquals(GameScore.THIRTY + TennisGame.ALL, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeDeuceIfBothPlayerWinThreePoints() {
		tennisGame.setFirstPlayerScore(3);
		tennisGame.setSecondPlayerScore(3);
		assertEquals(GameScore.DEUCE.toString(), tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeDeuceIfBothPlayerWinSixPoints() {
		tennisGame.setFirstPlayerScore(6);
		tennisGame.setSecondPlayerScore(6);
		assertEquals(GameScore.DEUCE.toString(), tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeAdvantageFirstPlayerIfFirstPlayerWins4PointsAndSecondPlayerWins3Points() {
		tennisGame.setFirstPlayerScore(4);
		tennisGame.setSecondPlayerScore(3);
		assertEquals(TennisGame.ADVANTAGE + tennisGame.getFirstPlayerName(),
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeAdvantageFirstPlayerIfFirstPlayerWins9PointsAndSecondPlayerWins8Points() {
		tennisGame.setFirstPlayerScore(9);
		tennisGame.setSecondPlayerScore(8);
		assertEquals(TennisGame.ADVANTAGE + tennisGame.getFirstPlayerName(),
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeAdvantageSecondPlayerIfSecondPlayerWins9PointsAndFirstPlayerWins8Points() {
		tennisGame.setFirstPlayerScore(8);
		tennisGame.setSecondPlayerScore(9);
		assertEquals(TennisGame.ADVANTAGE + tennisGame.getSecondPlayerName(),
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFirstPlayerWinsIfFirstPlayerWins5PointsAndSecondPlayerWins3Points() {
		tennisGame.setFirstPlayerScore(5);
		tennisGame.setSecondPlayerScore(3);
		assertEquals(tennisGame.getFirstPlayerName() + TennisGame.WINS,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFirstPlayerWinsIfFirstPlayerWins4PointsAndSecondPlayerWins1Point() {
		tennisGame.setFirstPlayerScore(4);
		tennisGame.setSecondPlayerScore(1);
		assertEquals(tennisGame.getFirstPlayerName() + TennisGame.WINS,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeSecondPlayerWinsIfFirstPlayerWins5PointsAndSecondPlayerWins7Point() {
		tennisGame.setFirstPlayerScore(5);
		tennisGame.setSecondPlayerScore(7);
		assertEquals(tennisGame.getSecondPlayerName() + TennisGame.WINS,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldPlayerScoresAreInvalidIfFirstPlayerWins10PointsAndSecondPlayerWins2Points() {
		tennisGame.setFirstPlayerScore(10);
		tennisGame.setSecondPlayerScore(2);
		assertEquals(TennisGame.PLAYER_SCORES_ARE_INVALID,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldPlayerScoresAreInvalidIfFirstPlayerWins2PointsAndSecondPlayerWins12Points() {
		tennisGame.setFirstPlayerScore(2);
		tennisGame.setSecondPlayerScore(12);
		assertEquals(TennisGame.PLAYER_SCORES_ARE_INVALID,
				tennisGame.getScore());
	}

}
