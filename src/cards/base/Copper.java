package cards.base;

import cards.Card;
import cards.Treasure;

public class Copper extends Card implements Treasure {

	public Copper(int cost, String name) {
		super(cost, name);
	}

	public int getValue() {
		return 1;
	}
}
