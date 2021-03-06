package cards.dominion;

import player.Player;
import cards.Action;
import cards.Card;

public class Moneylender extends Action {

	public Moneylender(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	/*
	 * Player trashes copper to gain extra 3 coin.  
	 */
	@Override
	public void execute(Player p){
		boolean trashedCopper = false;
		for(Card c: p.getHand()){
			if(c.getName().equals("Copper")){
				p.trash(c);
				trashedCopper = true;
				break;
			}
		}
		if(trashedCopper)
			p.modifyTreasures(3);
	}
}
