package com.aenplus.oog.table;

import com.aenplus.oog.entity.Player;

public class Cell implements Cloneable {
	private Player current;

	public void setPlayer(Player player) {
		current = player;
	}

	public Player getPlayer() {
		return current;
	}

	public void clear() {
		current = null;
	}

	public boolean isEmpty() {
		return current == null;
	}

	public Cell clone() {
		try {
			return (Cell) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
