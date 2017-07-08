package com.aenplus.oog.graphics.impl;

import java.util.List;

import com.aenplus.oog.entity.Player;
import com.aenplus.oog.game.Game;
import com.aenplus.oog.graphics.GameDisplayer;
import com.aenplus.oog.table.Cell;

public class ShellDisplayer implements GameDisplayer {

	public void display(Game game) {
		String res = "| ";
		String lineFormat = "%s | ";
		int height = game.getTable().getNbRows();
		int width = game.getTable().getNbColumn();
		List<Cell> cells = game.getTable().getCells();
		int i = 0;
		for (Cell cell : cells) {
			if (i == width) {
				res += "\n| " + lineFormat.format(lineFormat, cellContent(cell.getPlayer()));
				i = 0;
			} else
				res += lineFormat.format(lineFormat, cellContent(cell.getPlayer()));
			i++;
		}
		System.out.println(res);
	}

	private String cellContent(Player player) {
		if (player != null) {
			return player.getName();
		}
		return "_";
	}

}
