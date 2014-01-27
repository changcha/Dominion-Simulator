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

	/*
	 * @see cards.Action#execute(player.Player)
	 * Player reveals cards from deck until two treasures are revealed.
	 * Treasures are put into hand and all other cards are discarded.
	 */
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
