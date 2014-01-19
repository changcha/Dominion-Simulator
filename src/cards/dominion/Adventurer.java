package cards.dominion;

import player.Player;
import cards.Action;
import cards.Card;
import cards.Treasure;

public class Adventurer extends Action {

	public Adventurer(int cost, String name) {
		super(cost, name);
	}

	@Override
	public void execute(Player p) {
		int treasureCount = 0;
		while(treasureCount < 2 && !p.noCardsAvailable()){
			Card card = p.revealCardFromDeck();
			if(card instanceof Treasure){
				p.addToHand(card);
				p.removeFromReveal(card);
				treasureCount++;
			}
		}
		p.discardReveal();
	}
}
