package com.bnpp.kata.tennisgame;

public class TennisGame {

	private static final String LOVE_ALL = "Love All";
	private int firstPlayerScore=0;

	public String getScore() {
		if (firstPlayerScore==1){
			return "Fifteen Love";
		}
		return LOVE_ALL;
	}

	public void firstPlayerScores() {
		firstPlayerScore++;
	}
}
