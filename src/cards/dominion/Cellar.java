package cards.dominion;

import java.util.List;

import player.Player;
import cards.Action;
import cards.Card;

public class Cellar extends Action {

	public Cellar(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	/*
	 * @see cards.Action#execute(player.Player)
	 * Player chooses to discard a number of cards.
	 * Player then draws that many cards from deck
	 * Player gets +1 action.
	 */
	@Override
	public void execute(Player p) {
		super.execute(p);
		List<Card> discarded = p.discard(p.getHand().size(), 0, false, p.getHand());
		p.drawIntoHand(discarded.size());
	}
}
