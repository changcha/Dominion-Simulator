package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.Action;
import cards.CardFactory;
import cards.test.base.CardTest;

public class RemodelTest extends CardTest{

	private Action r = (Action)CardFactory.getCard("Remodel");
	
	@Test
	public void gainACardCostingTwoMoreThanTrashedCard(){
		int handSize = player.getHand().size();
		int trashSize = supply.getTrash().size();
		r.execute(player);
		assertEquals(handSize - 1, player.getHand().size());
		assertEquals(trashSize + 1, supply.getTrash().size());
		int originalCost = supply.getTrash().get(0).getCost();
		assertTrue(originalCost + 2 >= player.getDiscard().get(0).getCost()); //TODO: Not the best test. May need rewrite. 
	}
}
