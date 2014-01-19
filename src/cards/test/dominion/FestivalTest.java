package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.Action;
import cards.CardFactory;
import cards.test.base.CardTest;

public class FestivalTest extends CardTest{

	private Action f = (Action) CardFactory.getCard("Festival");
	
	@Test
	public void gainTwoActions(){
		int actionCount = player.getActionCount();
		f.execute(player);
		assertEquals(actionCount + 2, player.getActionCount()); 
	}
	
	@Test
	public void gainABuy(){
		int buyCount = player.getBuyCount();
		f.execute(player);
		assertEquals(buyCount + 1, player.getBuyCount());
	}
	
	@Test
	public void gainTwoCoin(){
		int coinCount = player.getTreasureCount();
		f.execute(player);
		assertEquals(coinCount + 2, player.getTreasureCount());
	}
}
