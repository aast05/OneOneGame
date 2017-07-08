package com.aenplus.oog.engine.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import com.aenplus.oog.engine.ResponseEngine;
import com.aenplus.oog.engine.evaluator.GameEvaluator;
import com.aenplus.oog.engine.evaluator.impl.TicTacToeEvaluator;
import com.aenplus.oog.entity.Player;
import com.aenplus.oog.game.Game;

public class MinMaxEngine implements ResponseEngine {
	private Player player;
	private GameEvaluator gameEvaluator = new TicTacToeEvaluator();
	private int depth = 15;

	public MinMaxEngine(Player player) {
		this.player = player;
	}

	public Game getResponse(Game game) {
		Map<Game, Integer> gamesEvaluations = new ConcurrentHashMap<Game, Integer>();
		for(Game nextGame : game.possibleMoves()){
			gamesEvaluations.put(nextGame, min(nextGame, depth));
		}
		List<Game> games = getMaxGames(gamesEvaluations);
		return games.get(new Random().nextInt(games.size()));
	}
	
	private List<Game> getMaxGames(Map<Game, Integer> gamesEvaluations){
		int maxVal = Integer.MIN_VALUE;
		List<Game> resultsGames = new ArrayList<Game>();
		for(Entry<Game, Integer> entry : gamesEvaluations.entrySet()){
			Game nextGame = entry.getKey();
			int eval = entry.getValue();
			if(eval > maxVal){
				resultsGames.clear();
				maxVal = eval;
				resultsGames.add(nextGame);
			}else if(eval == maxVal){
				resultsGames.add(nextGame);
			}
		} 
		return resultsGames;
	}
	
	private int max(Game game, int depth){
		if(depth == 0 || game.isFinished())
			return gameEvaluator.evaluate(game, player, depth);
		else{
			int maxVal = Integer.MIN_VALUE;
			for (Game nextGame : game.possibleMoves()) {
				int val = min(nextGame, depth - 1);
				if(val > maxVal)
					maxVal = val;
			}
			return maxVal;
		}
	}
	private int min(Game game, int depth){
		if(depth == 0 || game.isFinished())
			return gameEvaluator.evaluate(game, player, depth);
		else{
			int minVal = Integer.MAX_VALUE;
			for (Game nextGame : game.possibleMoves()) {
				int val = max(nextGame, depth - 1);
				if(val < minVal)
					minVal = val;
			}
			return minVal;
		}
	}
}
