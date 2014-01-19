package cards.dominion;

import game.Supply;
import player.Player;
import cards.Action;

public class Feast extends Action {

	public Feast(int cost, String name) {
		super(cost, name);
	}

	@Override
	public void execute(Player p) {
		p.trashCard(this);
		p.gainCard(5);
	}	
}
