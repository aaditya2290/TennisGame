package com.bnpp.kata.tennisgame;

public enum GameScore {
	LOVE, FIFTEEN, THIRTY, FORTY;

	@Override
	public String toString() {
		String parentToString = super.toString();
		return parentToString.substring(0, 1)
				+ parentToString.substring(1).toLowerCase();
	}
}
