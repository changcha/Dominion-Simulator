package cards.test.dominion;

import org.junit.Test;

import cards.Action;
import cards.CardFactory;
import cards.test.base.CardTest;

public class LibraryTest extends CardTest {
	
	private Action lib = (Action) CardFactory.getCard("Library");
	
	@Test
	public void playerDrawUntilHandHasSevenCards(){
		
	}
	
	@Test
	public void playerMayDiscardAnyActionsDrawn(){
		
	}
}
