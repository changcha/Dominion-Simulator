package cards.dominion;

import player.Player;
import cards.Action;

public class Chapel extends Action {

	public Chapel(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	@Override
	public void execute(Player p) {
		p.trash(4, 0, false, p.getHand());
	}
}
