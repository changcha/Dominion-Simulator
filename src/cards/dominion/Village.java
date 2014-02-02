package cards.dominion;

import player.Player;
import cards.Action;

public class Village extends Action {
	
	public Village(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}
	
	/*
	 * (@see cards.Action#execute(player.Player)
	 * Player gets +1 action and +2 cards.
	 * Dominion Set: Base Set
	 */
	
	@Override
	public void execute(Player p) {
		super.execute(p);
	}
	
}