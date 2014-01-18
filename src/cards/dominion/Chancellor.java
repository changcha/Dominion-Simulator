package cards.dominion;

import game.Supply;
import player.Player;
import cards.Action;
import cards.Card;

public class Chancellor extends Action {
	
	public Chancellor(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	@Override
	public void execute(Player p, Supply s) {
		p.modifyTreasures(2);
		if(p.getGamePlan().chooseToDiscardDeck()){
			p.discardDeck();
		}
	}
}
