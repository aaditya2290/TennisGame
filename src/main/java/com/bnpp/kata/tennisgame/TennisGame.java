package com.bnpp.kata.tennisgame;

public class TennisGame {

	public static final String ALL = " All";
	public static final String DEUCE = "Deuce";
	public static final String ADVANTAGE = "Advantage ";
	public static final String WINS = " wins";
	public static final String PLAYER_POINTS_ARE_INVALID = "Player points are invalid.";

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
			tennisGameScore = (isDeuce()) ? DEUCE : PointsToScoreMapper
					.getScoreFor(firstPlayer.getPoints()) + ALL;
		} else {
			tennisGameScore = PointsToScoreMapper.getScoreFor(firstPlayer
					.getPoints())
					+ " "
					+ PointsToScoreMapper.getScoreFor(secondPlayer.getPoints());
		}
		return tennisGameScore;
	}

	private boolean isPlayerScoresEqual() {
		return firstPlayer.getPoints() == secondPlayer.getPoints();
	}

	private boolean isDeuce() {
		return (isFirstPlayerScoreExceedsTwoPoints());
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
