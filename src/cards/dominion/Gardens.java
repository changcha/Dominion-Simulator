package cards.dominion;

import player.Player;
import cards.Card;
import cards.Victory;

public class Gardens extends Card implements Victory {

	public Gardens(int cost, String name) {
		super(cost, name);
	}

	/*
	 * @see cards.Victory#getPoints(player.Player)
	 * Player gains the number of cards in deck divided by 10 rounded down.
	 */
	@Override
	public int getPoints(Player p) {
		return p.getDeck().size() / 10;
	}
}
