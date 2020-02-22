package com.bnpp.kata.tennisgame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bnpp.kata.tennisgame.TennisGame.GameScore;

public class TennisGameTest {

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
		assertEquals(GameScore.LOVE + TennisGame.ALL, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFifteenLoveIfFirstPlayerWinsOnePoint() {
		firstPlayer.scores(1);
		assertEquals(GameScore.FIFTEEN + " " + GameScore.LOVE,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeThirtyLoveIfFirstPlayerWinsTwoPoints() {
		firstPlayer.scores(2);
		assertEquals(GameScore.THIRTY + " " + GameScore.LOVE,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFortyLoveIfFirstPlayerWinsThreePoints() {
		firstPlayer.scores(3);
		assertEquals(GameScore.FORTY + " " + GameScore.LOVE,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveFifteenIfSecondPlayerWinsOnePoint() {
		secondPlayer.scores(1);
		assertEquals(GameScore.LOVE + " " + GameScore.FIFTEEN,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveThirtyIfSecondPlayerWinsTwoPoints() {
		secondPlayer.scores(2);
		assertEquals(GameScore.LOVE + " " + GameScore.THIRTY,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeLoveFortyIfSecondPlayerWinsThreePoints() {
		secondPlayer.scores(3);
		assertEquals(GameScore.LOVE + " " + GameScore.FORTY,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFiftenAllIfBothPlayerWinOnePoint() {
		firstPlayer.scores(1);
		secondPlayer.scores(1);
		assertEquals(GameScore.FIFTEEN + TennisGame.ALL, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeAdvantageFirstPlayerIfFirstPlayerWins4PointsAndSecondPlayerWins3Points() {
		firstPlayer.scores(4);
		secondPlayer.scores(3);
		assertEquals(TennisGame.ADVANTAGE + firstPlayer.getName(),
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeAdvantageSecondPlayerIfSecondPlayerWins9PointsAndFirstPlayerWins8Points() {
		firstPlayer.scores(8);
		secondPlayer.scores(9);
		assertEquals(TennisGame.ADVANTAGE + secondPlayer.getName(),
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFirstPlayerWinsIfFirstPlayerWins5PointsAndSecondPlayerWins3Points() {
		firstPlayer.scores(5);
		secondPlayer.scores(3);
		assertEquals(firstPlayer.getName() + TennisGame.WINS,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeSecondPlayerWinsIfFirstPlayerWins5PointsAndSecondPlayerWins7Points() {
		firstPlayer.scores(5);
		secondPlayer.scores(7);
		assertEquals(secondPlayer.getName() + TennisGame.WINS,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBePlayerScoresAreInvalidIfFirstPlayerWins10PointsAndSecondPlayerWins2Points() {
		firstPlayer.scores(10);
		secondPlayer.scores(2);
		assertEquals(TennisGame.PLAYER_SCORES_ARE_INVALID,
				tennisGame.getScore());
	}

	@Test
	public void scoreShouldBePlayerScoresAreInvalidIfFirstPlayerWins2PointsAndSecondPlayerWins12Points() {
		firstPlayer.scores(2);
		secondPlayer.scores(12);
		assertEquals(TennisGame.PLAYER_SCORES_ARE_INVALID,
				tennisGame.getScore());
	}

}
