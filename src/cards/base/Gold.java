package cards.base;

import cards.Card;
import cards.Treasure;

public class Gold extends Card implements Treasure {

	public Gold(int cost, String name){
		super(cost, name);
	}
	
	public int getValue() {
		return 3;
	}
}
