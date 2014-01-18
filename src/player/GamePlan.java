package player;

import java.util.List;

import cards.Treasure;

public interface GamePlan {
	public List<String> chooseCardsToDiscard(int limit);
	public List<String> chooseCardsToTrash(int limit);
	public void chooseCardsToBuy(int coin);
	public String chooseCardToGain(int limit);
	public void chooseActionsToPlay();
	public List<Treasure> chooseTreasuresToPlay();
	public boolean chooseToDiscardDeck();
}
