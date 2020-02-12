package com.bnpp.kata.tennisgame;

import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {

	@Test
	public void shouldBeAbleToInstantiateTennisGame(){
		TennisGame tennisGame = new TennisGame();
		assertNotNull(tennisGame);
	}

	@Test
	public void scoreShouldBeLoveAllBeforeGameStarts(){
		TennisGame tennisGame = new TennisGame();
		assertEquals("Love All",tennisGame.getScore());
	}

}
