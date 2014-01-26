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
	
	/*@Test
	public void playerMayDiscardAnyActionsDrawnDuringExecution(){
		player.shuffle();
		lib.execute(player);
		player.gainCard("Library", player.getDeck());
		player.gainCard("Library", player.getDeck());
		List<Card> discard = player.getDiscard();
		assertTrue(discard.size() == 1 || discard.size() == 2);
		for(int i = 0; i < discard.size(); i++){
			assertTrue(discard.get(i) instanceof Action);
		}
	}*/
}
