package cards.dominion;

import game.Supply;
import player.Player;
import cards.Action;
import cards.Card;
import cards.Treasure;

public class Adventurer extends Action {

	public Adventurer(int cost, String name) {
		super(cost, name);
	}

	public void execute(Player p, Supply s) {
		int treasureCount = 0;
		while(treasureCount < 2 && !p.noCardsAvailable()){
			Card card = p.revealCardsFromDeck();
			if(card instanceof Treasure){
				p.addToHand(card);
				p.removeFromReveal(card);
				treasureCount++;
			}
		}
		p.discardReveal();
	}
}
