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
		tennisGame.firstPlayerScores();
		assertEquals(GameScore.FIFTEEN + " " + GameScore.LOVE,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeThirtyLoveIfFirstPlayerWinsTwoPoints() {
		firstPlayerScoresMany(2);
		assertEquals(GameScore.THIRTY + " " + GameScore.LOVE,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFortyLoveIfFirstPlayerWinsThreePoints() {
		firstPlayerScoresMany(3);
		assertEquals(GameScore.FORTY + " " + GameScore.LOVE,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveFifteenIfSecondPlayerWinsOnePoint() {
		tennisGame.secondPlayerScores();
		assertEquals(GameScore.LOVE + " " + GameScore.FIFTEEN,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveThirtyIfSecondPlayerWinsTwoPoints() {
		secondPlayerScoresMany(2);
		assertEquals(GameScore.LOVE + " " + GameScore.THIRTY,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveFortyIfSecondPlayerWinsThreePoints() {
		secondPlayerScoresMany(3);
		assertEquals(GameScore.LOVE + " " + GameScore.FORTY,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFiftenAllIfBothPlayerWinOnePoint() {
		tennisGame.firstPlayerScores();
		tennisGame.secondPlayerScores();
		assertEquals(GameScore.FIFTEEN + TennisGame.ALL, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeThirtyAllIfBothPlayerWinTwoPoints() {
		firstPlayerScoresMany(2);
		secondPlayerScoresMany(2);
		assertEquals(GameScore.THIRTY + TennisGame.ALL, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeDeuceIfBothPlayerWinThreePoints() {
		firstPlayerScoresMany(3);
		secondPlayerScoresMany(3);
		assertEquals(GameScore.DEUCE.toString(), tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeDeuceIfBothPlayerWinSixPoints() {
		firstPlayerScoresMany(6);
		secondPlayerScoresMany(6);
		assertEquals(GameScore.DEUCE.toString(), tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeAdvantageFirstPlayerIfFirstPlayerWins4PointsAndSecondPlayerWins3Points() {
		firstPlayerScoresMany(4);
		secondPlayerScoresMany(3);
		assertEquals(TennisGame.ADVANTAGE + tennisGame.getFirstPlayerName(),
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeAdvantageFirstPlayerIfFirstPlayerWins9PointsAndSecondPlayerWins8Points() {
		firstPlayerScoresMany(9);
		secondPlayerScoresMany(8);
		assertEquals(TennisGame.ADVANTAGE + tennisGame.getFirstPlayerName(),
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeAdvantageSecondPlayerIfSecondPlayerWins9PointsAndFirstPlayerWins8Points() {
		firstPlayerScoresMany(8);
		secondPlayerScoresMany(9);
		assertEquals(TennisGame.ADVANTAGE + tennisGame.getSecondPlayerName(),
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFirstPlayerWinsIfFirstPlayerWins5PointsAndSecondPlayerWins3Points() {
		firstPlayerScoresMany(5);
		secondPlayerScoresMany(3);
		assertEquals(tennisGame.getFirstPlayerName() + TennisGame.WINS,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFirstPlayerWinsIfFirstPlayerWins4PointsAndSecondPlayerWins1Point() {
		firstPlayerScoresMany(4);
		secondPlayerScoresMany(1);
		assertEquals(tennisGame.getFirstPlayerName() + TennisGame.WINS,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeSecondPlayerWinsIfFirstPlayerWins5PointsAndSecondPlayerWins7Point() {
		firstPlayerScoresMany(5);
		secondPlayerScoresMany(7);
		assertEquals(tennisGame.getSecondPlayerName() + TennisGame.WINS,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldPlayerScoresAreInvalidIfFirstPlayerWins10PointsAndSecondPlayerWins2Points() {
		firstPlayerScoresMany(10);
		secondPlayerScoresMany(2);
		assertEquals(TennisGame.PLAYER_SCORES_ARE_INVALID,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldPlayerScoresAreInvalidIfFirstPlayerWins2PointsAndSecondPlayerWins12Points() {
		firstPlayerScoresMany(2);
		secondPlayerScoresMany(12);
		assertEquals(TennisGame.PLAYER_SCORES_ARE_INVALID,
				tennisGame.getScore());
	}

	public void firstPlayerScoresMany(int pointCount) {
		for (int pointCountIndex = 0; pointCountIndex < pointCount; pointCountIndex++) {
			tennisGame.firstPlayerScores();
		}
	}

	public void secondPlayerScoresMany(int pointCount) {
		for (int pointCountIndex = 0; pointCountIndex < pointCount; pointCountIndex++) {
			tennisGame.secondPlayerScores();
		}
	}
}
