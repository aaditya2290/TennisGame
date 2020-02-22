package com.bnpp.kata.tennisgame;

import java.util.HashMap;

public class PointsToScoreMapper {

	private static HashMap<Integer, String> pointToScoreMap;

	private PointsToScoreMapper() {
		pointToScoreMap = new HashMap<Integer, String>();
		pointToScoreMap.put(0, GameScore.LOVE.toString());
		pointToScoreMap.put(1, GameScore.FIFTEEN.toString());
		pointToScoreMap.put(2, GameScore.THIRTY.toString());
		pointToScoreMap.put(3, GameScore.FORTY.toString());
	}

	public static String getScoreFor(int points) {
		if (pointToScoreMap == null) {
			new PointsToScoreMapper();
		}
		return pointToScoreMap.get(points);
	}
}
