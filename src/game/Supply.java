package game;

import java.util.*;

import cards.Card;
import cards.CardFactory;

public class Supply {

	private List<Card> trash;
	private Map<String, Card> piles = new HashMap<String, Card>();
	
	public Supply(){
		trash = new ArrayList<Card>();
		//Set piles.
	}
	
	public List<Card> getTrash() {
		return trash;
	}

	public void addToTrash(Card card){
		trash.add(card);
	}

	public Card getCard(String name) {
		return CardFactory.getCard(name); //Incorrect implementation for now. Just getting it to work.
	}
}
