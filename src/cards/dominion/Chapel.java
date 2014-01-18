package cards.dominion;

import java.util.List;

import game.Supply;
import player.Player;
import cards.Action;
import cards.Card;

public class Chapel extends Action {

	public Chapel(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	public void execute(Player p, Supply s) {
		List<String> trashed = p.mayTrashCards(4);
	}
}
