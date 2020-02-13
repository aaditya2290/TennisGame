package com.bnpp.kata.tennisgame;

import java.util.HashMap;

public class TennisGame {

	private static final String LOVE = "Love";
	private static final String FIFTEEN = "Fifteen";
	private static final String THIRTY = "Thirty";
	private static final String FORTY = "Forty";
	private static final String ALL = " All";
	private static final String DEUCE = "Deuce";
	private static final String ADVANTAGE = "Advantage ";
	private static final String WINS = " wins";
	private static final String PLAYER_SCORES_ARE_INVALID = "Player scores are invalid";

	private int firstPlayerScore = 0;
	private int secondPlayerScore = 0;
	String firstPlayerName;
	String secondPlayerName;

	TennisGame(String firstPlayerName, String secondPlayerName) {
		super();
		this.firstPlayerName = firstPlayerName;
		this.secondPlayerName = secondPlayerName;
	}

	String getScore() {

		HashMap<Integer, String> scoreLookUp = new HashMap<Integer, String>();
		scoreLookUp.put(0, LOVE);
		scoreLookUp.put(1, FIFTEEN);
		scoreLookUp.put(2, THIRTY);
		scoreLookUp.put(3, FORTY);

		if (isInvalidScores()) {
			return PLAYER_SCORES_ARE_INVALID;
		} else if (isFirstPlayerWins()) {
			return this.getFirstPlayerName() + WINS;
		} else if (isSecondPlayerWins()) {
			return this.getSecondPlayerName() + WINS;
		} else if (isAdvantageFirstPlayer()) {
			return ADVANTAGE + this.getFirstPlayerName();
		} else if (isAdvantageSecondPlayer()) {
			return ADVANTAGE + this.getSecondPlayerName();
		} else if (isDeuce()) {
			return DEUCE;
		} else if (firstPlayerScore != secondPlayerScore) {
			return scoreLookUp.get(firstPlayerScore) + " " + scoreLookUp.get(secondPlayerScore);
		} else {
			return scoreLookUp.get(firstPlayerScore) + ALL;
		}
	}

	void firstPlayerScores() {
		firstPlayerScore++;
	}

	void secondPlayerScores() {
		secondPlayerScore++;
	}

	boolean isDeuce() {
		return (firstPlayerScore == secondPlayerScore && firstPlayerScore >= 3);
	}

	boolean isAdvantageFirstPlayer() {
		return firstPlayerScore - secondPlayerScore == 1 && secondPlayerScore >= 3;
	}

	boolean isAdvantageSecondPlayer() {
		return secondPlayerScore - firstPlayerScore == 1 && firstPlayerScore >= 3;
	}

	boolean isFirstPlayerWins() {
		return firstPlayerScore - secondPlayerScore >= 2 && firstPlayerScore > 3;
	}

	boolean isSecondPlayerWins() {
		return secondPlayerScore - firstPlayerScore >= 2 && secondPlayerScore > 3;
	}

	boolean isInvalidScores() {
		return (firstPlayerScore - secondPlayerScore > 2 && firstPlayerScore > 5)
				|| (secondPlayerScore - firstPlayerScore > 2 && secondPlayerScore > 5);
	}

	String getFirstPlayerName() {
		return firstPlayerName;
	}

	String getSecondPlayerName() {
		return secondPlayerName;
	}

}
