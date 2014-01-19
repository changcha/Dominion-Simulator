package cards.dominion;

import player.Player;
import cards.Action;

public class Chapel extends Action {

	public Chapel(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	@Override
	public void execute(Player p) {
		/*List<String> trashed =*/ p.trashCardsFromHand(4, false);
		//Report on trahsed cards somehow?
	}
}
