package cards.dominion;

import java.util.List;

import game.Supply;
import player.Player;
import cards.Action;
import cards.Card;

public class Cellar extends Action {

	public Cellar(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	public void execute(Player p, Supply s) {
		p.modifyActions(1);
		List<String> discarded = p.discardCards(p.getHand().size());
		p.drawCards(discarded.size());
	}

}