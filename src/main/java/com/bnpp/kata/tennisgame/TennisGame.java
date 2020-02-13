package com.bnpp.kata.tennisgame;

import java.util.HashMap;
import java.util.logging.Logger;

public class TennisGame {

	private final static Logger logger = Logger.getLogger(TennisGame.class.getName());

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

	public static void main(String args[]) {

		String invalidErrorMessage = "Please enter atleast 4 arguments in the below format \n Player1_Name Player1_Score Player2_Name Player2_Score";
		if (args.length != 4) {
			logger.info(invalidErrorMessage);
		} else {

			TennisGame game = new TennisGame(args[0], args[2]);
			int firstPlayerScore = Integer.parseInt(args[1]);
			int secondPlayerScore = Integer.parseInt(args[3]);

			for (int firstPlayerScoreIndex = 0; firstPlayerScoreIndex < firstPlayerScore; firstPlayerScoreIndex++)
				game.firstPlayerScores();

			for (int secondPlayerScoreIndex = 0; secondPlayerScoreIndex < secondPlayerScore; secondPlayerScoreIndex++)
				game.secondPlayerScores();

			logger.info(game.getScore());
		}

	}

}
