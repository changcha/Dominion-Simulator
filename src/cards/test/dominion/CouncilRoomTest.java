package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import player.Player;
import cards.CardFactory;
import cards.dominion.CouncilRoom;
import cards.test.base.CardTest;

public class CouncilRoomTest extends CardTest {
	
	CouncilRoom c = (CouncilRoom) CardFactory.getCard("CouncilRoom");
	
	@Test
	public void playerGetExtraBuy(){
		int buys = player.getBuyCount();
		executeWrapper(c, player, supply);
		assertEquals(buys + 1, player.getBuyCount());
	}
	
	@Test
	public void playerGetsFourDraws(){
		int cards = player.getHand().size();
		executeWrapper(c, player, supply);
		assertEquals(cards + 4, player.getHand().size());
	}
	
	@Test
	public void otherPlayersGetExtraDraw(){
		Player[] opps = player.getOpponents();
		int[] sizes = new int[opps.length];
		for(int i = 0; i < opps.length; i++){
			sizes[i] = opps[i].getHand().size();
		}
		executeWrapper(c, player, supply);
		for(int i = 0; i < opps.length; i++){
			assertEquals(opps[i].getHand().size(), sizes[i] + 1);
		}
	}
}
