package cards.dominion;

import java.util.List;

import player.Player;
import cards.Action;
import cards.Card;

public class Remodel extends Action {

	public Remodel(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	/*
	 * Player trashes a card and gains one costing up to 2 greater. 
	 */
	@Override
	public void execute(Player p){
		List<Card> trashedList = p.trash(1, 0, true, p.getHand());
		Card trashed = trashedList.get(0);
		p.gainCard(trashed.getCost() + 2, false);
	}
}
