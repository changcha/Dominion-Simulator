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
		int actionCount = player.getActions();
		m.execute(player, supply);
		assertEquals(actionCount + 1, player.getActions());
	}
	
	@Test
	public void playerGainsABuy(){
		int buyCount = player.getBuyCount();
		m.execute(player, supply);
		assertEquals(buyCount + 1, player.getBuyCount());
	}
	
	@Test
	public void playerGainsACoin(){
		int treasureCount = player.getTreasure();
		m.execute(player, supply);
		assertEquals(treasureCount + 1, player.getTreasure());
	}
	
	@Test
	public void playerDrawsACard(){
		int handSize = player.getHand().size();
		m.execute(player, supply);
		assertEquals(handSize + 1, player.getHand().size());
	}
}
