package cards.dominion;

import player.Player;
import cards.Action;

public class CouncilRoom extends Action {

	public CouncilRoom(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}
	
	@Override
	public void execute(Player p){
		super.execute(p);
		for(Player opp: p.getOpponents()){
			opp.drawCards(1);
		}
	}
}
