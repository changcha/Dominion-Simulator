package cards.test.dominion;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import player.Player;
import cards.Action;
import cards.Card;
import cards.CardFactory;
import cards.Victory;
import cards.test.base.CardTest;

public class BureaucratTest extends CardTest {
	
	private Action b = (Action) CardFactory.getCard("Bureaucrat"); 
	
	@Test
	public void gainsSilverAndPlacesOnTopOfDeck(){
		b.execute(player);
		assertEquals(player.getDeck().pop().getName(), "Silver");
	}
	
	@Test
	public void opponentsPlaceVictoryOnTopOfDeckFromHand(){
		Player opp = player.getOpponents()[0];
		opp.gainCard("Estate", opp.getHand());
		int handSize = opp.getHand().size();
		b.execute(player);
		assertEquals(handSize - 1, opp.getHand().size());
		assertEquals("Estate", opp.getDeck().peek().getName());
	}
	
	@Test
	public void opponentRevealsHandWithNoVictoryCards(){
		Player opp = player.getOpponents()[0];
		Iterator<Card> it = opp.getHand().iterator();
		while(it.hasNext()){
			Card c = it.next();
			if(c instanceof Victory){
				it.remove();
			}
		}
		
		b.execute(player);
		assertEquals(player.getAlert(), "No victory cards available");
	}
}
