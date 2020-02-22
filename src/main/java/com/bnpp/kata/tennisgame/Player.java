package com.bnpp.kata.tennisgame;

public class Player {

	private String name;
	private int points;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void scores(int points) {
		setPoints(points);
	}

	public int getPoints() {
		return points;
	}

	private void setPoints(int points) {
		this.points = points;
	}

}