package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.Action;
import cards.CardFactory;
import cards.test.base.CardTest;

public class ChapelTest extends CardTest{

	private Action c = (Action) CardFactory.getCard("Chapel");
	
	@Test
	public void trashUpToFourCards(){
		int trashSize = supply.getTrash().size();
		int handSize = player.getHand().size();
		c.execute(player, supply);
		assertTrue(trashSize >= supply.getTrash().size() - 4);
		assertTrue(handSize <= player.getHand().size() + 4);
	}
}
