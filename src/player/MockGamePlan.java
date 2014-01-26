package player;

import game.Supply;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import cards.Action;
import cards.Card;
import cards.CardFactory;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Card> chooseCardsToBuy(int coin, int buys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String chooseCardToGain(int limit, Supply s) {
		return s.getCardList().get(0).getName();
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
