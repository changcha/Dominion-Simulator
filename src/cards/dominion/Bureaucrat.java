package cards.dominion;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.Victory;
import player.Player;
import cards.Action;

public class Bureaucrat extends Action {

	public Bureaucrat(int cost, String name) {
		super(cost, name);
	}

	/*
	 * @see cards.Action#execute(player.Player)
	 * Player gains a silver
	 * All other players must put a victory card back on top of deck 
	 * or reveal a hand with no victory cards. 
	 */
	@Override
	public void execute(Player p) {
		p.gainCard("Silver", p.getDeck());
		Player[] opps = p.getOpponents();
		for(Player opp: opps){
			List<Card> vic = new ArrayList<Card>();
			List<Card> oppHand = opp.getHand();
			for(int i = 0; i < oppHand.size(); i++){
				Card c = oppHand.get(i);
				if(c instanceof Victory){
					vic.add(c);
				}
			}
			if(vic.size() != 0){
				//TODO: May not want same logic as discard
				List<Card> cardToDiscard = opp.getGamePlan().chooseCardsToDiscard(1, 0, true, vic);
				opp.moveCard(opp.getHand(), opp.getDeck(), cardToDiscard.get(0));
			} else {
				//Reveal hand!
			}
		}
	}
}
