package com.bnpp.kata.tennisgame;

public class Player {

	private String name;
	private int points;
	private boolean isWinner;
	private boolean hasAdvantage;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void scores(int points) {
		setPoints(points);
	}

	public String getScore() {
		return PointsToScoreMapper.getScoreFor(points);
	}

	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	public boolean isHasAdvantage() {
		return hasAdvantage;
	}

	public void setHasAdvantage(boolean hasAdvantage) {
		this.hasAdvantage = hasAdvantage;
	}

	public int getPoints() {
		return points;
	}

	private void setPoints(int points) {
		this.points = points;
	}

}