package game.test;

import static org.junit.Assert.assertEquals;
import game.Supply;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cards.Action;
import cards.Card;

public class SupplyTest {

	private Supply supply;
	
	@Before
	public void setup(){
		supply = new Supply(2);
		
	}
	
	@Test
	public void initializesGameCards(){
		assertEquals(17, supply.getCardList().size());
		assertEquals(46, supply.getCardCount("Copper"));
		assertEquals(40, supply.getCardCount("Silver"));
		assertEquals(30, supply.getCardCount("Gold"));
	}
	
	@Test
	public void lowersCardCountWhenCardIsGained(){
		String name = "Copper";
		int initCount = supply.getCardCount(name);
		supply.getCard(name);
		assertEquals(initCount - 1, supply.getCardCount(name));
	}
	
	@Test
	public void getCountOfEmptySupplyPiles(){
		assertEquals(0, supply.emptyPileCount());
		String name = "Curse";
		int curseCount = supply.getCardCount(name);
		for(int i = 0; i < curseCount; i++){
			supply.getCard(name); //Remove that card.
		}
		assertEquals(1, supply.emptyPileCount());
	}
	
	@Test
	public void canAddSingleCardToTrash(){
		supply.addToTrash(new Action(4, "Mock"));
		assertEquals(1, supply.getTrash().size());
		assertEquals("Mock", supply.getTrash().get(0).getName());
	}
	
	@Test
	public void canAddListToTrash(){
		List<Card> toTrash = new ArrayList<Card>();
		toTrash.add(new Action(1, "Mock1"));
		toTrash.add(new Action(2, "Mock2"));
		toTrash.add(new Action(3, "Mock3"));
		
		supply.addToTrash(toTrash);
		List<Card> trash = supply.getTrash();
		assertEquals(3, trash.size());
		assertEquals("Mock1", trash.get(0).getName());
		assertEquals("Mock2", trash.get(1).getName());
		assertEquals("Mock3", trash.get(2).getName());
	}
	
	@Test
	public void canGetSingleCardBasedOnName(){
		Card testCard = supply.getCard("Copper");
		assertEquals(0, testCard.getCost());
		assertEquals("Copper", testCard.getName());
	}
	
	@Test
	public void changesPileCountsBasedOnPlayersInGame(){
		int estateCount = supply.getCardCount("Estate");
		int curseCount = supply.getCardCount("Curse");
		assertEquals(8, estateCount);
		assertEquals(10, curseCount);
		
		supply = new Supply(3);
		estateCount = supply.getCardCount("Estate");
		curseCount = supply.getCardCount("Curse");
		assertEquals(12, estateCount);
		assertEquals(20, curseCount);
	}
}
