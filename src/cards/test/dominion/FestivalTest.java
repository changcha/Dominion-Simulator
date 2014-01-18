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
		int actionCount = player.getActions();
		f.execute(player, supply);
		assertEquals(actionCount + 2, player.getActions()); 
	}
	
	@Test
	public void gainABuy(){
		int buyCount = player.getBuyCount();
		f.execute(player, supply);
		assertEquals(buyCount + 1, player.getBuyCount());
	}
	
	@Test
	public void gainTwoCoin(){
		int coinCount = player.getTreasure();
		f.execute(player, supply);
		assertEquals(coinCount + 2, player.getTreasure());
	}
}
