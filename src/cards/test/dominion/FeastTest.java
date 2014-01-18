package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.CardFactory;
import cards.dominion.Feast;
import cards.test.base.CardTest;

public class FeastTest extends CardTest {

	Feast f = (Feast) CardFactory.getCard("Feast");
	
	@Test
	public void trashFeast(){
		assertFalse(supply.getTrash().contains(f));
		f.execute(player, supply);
		assertTrue(supply.getTrash().contains(f));
	}
	
	@Test
	public void playerGainsCardCostingUpToFive(){
		
	}
}
