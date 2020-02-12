package com.bnpp.kata.tennisgame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {

	private static final String LOVE_ALL = "Love All";
	private static final String FIFTEEN_LOVE = "Fifteen Love";

	private TennisGame tennisGame;

	@Before
	public void init() {
		tennisGame = new TennisGame();
	}

	@Test
	public void scoreShouldBeLoveAllBeforeGameStarts() {
		assertEquals(LOVE_ALL, tennisGame.getScore());
	}

	@Test
	public void scoreShouldBeFifteenLoveIfFirstPlayerWinsOnePoint(){
		tennisGame.firstPlayerScores();
		assertEquals(FIFTEEN_LOVE,tennisGame.getScore());
	}
}
