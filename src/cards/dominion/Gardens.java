package cards.dominion;

import player.Player;
import cards.Card;
import cards.Victory;

public class Gardens extends Card implements Victory {

	public Gardens(int cost, String name) {
		super(cost, name);
	}

	@Override
	public int getPoints(Player p) {
		return p.getDeck().size() / 10;
	}
}
