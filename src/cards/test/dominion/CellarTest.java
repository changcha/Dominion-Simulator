package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.Action;
import cards.CardFactory;
import cards.test.base.CardTest;

public class CellarTest extends CardTest{

	private Action c = (Action) CardFactory.getCard("Cellar");
	
	@Test
	public void discardAnyNumberOfCardsAndDrawThatSameAmount(){
		int handSize = player.getHand().size();
		int discardSize = player.getDiscard().size();
		c.execute(player);
		assertEquals(handSize, player.getHand().size());
		assertTrue(player.getDiscard().size() >= discardSize);
	}
	
	@Test
	public void playerGainsExtraAction(){
		int actionCount = player.getActionCount();
		c.execute(player);
		assertEquals(actionCount + 1, player.getActionCount());
	}
}
