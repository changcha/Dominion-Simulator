package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.Action;
import cards.CardFactory;
import cards.test.base.CardTest;

public class ChancellorTest extends CardTest{

	private Action c = (Action) CardFactory.getCard("Chancellor");
	
	@Test
	public void gainsTwoCoin(){
		assertEquals(player.getTreasure(), 0);
		c.execute(player, supply);
		assertEquals(player.getTreasure(), 2);
	}
	
	@Test
	public void playerCanDiscardDeck(){
		int deckSize = player.getDeck().size();
		assertTrue(deckSize != 0);
		c.execute(player, supply);
		assertTrue(player.getDeck().size() == 0);
	}
}
