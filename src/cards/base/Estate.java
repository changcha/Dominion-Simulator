package cards.base;

import player.Player;
import cards.Card;
import cards.Victory;

public class Estate extends Card implements Victory {

	public Estate(int cost, String name){
		super(cost, name);
	}

	@Override
	public int getPoints(Player p) {
		return 1;
	}
}
