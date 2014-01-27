package cards.dominion;

import player.Player;
import cards.Action;

public class Library extends Action {

	public Library(int cost, String name) {
		super(cost, name);
	}
	
	/*
	 * @see cards.Action#execute(player.Player)
	 * Player draws until hand contains 7 cards
	 * Player can choose to discard actions when drawn.
	 */
	@Override
	public void execute(Player p){
		//while(p.getHand().size() < 7){
			//p.addToHand(p.drawCards(1));
		//}
	}
}
