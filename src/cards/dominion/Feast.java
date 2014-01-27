package cards.dominion;
import java.util.ArrayList;
import java.util.List;

import player.Player;
import cards.Action;
import cards.Card;

public class Feast extends Action {

	public Feast(int cost, String name) {
		super(cost, name);
	}

	/*
	 * (@see cards.Action#execute(player.Player)
	 * Player can trash Feast to gain a card costing up to 5.
	 */
	@Override
	public void execute(Player p) {
		List<Card> list = new ArrayList<Card>();
		list.add(this);
		p.trash(1, 0, true, list);
		p.gainCard(5, false);
	}	
}
