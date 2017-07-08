package com.aenplus.oog.game.engine;

import com.aenplus.oog.entity.Player;
import com.aenplus.oog.game.Game;
import com.aenplus.oog.graphics.GameDisplayer;

public class GameEngine {
	private Player winner;

	public void start(Game game, GameDisplayer displayer) {
		int nbCoups = 0;
		displayer.display(game);
		while (!game.isFinished()) {
			System.out.println("coup No : " + nbCoups);
			Player player = game.mustPlay();
			game = player.getResponseEngine().getResponse(game);
			displayer.display(game);
			nbCoups++;
		}
		winner = game.getWinner();
		if(winner != null)
			System.out.printf("finished (nbCoups=%s) (winner=%s)", nbCoups, winner.getName());
		else
			System.out.printf("finished (nbCoups=%s) (winner=null)", nbCoups);
	}
}
