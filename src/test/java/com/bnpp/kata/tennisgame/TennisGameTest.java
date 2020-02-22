package com.bnpp.kata.tennisgame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {

	private static final String ALL = " All";
	private static final String DEUCE = "Deuce";
	private static final String ADVANTAGE = "Advantage ";
	private static final String WINS = " wins";
	private static final String PLAYER_POINTS_ARE_INVALID = "Player points are invalid.";
	private static final String LOVE = "Love";
	private static final String FIFTEEN = "Fifteen";
	private static final String THIRTY = "Thirty";
	private static final String FORTY = "Forty";

	private TennisGame tennisGame;
	private Player firstPlayer;
	private Player secondPlayer;

	@Before
	public void init() {
		firstPlayer = new Player("First Player");
		secondPlayer = new Player("Second Player");
		tennisGame = new TennisGame(firstPlayer, secondPlayer);
	}

	@Test
	public void scoreShouldBeLoveAllBeforeGameStarts() {
		assertEquals(LOVE + ALL, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFifteenLoveIfFirstPlayerWinsOnePoint() {
		firstPlayer.scores(1);
		assertEquals(FIFTEEN + " " + LOVE, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeThirtyLoveIfFirstPlayerWinsTwoPoints() {
		firstPlayer.scores(2);
		assertEquals(THIRTY + " " + LOVE, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFortyLoveIfFirstPlayerWinsThreePoints() {
		firstPlayer.scores(3);
		assertEquals(FORTY + " " + LOVE, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveFifteenIfSecondPlayerWinsOnePoint() {
		secondPlayer.scores(1);
		assertEquals(LOVE + " " + FIFTEEN, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveThirtyIfSecondPlayerWinsTwoPoints() {
		secondPlayer.scores(2);
		assertEquals(LOVE + " " + THIRTY, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveFortyIfSecondPlayerWinsThreePoints() {
		secondPlayer.scores(3);
		assertEquals(LOVE + " " + FORTY, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFiftenAllIfBothPlayerWinOnePoint() {
		firstPlayer.scores(1);
		secondPlayer.scores(1);
		assertEquals(FIFTEEN + ALL, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeDeuceIfBothPlayerWinThreePoints() {
		firstPlayer.scores(3);
		secondPlayer.scores(3);
		assertEquals(DEUCE, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeAdvantageFirstPlayerIfFirstPlayerWins4PointsAndSecondPlayerWins3Points() {
		firstPlayer.scores(4);
		secondPlayer.scores(3);
		assertEquals(ADVANTAGE + firstPlayer.getName(), tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeAdvantageSecondPlayerIfSecondPlayerWins9PointsAndFirstPlayerWins8Points() {
		firstPlayer.scores(8);
		secondPlayer.scores(9);
		assertEquals(ADVANTAGE + secondPlayer.getName(), tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFirstPlayerWinsIfFirstPlayerWins5PointsAndSecondPlayerWins3Points() {
		firstPlayer.scores(5);
		secondPlayer.scores(3);
		assertEquals(firstPlayer.getName() + WINS, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeSecondPlayerWinsIfFirstPlayerWins5PointsAndSecondPlayerWins7Points() {
		firstPlayer.scores(5);
		secondPlayer.scores(7);
		assertEquals(secondPlayer.getName() + WINS, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBePlayerScoresAreInvalidIfFirstPlayerWins10PointsAndSecondPlayerWins2Points() {
		firstPlayer.scores(10);
		secondPlayer.scores(2);
		assertEquals(PLAYER_POINTS_ARE_INVALID, tennisGame.getScore());
	}

}
