package cards.base;

import cards.Card;
import cards.Victory;

public class Province extends Card implements Victory {

	public Province(int cost, String name){
		super(cost, name);
	}
	
	public int getPoints() {
		return 6;
	}
}
