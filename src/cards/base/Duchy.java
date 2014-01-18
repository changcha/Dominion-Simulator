package cards.base;

import player.Player;
import cards.Card;
import cards.Victory;

public class Duchy extends Card implements Victory {

	public Duchy(int cost, String name){
		super(cost, name);
	}
	
	public int getPoints(Player p) {
		return 3;
	}
}
