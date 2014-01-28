package cards.dominion;

import java.util.List;

import player.Player;
import cards.Action;
import cards.Card;

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
		while(p.getHand().size() < 7){
			List<Card> drawn = p.drawCards(1);
			Card d = drawn.get(0);
			p.moveCards(drawn, p.getHand());
			if(d instanceof Action) {
				boolean discardAction = p.getGamePlan().chooseToDiscardCard(d, p.getHand());
				if(discardAction){
					p.discard(d);
				}
			}
		}
	}
}
