package com.bnpp.kata.tennisgame;

import java.util.HashMap;
import java.util.logging.Logger;

public class TennisGame {

	private final static Logger logger = Logger.getLogger(TennisGame.class
			.getName());

	public enum GameScore {
		LOVE, FIFTEEN, THIRTY, FORTY, DEUCE;
	}

	public static final String ALL = " ALL";
	public static final String ADVANTAGE = "ADVANTAGE ";
	public static final String WINS = " WINS";
	public static final String PLAYER_SCORES_ARE_INVALID = "PLAYER SCORES ARE INVALID";

	private int firstPlayerScore = 0;
	private int secondPlayerScore = 0;
	private String firstPlayerName;
	private String secondPlayerName;

	public TennisGame(String firstPlayerName, String secondPlayerName) {
		super();
		this.firstPlayerName = firstPlayerName;
		this.secondPlayerName = secondPlayerName;
	}

	public String getScore() {

		HashMap<Integer, GameScore> scoreLookUp = new HashMap<Integer, GameScore>();
		scoreLookUp.put(0, GameScore.LOVE);
		scoreLookUp.put(1, GameScore.FIFTEEN);
		scoreLookUp.put(2, GameScore.THIRTY);
		scoreLookUp.put(3, GameScore.FORTY);

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
			return GameScore.DEUCE.toString();
		} else if (firstPlayerScore != secondPlayerScore) {
			return scoreLookUp.get(firstPlayerScore) + " "
					+ scoreLookUp.get(secondPlayerScore);
		} else {
			return scoreLookUp.get(firstPlayerScore) + ALL;
		}
	}

	public void firstPlayerScores() {
		firstPlayerScore++;
	}

	public void secondPlayerScores() {
		secondPlayerScore++;
	}

	public String getFirstPlayerName() {
		return firstPlayerName;
	}

	public String getSecondPlayerName() {
		return secondPlayerName;
	}

	private boolean isDeuce() {
		return (isPlayerScoresEqual() && isFirstPlayerScoreExceedsTwoPoints());
	}

	private boolean isPlayerScoresEqual() {
		return firstPlayerScore == secondPlayerScore;
	}

	private boolean isFirstPlayerScoreExceedsTwoPoints() {
		return firstPlayerScore > 2;
	}

	private boolean isAdvantageFirstPlayer() {
		return isFirstPlayerLeadsByOnePoint()
				&& isSecondPlayerScoreExceedsTwoPoints();
	}

	private boolean isFirstPlayerLeadsByOnePoint() {
		return firstPlayerScore - secondPlayerScore == 1;
	}

	private boolean isSecondPlayerScoreExceedsTwoPoints() {
		return secondPlayerScore > 2;
	}

	private boolean isAdvantageSecondPlayer() {
		return isSecondPlayerLeadsByOnePoint()
				&& isFirstPlayerScoreExceedsTwoPoints();
	}

	private boolean isSecondPlayerLeadsByOnePoint() {
		return secondPlayerScore - firstPlayerScore == 1;
	}

	private boolean isFirstPlayerWins() {
		return isFirstPlayerLeadsByTwoOrMorePoints()
				&& isFirstPlayerScoreExceedsThreePoints();
	}

	private boolean isFirstPlayerLeadsByTwoOrMorePoints() {
		return firstPlayerScore - secondPlayerScore >= 2;
	}

	private boolean isFirstPlayerScoreExceedsThreePoints() {
		return firstPlayerScore > 3;
	}

	private boolean isSecondPlayerWins() {
		return isSecondPlayerLeadsByTwoOrMorePoints()
				&& isSecondPlayerScoreExceedsThreePoints();
	}

	private boolean isSecondPlayerScoreExceedsThreePoints() {
		return secondPlayerScore > 3;
	}

	private boolean isSecondPlayerLeadsByTwoOrMorePoints() {
		return secondPlayerScore - firstPlayerScore >= 2;
	}

	private boolean isInvalidScores() {
		return (isFirstPlayerLeadsByMoreThanTwoPoints() && isFirstPlayerScoreExceedsFivePoints())
				|| (isSecondPlayerLeadsByMoreThanTwoPoints() && isSecondPlayerScoreExceedsFivePoints());
	}

	private boolean isFirstPlayerLeadsByMoreThanTwoPoints() {
		return firstPlayerScore - secondPlayerScore > 2;
	}

	private boolean isFirstPlayerScoreExceedsFivePoints() {
		return firstPlayerScore > 5;
	}

	private boolean isSecondPlayerLeadsByMoreThanTwoPoints() {
		return secondPlayerScore - firstPlayerScore > 2;
	}

	private boolean isSecondPlayerScoreExceedsFivePoints() {
		return secondPlayerScore > 5;
	}

	public static void main(String args[]) {

		String invalidErrorMessage = "Please enter atleast 4 arguments in the below format \n Player1_Name Player1_Score Player2_Name Player2_Score";
		if (args.length != 4) {
			logger.info(invalidErrorMessage);
		} else {

			TennisGame game = new TennisGame(args[0], args[2]);
			int firstPlayerScore = Integer.parseInt(args[1]);
			int secondPlayerScore = Integer.parseInt(args[3]);

			for (int firstPlayerScoreIndex = 0; firstPlayerScoreIndex < firstPlayerScore; firstPlayerScoreIndex++) {
				game.firstPlayerScores();
			}

			for (int secondPlayerScoreIndex = 0; secondPlayerScoreIndex < secondPlayerScore; secondPlayerScoreIndex++) {
				game.secondPlayerScores();
			}

			logger.info(game.getScore());
		}

	}

}
