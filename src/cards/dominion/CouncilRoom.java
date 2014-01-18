package cards.dominion;

import game.Supply;
import player.Player;
import cards.Action;

public class CouncilRoom extends Action {

	public CouncilRoom(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}
	
	public void execute(Player p, Supply s){
		p.modifyBuys(getBuy());
		p.drawCards(getDraw());
		for(Player opp: p.getOpponents()){
			opp.drawCards(1);
		}
	}
}
