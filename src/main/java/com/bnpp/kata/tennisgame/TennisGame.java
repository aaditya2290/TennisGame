package com.bnpp.kata.tennisgame;

import java.util.HashMap;

public class TennisGame {

	private static final String LOVE = "Love";
	private static final String FIFTEEN = "Fifteen";
	private static final String THIRTY = "Thirty";
	private static final String FORTY = "Forty";
	private static final String LOVE_ALL = "Love All";
	private static final String FIFTEEN_ALL = "Fifteen All";
	private int firstPlayerScore=0;
	private int secondPlayerScore=0;

	public String getScore() {

		HashMap<Integer,String> scoreLookUp=new HashMap<Integer,String>();
		scoreLookUp.put(0,LOVE);
		scoreLookUp.put(1,FIFTEEN);
		scoreLookUp.put(2,THIRTY);
		scoreLookUp.put(3,FORTY);

		if (firstPlayerScore>0 || secondPlayerScore>0){
			if (firstPlayerScore==1 && secondPlayerScore==1){
				return FIFTEEN_ALL;
			}
			return scoreLookUp.get(firstPlayerScore)+" "+scoreLookUp.get(secondPlayerScore);
		}
		return LOVE_ALL;
	}

	public void firstPlayerScores() {
		firstPlayerScore++;
	}

	public void secondPlayerScores() {
		secondPlayerScore++;
	}
}
