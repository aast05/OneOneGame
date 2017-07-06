package com.aenplus.oog.engine.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.aenplus.oog.engine.ResponseEngine;
import com.aenplus.oog.engine.evaluator.GameEvaluator;
import com.aenplus.oog.engine.evaluator.impl.TicTacToeEvaluator;
import com.aenplus.oog.entity.Player;
import com.aenplus.oog.game.Game;

public class MinMaxEngine implements ResponseEngine {
	private Player player;
	private GameEvaluator gameEvaluator = new TicTacToeEvaluator();

	public MinMaxEngine(Player player) {
		this.player = player;
	}

	public Game getResponse(Game currentGame) {
		int resultEval = 0;
		List<Game> results = new ArrayList<Game>();
		for (Game nextGame : currentGame.possibleMoves()) {
			int newEval = gameEvaluator.evaluate(nextGame, player);
			if (resultEval < newEval) {
				results.clear();
				results.add(nextGame);
				resultEval = newEval;
			} else if (resultEval == newEval) {
				results.add(nextGame);
			}
		}
		return results.get(new Random().nextInt(results.size()));
	}

}
