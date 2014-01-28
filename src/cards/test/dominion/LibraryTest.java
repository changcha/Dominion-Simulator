package cards.test.dominion;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cards.Action;
import cards.Card;
import cards.CardFactory;
import cards.test.base.CardTest;

public class LibraryTest extends CardTest {
	
	private Action lib = (Action) CardFactory.getCard("Library");
	
	@Test
	public void playerDrawUntilHandHasSevenCards(){
		lib.execute(player);
		assertEquals(7, player.getHand().size());
	}
	
	@Test
	public void playerMayDiscardAnyActionsDrawnDuringExecution(){
		//Prime the deck with actions
		player.shuffle();
		player.getDeck().clear();
		player.gainCard("Library", player.getDeck());
		player.gainCard("Library", player.getDeck());
		
		lib.execute(player);
		List<Card> discard = player.getDiscard();
		for(int i = 0; i < discard.size(); i++){
			assertTrue(discard.get(i) instanceof Action);
		}
	}
}
