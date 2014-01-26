package cards.dominion;

import player.Player;
import cards.Action;

public class Militia extends Action {

	public Militia(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}
	
	@Override
	public void execute(Player p){
		super.execute(p);
		Player[] opps = p.getOpponents();
		for(Player opp: opps){
			int handSize = opp.getHand().size();
			opp.discard(handSize - 3, 0, true, opp.getHand());
		}
	}
}
