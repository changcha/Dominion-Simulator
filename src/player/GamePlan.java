package player;

import game.Supply;

import java.util.Collection;
import java.util.List;

import cards.Action;
import cards.Card;
import cards.Treasure;

public interface GamePlan {
	public boolean 			chooseToDiscardCard(Card card, Collection<Card> from);
	public List<Card> 		chooseCardsToDiscard(int limit, int min, boolean exact, List<Card> from);
	public List<Card> 		chooseCardsToTrash(int limit, int min, boolean exact, List<Card> from);
	public List<Card>	 	chooseCardsToBuy(int coin, int buys);
	public String 			chooseCardToGain(int limit, boolean exact, Supply s);
	public Action 			chooseActionToPlay();
	public List<Treasure> 	chooseTreasuresToPlay();
	public boolean 			chooseToDiscardDeck();
}
