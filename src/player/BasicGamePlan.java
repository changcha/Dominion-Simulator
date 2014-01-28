package player;

import game.Supply;

import java.util.Collection;
import java.util.List;

import cards.Action;
import cards.Card;
import cards.Treasure;

public class BasicGamePlan implements GamePlan{

	@Override
	public boolean chooseToDiscardCard(Card card, Collection<Card> from) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Card> chooseCardsToDiscard(int limit, int min, boolean exact,
			List<Card> from) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> chooseCardsToTrash(int limit, int min, boolean exact,
			List<Card> from) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String chooseCardToGain(int limit, boolean exact, List<Card> chooseFrom) {
		if(chooseFrom != null && !chooseFrom.isEmpty()){
			int max = chooseFrom.get(0).getCost();
			String name = chooseFrom.get(0).getName();
			for(Card c: chooseFrom){
				int cost = c.getCost();
				if(cost > max){
					if(exact && cost == limit){
						return c.getName();
					}
				}
			}
			return name;
		}
		return null;
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

	@Override
	public boolean chooseToDiscardDeck() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Card> chooseCardsToBuy(int coin, int buys, Supply s) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getMaxBelowLimit(){
		return null;
	}
}
