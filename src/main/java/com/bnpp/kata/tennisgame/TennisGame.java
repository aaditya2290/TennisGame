package com.bnpp.kata.tennisgame;

public class TennisGame {

	private static final String LOVE_ALL = "Love All";
	private static final String FIFTEEN_LOVE = "Fifteen Love";
	private int firstPlayerScore=0;

	public String getScore() {
		if (firstPlayerScore==1){
			return FIFTEEN_LOVE;
		}
		return LOVE_ALL;
	}

	public void firstPlayerScores() {
		firstPlayerScore++;
	}
}
