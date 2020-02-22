package com.bnpp.kata.tennisgame;

import java.util.logging.Logger;

public class TennisGameRunner {

	private static final String INVALID_ARGUMENTS_ERROR = "Please enter atleast 4 command line arguments in the format given below: \n FirstPlayerName FirstPlayerScore SecondPlayerName SecondPlayerScore";
	private final static Logger logger = Logger
			.getLogger(TennisGameRunner.class.getName());

	public static void main(String args[]) {

		if (args.length != 4) {
			logger.info(INVALID_ARGUMENTS_ERROR);
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