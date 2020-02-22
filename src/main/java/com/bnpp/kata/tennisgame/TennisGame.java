package com.bnpp.kata.tennisgame;

import java.util.HashMap;

public class TennisGame {

	public enum GameScore {
		LOVE, FIFTEEN, THIRTY, FORTY, DEUCE;
	}

	public static final String ALL = " ALL";
	public static final String ADVANTAGE = "ADVANTAGE ";
	public static final String WINS = " WINS";
	public static final String PLAYER_SCORES_ARE_INVALID = "PLAYER SCORES ARE INVALID";

	private Player firstPlayer;
	private Player secondPlayer;

	public TennisGame(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
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
			return firstPlayer.getName() + WINS;
		} else if (isSecondPlayerWins()) {
			return secondPlayer.getName() + WINS;
		} else if (isAdvantageFirstPlayer()) {
			return ADVANTAGE + firstPlayer.getName();
		} else if (isAdvantageSecondPlayer()) {
			return ADVANTAGE + secondPlayer.getName();
		} else if (isDeuce()) {
			return GameScore.DEUCE.toString();
		} else if (firstPlayer.getPoints() != secondPlayer.getPoints()) {
			return scoreLookUp.get(firstPlayer.getPoints()) + " "
					+ scoreLookUp.get(secondPlayer.getPoints());
		} else {
			return scoreLookUp.get(firstPlayer.getPoints()) + ALL;
		}
	}

	private boolean isDeuce() {
		return (isPlayerScoresEqual() && isFirstPlayerScoreExceedsTwoPoints());
	}

	private boolean isPlayerScoresEqual() {
		return firstPlayer.getPoints() == secondPlayer.getPoints();
	}

	private boolean isFirstPlayerScoreExceedsTwoPoints() {
		return firstPlayer.getPoints() > 2;
	}

	private boolean isAdvantageFirstPlayer() {
		return isFirstPlayerLeadsByOnePoint()
				&& isSecondPlayerScoreExceedsTwoPoints();
	}

	private boolean isFirstPlayerLeadsByOnePoint() {
		return firstPlayer.getPoints() - secondPlayer.getPoints() == 1;
	}

	private boolean isSecondPlayerScoreExceedsTwoPoints() {
		return secondPlayer.getPoints() > 2;
	}

	private boolean isAdvantageSecondPlayer() {
		return isSecondPlayerLeadsByOnePoint()
				&& isFirstPlayerScoreExceedsTwoPoints();
	}

	private boolean isSecondPlayerLeadsByOnePoint() {
		return secondPlayer.getPoints() - firstPlayer.getPoints() == 1;
	}

	private boolean isFirstPlayerWins() {
		return isFirstPlayerLeadsByTwoOrMorePoints()
				&& isFirstPlayerScoreExceedsThreePoints();
	}

	private boolean isFirstPlayerLeadsByTwoOrMorePoints() {
		return firstPlayer.getPoints() - secondPlayer.getPoints() >= 2;
	}

	private boolean isFirstPlayerScoreExceedsThreePoints() {
		return firstPlayer.getPoints() > 3;
	}

	private boolean isSecondPlayerWins() {
		return isSecondPlayerLeadsByTwoOrMorePoints()
				&& isSecondPlayerScoreExceedsThreePoints();
	}

	private boolean isSecondPlayerScoreExceedsThreePoints() {
		return secondPlayer.getPoints() > 3;
	}

	private boolean isSecondPlayerLeadsByTwoOrMorePoints() {
		return secondPlayer.getPoints() - firstPlayer.getPoints() >= 2;
	}

	private boolean isInvalidScores() {
		return (isFirstPlayerLeadsByMoreThanTwoPoints() && isFirstPlayerScoreExceedsFivePoints())
				|| (isSecondPlayerLeadsByMoreThanTwoPoints() && isSecondPlayerScoreExceedsFivePoints());
	}

	private boolean isFirstPlayerLeadsByMoreThanTwoPoints() {
		return firstPlayer.getPoints() - secondPlayer.getPoints() > 2;
	}

	private boolean isFirstPlayerScoreExceedsFivePoints() {
		return firstPlayer.getPoints() > 5;
	}

	private boolean isSecondPlayerLeadsByMoreThanTwoPoints() {
		return secondPlayer.getPoints() - firstPlayer.getPoints() > 2;
	}

	private boolean isSecondPlayerScoreExceedsFivePoints() {
		return secondPlayer.getPoints() > 5;
	}

}
