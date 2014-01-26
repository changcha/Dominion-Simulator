package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.Action;
import cards.CardFactory;
import cards.base.Copper;
import cards.test.base.CardTest;

public class MoneylenderTest extends CardTest{

	private Action m = (Action) CardFactory.getCard("Moneylender");
	
	@Test
	public void playerTrashesOneCopperAndGainsThreeCoin(){
		int treasureCount = player.getTreasureCount();
		player.getHand().add(CardFactory.getCard("Copper"));
		m.execute(player);
		assertEquals(treasureCount + 3, player.getTreasureCount());
		assertEquals("Copper", supply.getTrash().get(0).getName());
	}
	
	@Test
	public void ifPlayerDoesNotHaveCopperNoExtraCoin(){
		int treasureCount = player.getTreasureCount();
		player.getHand().clear();
		player.getHand().add(CardFactory.getCard("Estate"));
		m.execute(player);
		assertEquals(treasureCount, player.getTreasureCount());
	}
}
