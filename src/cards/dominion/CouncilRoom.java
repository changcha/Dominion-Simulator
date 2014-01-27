package cards.dominion;

import player.Player;
import cards.Action;

public class CouncilRoom extends Action {

	public CouncilRoom(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}
	
	/*
	 * @see cards.Action#execute(player.Player)
	 * Player gains 4 cards and a buy
	 * All other players gain a card
	 */
	@Override
	public void execute(Player p){
		super.execute(p);
		for(Player opp: p.getOpponents()){
			opp.moveCards(opp.drawCards(1), opp.getHand());
		}
	}
}
