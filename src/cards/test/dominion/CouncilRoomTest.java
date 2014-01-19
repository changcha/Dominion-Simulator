package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import player.Player;
import cards.Action;
import cards.CardFactory;
import cards.test.base.CardTest;

public class CouncilRoomTest extends CardTest {
	
	private Action c = (Action) CardFactory.getCard("CouncilRoom");
	
	@Test
	public void playerGetExtraBuy(){
		int buys = player.getBuyCount();
		c.execute(player);
		assertEquals(buys + 1, player.getBuyCount());
	}
	
	@Test
	public void playerGetsFourDraws(){
		int cards = player.getHand().size();
		c.execute(player);
		assertEquals(cards + 4, player.getHand().size());
	}
	
	@Test
	public void otherPlayersGetExtraDraw(){
		Player[] opps = player.getOpponents();
		int[] sizes = new int[opps.length];
		for(int i = 0; i < opps.length; i++){
			sizes[i] = opps[i].getHand().size();
		}
		c.execute(player);
		for(int i = 0; i < opps.length; i++){
			assertEquals(opps[i].getHand().size(), sizes[i] + 1);
		}
	}
}
