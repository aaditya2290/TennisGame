package com.bnpp.kata.tennisgame;

import java.util.logging.Logger;

public class TennisGameMain {

	private final static Logger logger = Logger.getLogger(TennisGame.class
			.getName());

	public static void main(String args[]) {

		String invalidErrorMessage = "Please enter atleast 4 arguments in the format given below: \n FirstPlayerName FirstPlayerScore SecondPlayerName SecondPlayerScore";
		if (args.length != 4) {
			logger.info(invalidErrorMessage);
		} else {
			Player firstPlayer = new Player(args[0]);
			Player secondPlayer = new Player(args[2]);

			TennisGame game = new TennisGame(firstPlayer, secondPlayer);

			int firstPlayerPoints = Integer.parseInt(args[1]);
			int secondPlayerPoints = Integer.parseInt(args[3]);

			firstPlayer.scores(firstPlayerPoints);
			secondPlayer.scores(secondPlayerPoints);

			logger.info(game.getScore());
		}

	}
}