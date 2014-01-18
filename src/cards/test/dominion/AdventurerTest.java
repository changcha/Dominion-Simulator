package cards.test.dominion;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cards.Card;
import cards.CardFactory;
import cards.dominion.Adventurer;
import cards.test.base.CardTest;

public class AdventurerTest extends CardTest{

	private Adventurer advent = (Adventurer) CardFactory.getCard("Adventurer");
	
	@Test
	public void drawsExactlyTwoTreasureCards(){
		List<Card> startHand = player.getHand();
		int handSize = startHand.size();
		int treasureCount = countTreasures(startHand);
		advent.execute(player, supply);
		assertEquals(player.getHand().size(), handSize + 2);
		assertEquals(countTreasures(startHand), treasureCount + 2);
	}
	
	/*@Test
	public void discardsAllOtherRevealedCards(){
		//Not sure how to test...
		int discardSize = player.getDiscard().size();
		advent.execute(player, supply);
		assertTrue(player.getDiscard().size() > discardSize);
	}*/
	
	@Test
	public void drawsLessThanTwoTreasuresWhenNoCardsInDiscardOrDeck(){
		player.drawCards(5);
		player.trashCards(8);
		int handSize = player.getHand().size();
		advent.execute(player, supply);
		assertEquals(player.getHand().size(), handSize);
	}
}
