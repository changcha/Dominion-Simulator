package cards.dominion;

import java.util.ArrayList;
import java.util.List;

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
		List<Card> treasures = new ArrayList<Card>();
		while(treasures.size() < 2 && !p.noCardsAvailable()){
			Card card = p.revealCardFromDeck();
			if(card instanceof Treasure){
				treasures.add(card);
				p.removeFromReveal(card);
			}
		}
		p.discardReveal();
		p.moveCards(treasures, p.getHand());
	}
}
