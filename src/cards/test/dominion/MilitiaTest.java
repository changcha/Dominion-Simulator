package cards.test.dominion;

import org.junit.Test;

import player.Player;
import static org.junit.Assert.*;
import cards.Action;
import cards.CardFactory;
import cards.test.base.CardTest;

public class MilitiaTest extends CardTest {

	private Action m = (Action) CardFactory.getCard("Militia");
	
	@Test
	public void allOtherPlayersDiscardsDownToThree(){
		Player[] opps = player.getOpponents();
		m.execute(player);
		for(Player opp: opps){
			assertEquals(3, opp.getHand().size());
		}
	}
	
	@Test
	public void playerGainsTwoCoin(){
		int treasures = player.getTreasureCount();
		m.execute(player);
		assertEquals(treasures + 2, player.getTreasureCount());
	}
}
