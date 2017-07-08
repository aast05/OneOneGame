package com.aenplus.oog.table;

import java.util.ArrayList;
import java.util.List;

public class Table implements Cloneable {
	private int row;
	private int column;
	private List<Cell> cells;

	public Table(int row, int column) {
		this.row = row;
		this.column = column;
		this.cells = new ArrayList<Cell>();
		for (int i = 0; i < row * column; i++) {
			cells.add(new Cell());
		}
	}

	public List<Cell> getCells() {
		return cells;
	}

	public int getNbRows() {
		return row;
	}

	public int getNbColumn() {
		return column;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}

	public boolean isFull() {
		for (Cell cell : cells) {
			if (cell.isEmpty())
				return false;
		}
		return true;
	}

	public Table clone() {
		Table o;
		try {
			o = (Table) super.clone();
			List<Cell> newCells = new ArrayList<Cell>();
			for (Cell cell : cells) {
				newCells.add(cell.clone());
			}
			o.setCells(newCells);
			return o;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
