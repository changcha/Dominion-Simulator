package cards.dominion;

import game.Supply;
import player.Player;
import cards.Action;

public class Bureaucrat extends Action {

	public Bureaucrat(int cost, String name) {
		super(cost, name);
	}

	public void execute(Player p, Supply s) {
	/*	p.addToDeck(s.gainCard("Silver"));
		Player[] opps = p.getOpponents();
		
		for(int i = 0; i < opps.length; i++){
			List<Card> hand = opps[i].getHand();
			Card removed;
			for(int j = 0; j < hand.size(); i++){
				if(hand.get(j) instanceof Victory)
			}
			opps.addToDeck()
		}*/
	}
}
