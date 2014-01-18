package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cards.Treasure;

public class MockGamePlan implements GamePlan{
	
	private Player player;
	
	public MockGamePlan(Player player){
		this.player = player;
	}

	@Override
	public List<String> chooseCardsToDiscard(int limit) {
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < limit; i++){
			list.add(player.getHand().get(i).getName());
		}
		return list;
	}

	public List<String> chooseCardsToTrash(int limit) {
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < limit; i++){
			list.add(player.getHand().get(i).getName());
		}
		return list;
	}

	@Override
	public void chooseActionsToPlay() {
		// TODO Auto-generated method stub
		
	}

	public boolean chooseToDiscardDeck() {
		return true;
	}

	@Override
	public void chooseCardsToBuy(int coin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Treasure> chooseTreasuresToPlay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String chooseCardToGain(int limit) {
		// TODO Auto-generated method stub
		return null;
	}
}
