package cards.dominion;

import java.util.List;
import player.Player;
import cards.Action;

public class Cellar extends Action {

	public Cellar(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	@Override
	public void execute(Player p) {
		super.execute(p);
		List<String> discarded = p.discardCardsFromHand(p.getHand().size(), false);
		p.drawCards(discarded.size());
	}

}
