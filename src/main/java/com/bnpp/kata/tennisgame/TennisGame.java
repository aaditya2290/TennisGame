package com.bnpp.kata.tennisgame;

import java.util.HashMap;

public class TennisGame {

	private static final String LOVE = "Love";
	private static final String FIFTEEN = "Fifteen";
	private static final String THIRTY = "Thirty";
	private static final String FORTY = "Forty";
	private static final String LOVE_ALL = "Love All";
	private int firstPlayerScore=0;

	public String getScore() {

		HashMap<Integer,String> scoreLookUp=new HashMap<Integer,String>();
		scoreLookUp.put(0,LOVE);
		scoreLookUp.put(1,FIFTEEN);
		scoreLookUp.put(2,THIRTY);
		scoreLookUp.put(3,FORTY);

		if (firstPlayerScore>0){
			return scoreLookUp.get(firstPlayerScore)+" "+LOVE;
		}
		return LOVE_ALL;
	}

	public void firstPlayerScores() {
		firstPlayerScore++;
	}
}
