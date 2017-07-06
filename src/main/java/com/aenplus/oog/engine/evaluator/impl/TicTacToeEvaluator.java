package com.aenplus.oog.engine.evaluator.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aenplus.oog.engine.evaluator.GameEvaluator;
import com.aenplus.oog.entity.Player;
import com.aenplus.oog.game.Game;

public class TicTacToeEvaluator implements GameEvaluator {

	public int evaluate(Game game, Player player, int profondeur) {
		if (game.isFinished() && game.getWinner() == player) {
			return 1000 - profondeur;
		} else if (game.isFinished() && game.getWinner() != null) {
			return -1000 ;
		} else if (game.isFinished()) {
			return 0;
		} else {
			List<Integer> values = new ArrayList<Integer>();
			int bonus = 0;
			for(Game nextGame : game.possibleMoves()){
				if(nextGame.getTable().getCells().get(4).getPlayer() == player)
					bonus += 100;
				values.add(evaluate(nextGame, player,profondeur+1) + bonus);
			}
			return Collections.max(values);
		}
	}
	
	public int evaluate(Game game, Player player){
		return evaluate(game,player,0);
	}
}
