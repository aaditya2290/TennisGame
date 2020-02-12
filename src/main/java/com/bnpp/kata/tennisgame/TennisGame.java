package com.bnpp.kata.tennisgame;

import java.util.HashMap;

public class TennisGame {

	private static final String LOVE = "Love";
	private static final String FIFTEEN = "Fifteen";
	private static final String THIRTY = "Thirty";
	private static final String FORTY = "Forty";
	private static final String ALL = " All";
	private static final String DEUCE = "Deuce";
	private int firstPlayerScore=0;
	private int secondPlayerScore=0;

	public String getScore() {

		HashMap<Integer,String> scoreLookUp=new HashMap<Integer,String>();
		scoreLookUp.put(0,LOVE);
		scoreLookUp.put(1,FIFTEEN);
		scoreLookUp.put(2,THIRTY);
		scoreLookUp.put(3,FORTY);

		if (isDeuce())
			return DEUCE;
		else if (firstPlayerScore!=secondPlayerScore){
			return scoreLookUp.get(firstPlayerScore)+" "+scoreLookUp.get(secondPlayerScore);		
		} else {
			return scoreLookUp.get(firstPlayerScore)+ALL;	
		}
	}

	public void firstPlayerScores() {
		firstPlayerScore++;
	}

	public void secondPlayerScores() {
		secondPlayerScore++;
	}

	public boolean isDeuce(){
		return (firstPlayerScore==secondPlayerScore && firstPlayerScore>=3);
	}
}
