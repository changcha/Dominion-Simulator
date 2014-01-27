package cards.test.base;

import java.util.List;
import org.junit.Before;
import cards.Card;
import cards.Treasure;
import player.*;
import game.Supply;

public class CardTest {

	protected Player player;
	protected Supply supply;
	
	@Before
	public void setup(){
		supply = new Supply();
		
		Player[] opps = new Player[2];
		opps[0] = new Player(supply, null);
		opps[1] = new Player(supply, null);
		opps[0].setGamePlan(new MockGamePlan(opps[0]));
		opps[1].setGamePlan(new MockGamePlan(opps[1]));
		
		player = new Player(supply, opps);	
		player.setGamePlan(new MockGamePlan(player));
	}
	
	//POC
	/*@Test
	public void fuckIHopeThisWorks(){
		Card c = CardFactory.getCard("Chapel");
		int trashSize = supply.getTrash().size();
		int handSize = player.getHand().size();

		if(c instanceof Action){
			((Action)c).execute(player);
		}
		assertEquals(c.getName(), "Chapel");
		assertEquals(c.getCost(), 2);
		assertTrue(trashSize >= supply.getTrash().size() - 4);
		assertTrue(handSize <= player.getHand().size() + 4);
	}*/
}
