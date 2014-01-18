package cards.base;

import cards.Card;
import cards.Treasure;

public class Silver extends Card implements Treasure {

	public Silver(int cost, String name) {
		super(cost, name);
	}

	public int getValue() {
		return 2;
	}
}
