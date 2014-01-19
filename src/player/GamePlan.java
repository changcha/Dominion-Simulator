package player;

import game.Supply;

import java.util.List;

import cards.Action;
import cards.Card;
import cards.Treasure;

public interface GamePlan {
	public List<String> chooseCardsToDiscard(int limit, boolean exact, List<Card> from);
	public List<String> chooseCardsToTrash(int limit, boolean exact, List<Card> from);
	public void chooseCardsToBuy(int coin);
	public String chooseCardToGain(int limit, Supply s);
	public void chooseActionsToPlay();
	public List<Treasure> chooseTreasuresToPlay();
	public boolean chooseToDiscardDeck();
	public Action chooseActionToPlay();
}
