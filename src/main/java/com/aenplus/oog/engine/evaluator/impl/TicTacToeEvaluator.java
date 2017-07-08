package com.aenplus.oog.engine.evaluator.impl;

import com.aenplus.oog.engine.evaluator.GameEvaluator;
import com.aenplus.oog.entity.Player;
import com.aenplus.oog.game.Game;

public class TicTacToeEvaluator implements GameEvaluator {

	public int evaluate(Game game, Player player, int depth) {
		if(game.isFinished()){
			if(game.getWinner() == player)
				return 1000;
			else if(game.getWinner() != null)
				return -1000;
			else 
				return 0;
		}else{
			return 0;
		}
	}
}
