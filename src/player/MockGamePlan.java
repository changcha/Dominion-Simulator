package player;

import game.Supply;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cards.Action;
import cards.Card;
import cards.Treasure;

public class MockGamePlan implements GamePlan{
	
	private Player player;
	
	public MockGamePlan(Player player){
		this.player = player;
	}

	public List<String> chooseCardsToDiscard(int limit, boolean exact, List<Card> from) {
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < limit; i++){
			list.add(player.getHand().get(i).getName());
		}
		return list;
	}

	public List<String> chooseCardsToTrash(int limit, boolean exact, List<Card> from) {
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < limit; i++){
			list.add(player.getHand().get(i).getName());
		}
		return list;
	}

	public void chooseActionsToPlay() {
		// TODO Auto-generated method stub
		
	}

	public boolean chooseToDiscardDeck() {
		return true;
	}

	public void chooseCardsToBuy(int coin) {
		// TODO Auto-generated method stub
		
	}

	public List<Treasure> chooseTreasuresToPlay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String chooseCardToGain(int limit, Supply s) {
		s.getCard("Copper"); //Incorrect implementation just wanted to get it to work. 
		return "Copper";
	}

	@Override
	public Action chooseActionToPlay() {
		// TODO Auto-generated method stub
		return null;
	}
}
