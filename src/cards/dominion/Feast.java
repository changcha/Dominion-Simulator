package cards.dominion;

import game.Supply;
import player.Player;
import cards.Action;
import cards.Card;

public class Feast extends Action {

	public Feast(int cost, String name, int action, int buy, int coin, int draw) {
		super(cost, name, action, buy, coin, draw);
	}

	@Override
	public void execute(Player p, Supply s) {
		// TODO Auto-generated method stub
		
	}	
}
