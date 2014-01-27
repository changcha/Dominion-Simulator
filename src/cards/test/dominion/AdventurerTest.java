package cards.test.dominion;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import player.PlayerUtils;
import cards.Action;
import cards.Card;
import cards.CardFactory;
import cards.test.base.CardTest;

public class AdventurerTest extends CardTest{

	private Action advent = (Action) CardFactory.getCard("Adventurer");
	
	@Test
	public void drawsExactlyTwoTreasureCards(){
		List<Card> startHand = player.getHand();
		int handSize = startHand.size();
		int treasureCount = PlayerUtils.countTreasures(startHand);
		advent.execute(player);
		assertEquals(player.getHand().size(), handSize + 2);
		assertEquals(PlayerUtils.countTreasures(startHand), treasureCount + 2);
	}
	
	/*@Test
	public void discardsAllOtherRevealedCards(){
		//Not sure how to test...
		int discardSize = player.getDiscard().size();
		advent.execute(player);
		assertTrue(player.getDiscard().size() > discardSize);
	}*/
	
	@Test
	public void drawsLessThanTwoTreasuresWhenNoCardsInDiscardOrDeck(){
		player.moveCards(player.drawCards(5), player.getHand());
		player.trash(8, 0, true, player.getHand());
		int handSize = player.getHand().size();
		advent.execute(player);
		assertEquals(player.getHand().size(), handSize);
	}
}
