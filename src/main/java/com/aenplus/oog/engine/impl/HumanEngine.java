package com.aenplus.oog.engine.impl;

import java.util.Scanner;

import com.aenplus.oog.engine.ResponseEngine;
import com.aenplus.oog.entity.Player;
import com.aenplus.oog.game.Game;
import com.aenplus.oog.table.Cell;

public class HumanEngine implements ResponseEngine {
	private Player player;

	public HumanEngine(Player player) {
		this.player = player;
	}
	
	public Game getResponse(Game game) {
		System.out.println("<<HUMAN-ENGINE>>\n in which cell you want to put your mark ? (0-8):");
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();
		if(value >= 0 && value <= 8){
			Game newGame = game.clone();
			Cell cell = newGame.getTable().getCells().get(value);
			if(cell.isEmpty()){
				cell.setPlayer(player);
				newGame.setLastPlayer(player);
				return newGame;
			}
			else{
				System.out.println("cell already used (input = "+value+")");
				return getResponse(game);
			}
		}else{
			System.out.println("must be under 0-8 (input = "+value+")");
			return getResponse(game);
		}
	}

}
