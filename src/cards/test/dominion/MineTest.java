package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import player.PlayerUtils;
import cards.Action;
import cards.CardFactory;
import cards.Treasure;
import cards.test.base.CardTest;

public class MineTest extends CardTest {

	private Action m = (Action)CardFactory.getCard("Mine");
	
	@Test
	public void trashTreasure(){
		int trashSize = supply.getTrash().size();
		m.execute(player);
		assertEquals(trashSize + 1, supply.getTrash().size());
		assertTrue(supply.getLastTrashed() instanceof Treasure);
	}
	
	@Test
	public void gainedCardGoesInHandAndIsNextBestTreasure(){
		int sum = PlayerUtils.sumTreasures(player.getHand());
		m.execute(player);
		assertEquals(sum + 1, PlayerUtils.sumTreasures(player.getHand()));
	}
}
