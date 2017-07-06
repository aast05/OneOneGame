package com.aenplus.oog.game;

import java.util.List;

import com.aenplus.oog.entity.Player;
import com.aenplus.oog.table.Table;

public interface Game{

	public void initGame(Player player1, Player player2);

	public Player mustPlay();

	public Table getTable();

	public void setTable(Table table);

	public void setLastPlayer(Player player);

	public boolean isFinished();
	
	public boolean isWinner();

	public Player getWinner();

	public List<Game> possibleMoves();
	
	public Game clone();
}
