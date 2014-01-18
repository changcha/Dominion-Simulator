package cards.dominion;

import game.Supply;
import player.Player;
import cards.Action;
import cards.Card;

public class CouncilRoom extends Action {

	public CouncilRoom(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}
	
	public void execute(Player p, Supply s){
		p.modifyBuys(1);
		p.drawCards(4);
		for(Player opp: p.getOpponents()){
			opp.drawCards(1);
		}
	}
}
