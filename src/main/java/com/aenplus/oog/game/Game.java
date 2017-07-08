package com.aenplus.oog.game;

import java.util.List;

import com.aenplus.oog.entity.Player;
import com.aenplus.oog.table.Table;

public abstract class Game{
	protected Player player1;
	protected Player player2;
	protected Player lastPlayer;
	protected Table table;
	
	public abstract void initGame(Player player1, Player player2);

	public Player mustPlay(){
		if (lastPlayer == player1)
			return player2;
		return player1;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public void setLastPlayer(Player player) {
		lastPlayer = player;
	}
	
	public Game clone(){
		Game game;
		try {
			game = (Game) super.clone();
			game.setTable(table.clone());
			return game;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public abstract boolean isFinished();
	
	public abstract boolean isWinner();

	public abstract Player getWinner();

	public abstract List<Game> possibleMoves();
}
