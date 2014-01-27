package cards.dominion;

import cards.Action;
import cards.Reaction;

public class Moat extends Action implements Reaction {

	public Moat(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	@Override
	public void react() {

	}
}
