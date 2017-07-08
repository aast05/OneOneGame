package com.aenplus.oog;

import com.aenplus.oog.engine.impl.HumanEngine;
import com.aenplus.oog.engine.impl.MinMaxEngine;
import com.aenplus.oog.entity.Player;
import com.aenplus.oog.game.Game;
import com.aenplus.oog.game.engine.GameEngine;
import com.aenplus.oog.game.impl.TicTacToe;
import com.aenplus.oog.graphics.GameDisplayer;
import com.aenplus.oog.graphics.impl.ShellDisplayer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		GameEngine gameEngine = new GameEngine();
		Game game = new TicTacToe();
		Player player1 = new Player();
		Player player2 = new Player();
		player1.setName("P1");
		player2.setName("P2");
		player1.setResponseEngine(new MinMaxEngine(player1));
		player2.setResponseEngine(new HumanEngine(player2));
		game.initGame(player1, player2);

		GameDisplayer disp = new ShellDisplayer();
		gameEngine.start(game, disp);
	}
}
