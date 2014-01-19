package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.Action;
import cards.CardFactory;
import cards.test.base.CardTest;

public class LaboratoryTest extends CardTest {
	
	private Action lab = (Action) CardFactory.getCard("Laboratory");
	
	@Test
	public void playerDrawsTwoCards(){
		int handSize = player.getHand().size();
		lab.execute(player);
		assertEquals(handSize + 2, player.getHand().size());
	}
	
	@Test
	public void playerGainAnAction(){
		int actionCount = player.getActionCount();
		lab.execute(player);
		assertEquals(actionCount + 1, player.getActionCount());
	}
}
