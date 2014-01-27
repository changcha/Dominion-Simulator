package cards.dominion;

import player.Player;
import cards.Action;

public class Chancellor extends Action {
	
	public Chancellor(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	/*
	 * @see cards.Action#execute(player.Player)
	 * Player gains 2 coin.
	 * Player can choose to discard entire deck.
	 */
	@Override
	public void execute(Player p) {
		super.execute(p);
		if(p.getGamePlan().chooseToDiscardDeck()){
			p.moveCards(p.getDeck(), p.getDiscard());
		}
	}
}
