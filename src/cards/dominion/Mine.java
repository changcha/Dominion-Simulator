package cards.dominion;

import java.util.List;

import player.GamePlan;
import player.Player;
import player.PlayerUtils;
import cards.Action;
import cards.Card;
import cards.base.Copper;

public class Mine extends Action {

	public Mine(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	/*
	 * @see cards.Action#execute(player.Player)
	 * Trash coin and gains a coin costing up to 3 greater than trashed card.
	 */
	@Override
	public void execute(Player p){
		GamePlan plan = p.getGamePlan();
		List<Card> trashed = plan.chooseCardsToTrash(1, 0, true, PlayerUtils.getTreasures(p.getHand()));
		Card trashCard = trashed.get(0);
		int worth = trashCard.getCost();
		p.trash(trashCard);
		//gainTreasure?
	}
}
