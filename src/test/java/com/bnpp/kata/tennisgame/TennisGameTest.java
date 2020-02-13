package com.bnpp.kata.tennisgame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {

	private static final String LOVE_ALL = "Love All";
	private static final String FIFTEEN_LOVE = "Fifteen Love";
	private static final String THIRTY_LOVE = "Thirty Love";
	private static final String FORTY_LOVE = "Forty Love";
	private static final String LOVE_FIFTEEN = "Love Fifteen";
	private static final String LOVE_THIRTY = "Love Thirty";
	private static final String LOVE_FORTY = "Love Forty";
	private static final String FIFTEEN_ALL = "Fifteen All";
	private static final String THIRTY_ALL = "Thirty All";
	private static final String DEUCE = "Deuce";
	private static final String ADVANTAGE = "Advantage ";
	private TennisGame tennisGame;

	@Before
	public void init() {
		tennisGame = new TennisGame("First Player", "Second Player");
	}

	@Test
	public void scoreShouldBeLoveAllBeforeGameStarts() {
		assertEquals(LOVE_ALL, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFifteenLoveIfFirstPlayerWinsOnePoint() {
		tennisGame.firstPlayerScores();
		assertEquals(FIFTEEN_LOVE, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeThirtyLoveIfFirstPlayerWinsTwoPoints() {
		firstPlayerScoresMany(2);
		assertEquals(THIRTY_LOVE, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFortyLoveIfFirstPlayerWinsThreePoints() {
		firstPlayerScoresMany(3);
		assertEquals(FORTY_LOVE, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveFifteenIfSecondPlayerWinsOnePoint() {
		tennisGame.secondPlayerScores();
		assertEquals(LOVE_FIFTEEN, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveThirtyIfSecondPlayerWinsTwoPoints() {
		secondPlayerScoresMany(2);
		assertEquals(LOVE_THIRTY, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveFortyIfSecondPlayerWinsThreePoints() {
		secondPlayerScoresMany(3);
		assertEquals(LOVE_FORTY, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFiftenAllIfBothPlayerWinOnePoint() {
		tennisGame.firstPlayerScores();
		tennisGame.secondPlayerScores();
		assertEquals(FIFTEEN_ALL, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeThirtyAllIfBothPlayerWinTwoPoints() {
		firstPlayerScoresMany(2);
		secondPlayerScoresMany(2);
		assertEquals(THIRTY_ALL, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeDeuceIfBothPlayerWinThreePoints() {
		firstPlayerScoresMany(3);
		secondPlayerScoresMany(3);
		assertEquals(DEUCE, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeDeuceIfBothPlayerWinSixPoints() {
		firstPlayerScoresMany(6);
		secondPlayerScoresMany(6);
		assertEquals(DEUCE, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeAdvantageFirstPlayerIfFirstPlayerWins4PointsAndSecondPlayerWins3Points() {
		firstPlayerScoresMany(4);
		secondPlayerScoresMany(3);
		assertEquals(ADVANTAGE + tennisGame.getFirstPlayerName(), tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeAdvantageFirstPlayerIfFirstPlayerWins9PointsAndSecondPlayerWins8Points() {
		firstPlayerScoresMany(9);
		secondPlayerScoresMany(8);
		assertEquals(ADVANTAGE + tennisGame.getFirstPlayerName(), tennisGame.getScore());
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
