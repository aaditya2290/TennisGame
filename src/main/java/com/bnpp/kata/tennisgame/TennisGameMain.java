package com.bnpp.kata.tennisgame;

import java.util.logging.Logger;

public class TennisGameMain {

	private final static Logger logger = Logger.getLogger(TennisGame.class
			.getName());

	public static void main(String args[]) {

		String invalidErrorMessage = "Please enter atleast 4 arguments in the below format \n Player1_Name Player1_Score Player2_Name Player2_Score";
		if (args.length != 4) {
			logger.info(invalidErrorMessage);
		} else {
			TennisGame game = new TennisGame(args[0], args[2]);

			int firstPlayerScore = Integer.parseInt(args[1]);
			int secondPlayerScore = Integer.parseInt(args[3]);

			game.setFirstPlayerScore(firstPlayerScore);
			game.setSecondPlayerScore(secondPlayerScore);

			logger.info(game.getScore());
		}

	}
}