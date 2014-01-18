package cards.test.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import cards.Action;
import cards.Card;
import cards.CardFactory;
import cards.Treasure;
import player.*;
import game.Supply;

public class CardTest {

	protected Player player;
	protected Supply supply;
	
	@Before
	public void setup(){
		Stack<Card> start = new Stack<Card>();
		supply = new Supply();
		Player[] opps = new Player[2];
		opps[0] = new Player(supply, null);
		opps[1] = new Player(supply, null);
		player = new Player(supply, opps);	
		GamePlan plan = new MockGamePlan(player);
		player.setGamePlan(plan);
	}
	
	public int countTreasures(List<Card> cards){
		int count = 0;
		for(int i = 0; i < cards.size(); i++){
			if(cards.get(i) instanceof Treasure){
				count++;
			}
		}
		return count;
	}
	
	//POC
	/*@Test
	public void fuckIHopeThisWorks(){
		Card c = CardFactory.getCard("Chapel");
		int trashSize = supply.getTrash().size();
		int handSize = player.getHand().size();

		if(c instanceof Action){
			((Action)c).execute(player, supply);
		}
		assertEquals(c.getName(), "Chapel");
		assertEquals(c.getCost(), 2);
		assertTrue(trashSize >= supply.getTrash().size() - 4);
		assertTrue(handSize <= player.getHand().size() + 4);
	}*/
	
	public void executeWrapper(Action a, Player p, Supply s){
		p.modifyActions(-1);
		a.execute(p, s);
	}
}
