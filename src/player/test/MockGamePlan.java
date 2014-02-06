package player.test;

import game.Supply;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import player.GamePlan;
import player.Player;
import cards.Action;
import cards.Card;
import cards.Treasure;

public class MockGamePlan implements GamePlan{
	
	private Player player;
	
	public MockGamePlan(Player player){
		this.player = player;
	}

	public List<Card> chooseCardsToDiscard(int limit, int min, boolean exact, List<Card> from) {
		return chooseCardsToTrash(limit, min, exact, from);
	}

	public List<Card> chooseCardsToTrash(int limit, int min, boolean exact, List<Card> from) {
		List<Card> returned = new ArrayList<Card>();
		if(exact){
			for(int i = 0; i < limit && i < from.size(); i++){
				returned.add(from.get(i));
			}
		} else {
			returned.add(from.get(0));
		}
		return returned;
	}

	public boolean chooseToDiscardDeck() {
		return true;
	}

	@Override
	public boolean chooseToDiscardCard(Card card, Collection<Card> from) {
		return Math.random() >= 0.5 ? false: true;
	}

	@Override
	public List<Card> chooseCardsToBuy(int coin, int buys, Supply supply) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String chooseCardToGain(int limit, boolean exact, List<Card> chooseFrom) {
		for(Card c : chooseFrom){
			if(c.getCost() <= limit)
				return c.getName();
		}
		return "Copper";
	}

	@Override
	public Action chooseActionToPlay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Treasure> chooseTreasuresToPlay() {
		// TODO Auto-generated method stub
		return null;
	}
}
