package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.CardFactory;
import cards.Victory;
import cards.test.base.CardTest;

public class GardensTest extends CardTest {
	
	private Victory g = (Victory) CardFactory.getCard("Gardens");
	
	@Test
	public void playerGainsDeckSizeDividedBy10Points(){
		int size = player.getDeck().size();
		int pointsA = g.getPoints(player);
		assertEquals(pointsA, size/10);
		
		for(int i = 0; i < 20; i++){
			player.gainCard(0);
		}
		player.shuffle();
		int pointsB = g.getPoints(player);
		assertEquals(pointsA + 2, pointsB);
	}
}
