package cards.test.dominion;

import static org.junit.Assert.*;

import org.junit.Test;

import player.Player;
import cards.Action;
import cards.CardFactory;
import cards.test.base.CardTest;

public class BureaucratTest extends CardTest {
	
	private Action b = (Action) CardFactory.getCard("Bureaucrat"); 
	
	@Test
	public void gainsSilverAndPlacesOnTopOfDeck(){
		b.execute(player, supply);
		assertEquals(player.getDeck().pop().getName(), "Silver");
	}
	
	@Test
	public void opponentsPlaceVictoryOnTopOfDeckFromHand(){
		Player opp = new Player();
		opp.addToHand(CardFactory.getCard("Estate"));
		int handSize = opp.getHand().size();
		Player[] opps = {opp};
		player = new Player(null, supply, opps);
		b.execute(player, supply);
		assertEquals(opp.getHand().size(), handSize - 1);
		assertEquals(opp.getDeck().peek().getName(), "Estate");
	}
	
	@Test
	public void opponentRevealsHandWithNoVictoryCards(){
		//Not sure how to test...
	}
}
