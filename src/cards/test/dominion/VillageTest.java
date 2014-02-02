package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.Action;
import cards.CardFactory;
import cards.test.base.CardTest;

public class VillageTest extends CardTest {

	private Action c = (Action) CardFactory.getCard("Village");
	
	@Test
	public void plueOneActionAndTwoCards(){
		int handSize = player.getHand().size();
		int actionSize = player.getActionCount();
		c.execute(player);
		assertTrue(player.getHand().size() >= handSize);
		assertEquals(actionSize + 1, player.getActionCount()); 
	}
}
