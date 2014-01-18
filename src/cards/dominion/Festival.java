package cards.dominion;

import game.Supply;
import player.Player;
import cards.Action;

public class Festival extends Action {

	public Festival(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	public void execute(Player p, Supply s) {
		p.modifyActions(getAction());
		p.modifyBuys(getBuy());
		p.modifyTreasures(getTreasure());
	}
}
