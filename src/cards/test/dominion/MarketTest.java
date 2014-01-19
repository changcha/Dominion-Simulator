package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.Action;
import cards.CardFactory;
import cards.test.base.CardTest;

public class MarketTest extends CardTest {
	
	private Action m = (Action) CardFactory.getCard("Market");
	
	@Test
	public void playerGainAnAction(){
		int actionCount = player.getActionCount();
		m.execute(player);
		assertEquals(actionCount + 1, player.getActionCount());
	}
	
	@Test
	public void playerGainsABuy(){
		int buyCount = player.getBuyCount();
		m.execute(player);
		assertEquals(buyCount + 1, player.getBuyCount());
	}
	
	@Test
	public void playerGainsACoin(){
		int treasureCount = player.getTreasureCount();
		m.execute(player);
		assertEquals(treasureCount + 1, player.getTreasureCount());
	}
	
	@Test
	public void playerDrawsACard(){
		int handSize = player.getHand().size();
		m.execute(player);
		assertEquals(handSize + 1, player.getHand().size());
	}
}
