package com.bnpp.kata.tennisgame;

public class TennisGame {

	public static final String ALL = " All";
	public static final String DEUCE = "Deuce";
	public static final String ADVANTAGE = "Advantage ";
	public static final String WINS = " wins";
	public static final String PLAYER_POINTS_ARE_INVALID = "Player points are invalid.";

	private static final int POINTS_DIFFERENCE_FOR_ADVANTAGE = 1;
	private static final int POINTS_DIFFERENCE_FOR_WIN = 2;
	private static final int MINIMUM_POINTS_FOR_DEUCE = 3;
	private static final int MINIMUM_POINTS_FOR_WIN = 4;

	private Player firstPlayer;
	private Player secondPlayer;

	public TennisGame(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}

	public String getScore() {

		String tennisGameScore;

		if (isInvalidScores()) {
			tennisGameScore = PLAYER_POINTS_ARE_INVALID;
		} else if (isFirstPlayerWins()) {
			tennisGameScore = firstPlayer.getName() + WINS;
		} else if (isSecondPlayerWins()) {
			tennisGameScore = secondPlayer.getName() + WINS;
		} else if (isAdvantageFirstPlayer()) {
			tennisGameScore = ADVANTAGE + firstPlayer.getName();
		} else if (isAdvantageSecondPlayer()) {
			tennisGameScore = ADVANTAGE + secondPlayer.getName();
		} else if (isPlayerScoresEqual()) {
			tennisGameScore = (isFirstPlayersPointsGreaterThanOrEqualToMinimumPointsForDeuce()) ? DEUCE
					: firstPlayer.getScore() + ALL;
		} else {
			tennisGameScore = firstPlayer.getScore() + " "
					+ secondPlayer.getScore();
		}
		return tennisGameScore;
	}

	private boolean isPlayerScoresEqual() {
		return firstPlayer.getPoints() == secondPlayer.getPoints();
	}

	private boolean isFirstPlayersPointsGreaterThanOrEqualToMinimumPointsForDeuce() {
		return firstPlayer.getPoints() >= MINIMUM_POINTS_FOR_DEUCE;
	}

	private boolean isAdvantageFirstPlayer() {
		return isFirstPlayersLeadEqualToPointsDifferenceForDeuce()
				&& isSecondPlayersPointsGreaterThanOrEqualToMinimumPointsForDeuce();
	}

	private boolean isFirstPlayersLeadEqualToPointsDifferenceForDeuce() {
		return firstPlayer.getPoints() - secondPlayer.getPoints() == POINTS_DIFFERENCE_FOR_ADVANTAGE;
	}

	private boolean isSecondPlayersPointsGreaterThanOrEqualToMinimumPointsForDeuce() {
		return secondPlayer.getPoints() >= MINIMUM_POINTS_FOR_DEUCE;
	}

	private boolean isAdvantageSecondPlayer() {
		return isSecondPlayersLeadEqualToPointsDifferenceForAdvantage()
				&& isFirstPlayersPointsGreaterThanOrEqualToMinimumPointsForDeuce();
	}

	private boolean isSecondPlayersLeadEqualToPointsDifferenceForAdvantage() {
		return secondPlayer.getPoints() - firstPlayer.getPoints() == POINTS_DIFFERENCE_FOR_ADVANTAGE;
	}

	private boolean isFirstPlayerWins() {
		return isFirstPlayersLeadGreaterThanOrEqualToPointsDifferenceForWin()
				&& isFirstPlayersPointsGreaterThanOrEqualToMinimumPointsForWin();
	}

	private boolean isFirstPlayersLeadGreaterThanOrEqualToPointsDifferenceForWin() {
		return firstPlayer.getPoints() - secondPlayer.getPoints() >= POINTS_DIFFERENCE_FOR_WIN;
	}

	private boolean isFirstPlayersPointsGreaterThanOrEqualToMinimumPointsForWin() {
		return firstPlayer.getPoints() >= MINIMUM_POINTS_FOR_WIN;
	}

	private boolean isSecondPlayerWins() {
		return isSecondPlayersLeadGreaterThanOrEqualToPointsDifferenceForWin()
				&& isSecondPlayersPointsGreaterThanOrEqualToMinimumPointsForWin();
	}

	private boolean isSecondPlayersPointsGreaterThanOrEqualToMinimumPointsForWin() {
		return secondPlayer.getPoints() >= MINIMUM_POINTS_FOR_WIN;
	}

	private boolean isSecondPlayersLeadGreaterThanOrEqualToPointsDifferenceForWin() {
		return secondPlayer.getPoints() - firstPlayer.getPoints() >= POINTS_DIFFERENCE_FOR_WIN;
	}

	private boolean isInvalidScores() {
		return (isFirstPlayersLeadGreaterThanPointsDifferenceForWin() && isFirstPlayersPointsGreaterThanMinimumPointsForWin())
				|| (isSecondPlayersLeadGreaterThanPointsDifferenceForWin() && isSecondPlayersPointsGreaterThanMinimumPointsForWin());
	}

	private boolean isFirstPlayersLeadGreaterThanPointsDifferenceForWin() {
		return firstPlayer.getPoints() - secondPlayer.getPoints() > POINTS_DIFFERENCE_FOR_WIN;
	}

	private boolean isFirstPlayersPointsGreaterThanMinimumPointsForWin() {
		return firstPlayer.getPoints() > MINIMUM_POINTS_FOR_WIN;
	}

	private boolean isSecondPlayersLeadGreaterThanPointsDifferenceForWin() {
		return secondPlayer.getPoints() - firstPlayer.getPoints() > 2;
	}

	private boolean isSecondPlayersPointsGreaterThanMinimumPointsForWin() {
		return secondPlayer.getPoints() > MINIMUM_POINTS_FOR_WIN;
	}

}
