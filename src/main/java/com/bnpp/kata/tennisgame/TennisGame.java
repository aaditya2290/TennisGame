package com.bnpp.kata.tennisgame;

public class TennisGame {

	private static final String ALL = " All";
	private static final String DEUCE = "Deuce";
	private static final String ADVANTAGE = "Advantage ";
	private static final String WINS = " wins";
	private static final String PLAYER_POINTS_ARE_INVALID = "Player points are invalid.";

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
		} else if (isWin()) {
			String winningPlayerName = firstPlayer.isWinner() ? firstPlayer
					.getName() : secondPlayer.getName();
			tennisGameScore = winningPlayerName + WINS;
		} else if (isAdvantage()) {
			String advantagePlayerName = firstPlayer.isHasAdvantage() ? firstPlayer
					.getName() : secondPlayer.getName();
			tennisGameScore = ADVANTAGE + advantagePlayerName;
		} else if (isPlayerScoresEqual()) {
			tennisGameScore = (isFirstPlayersPointsGreaterThanOrEqualToMinimumPointsForDeuce()) ? DEUCE
					: firstPlayer.getScore() + ALL;
		} else {
			tennisGameScore = firstPlayer.getScore() + " "
					+ secondPlayer.getScore();
		}
		return tennisGameScore;
	}

	public boolean isWin() {
		return isFirstPlayerWins() || isSecondPlayerWins();
	}

	public boolean isAdvantage() {
		return isAdvantageFirstPlayer() || isAdvantageSecondPlayer();
	}

	private boolean isPlayerScoresEqual() {
		return firstPlayer.getPoints() == secondPlayer.getPoints();
	}

	private boolean isFirstPlayersPointsGreaterThanOrEqualToMinimumPointsForDeuce() {
		return firstPlayer.getPoints() >= MINIMUM_POINTS_FOR_DEUCE;
	}

	private boolean isAdvantageFirstPlayer() {
		boolean isAdvantage = isFirstPlayersLeadEqualToPointsDifferenceForDeuce()
				&& isSecondPlayersPointsGreaterThanOrEqualToMinimumPointsForDeuce();
		firstPlayer.setHasAdvantage(isAdvantage);
		return isAdvantage;
	}

	private boolean isFirstPlayersLeadEqualToPointsDifferenceForDeuce() {
		return firstPlayer.getPoints() - secondPlayer.getPoints() == POINTS_DIFFERENCE_FOR_ADVANTAGE;
	}

	private boolean isSecondPlayersPointsGreaterThanOrEqualToMinimumPointsForDeuce() {
		return secondPlayer.getPoints() >= MINIMUM_POINTS_FOR_DEUCE;
	}

	private boolean isAdvantageSecondPlayer() {
		boolean isAdvantage = isSecondPlayersLeadEqualToPointsDifferenceForAdvantage()
				&& isFirstPlayersPointsGreaterThanOrEqualToMinimumPointsForDeuce();
		secondPlayer.setHasAdvantage(isAdvantage);
		return isAdvantage;
	}

	private boolean isSecondPlayersLeadEqualToPointsDifferenceForAdvantage() {
		return secondPlayer.getPoints() - firstPlayer.getPoints() == POINTS_DIFFERENCE_FOR_ADVANTAGE;
	}

	private boolean isFirstPlayerWins() {
		boolean isWin = isFirstPlayersLeadGreaterThanOrEqualToPointsDifferenceForWin()
				&& isFirstPlayersPointsGreaterThanOrEqualToMinimumPointsForWin();
		firstPlayer.setWinner(isWin);
		return isWin;
	}

	private boolean isFirstPlayersLeadGreaterThanOrEqualToPointsDifferenceForWin() {
		return firstPlayer.getPoints() - secondPlayer.getPoints() >= POINTS_DIFFERENCE_FOR_WIN;
	}

	private boolean isFirstPlayersPointsGreaterThanOrEqualToMinimumPointsForWin() {
		return firstPlayer.getPoints() >= MINIMUM_POINTS_FOR_WIN;
	}

	private boolean isSecondPlayerWins() {
		boolean isWin = isSecondPlayersLeadGreaterThanOrEqualToPointsDifferenceForWin()
				&& isSecondPlayersPointsGreaterThanOrEqualToMinimumPointsForWin();
		secondPlayer.setWinner(isWin);
		return isWin;
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
