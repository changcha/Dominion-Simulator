package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.Action;
import cards.CardFactory;
import cards.test.base.CardTest;

public class FeastTest extends CardTest {

	private Action f = (Action) CardFactory.getCard("Feast");
	
	@Test
	public void trashFeast(){
		assertFalse(supply.getTrash().contains(f));
		f.execute(player);
		assertTrue(supply.getTrash().contains(f));
	}
	
	@Test
	public void playerGainsCardCostingUpToFiveAndPlacesInDiscard(){
		player.shuffle();
		assertEquals(player.getDiscard().size(), 0);
		f.execute(player);
		assertEquals(player.getDiscard().size(), 1);
		assertTrue(player.getDiscard().get(0).getCost() <= 5);
	}
}
