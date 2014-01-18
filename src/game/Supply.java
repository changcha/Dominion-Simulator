package game;

import java.util.*;
import java.util.List;

import cards.Card;

public class Supply {

	private List<Card> trash;
	private Map<String, Card> piles = new HashMap<String, Card>();
	
	public Supply(){
		trash = new ArrayList<Card>();
	}
	
	public List<Card> getTrash() {
		return trash;
	}

	public void addToTrash(Card card){
		trash.add(card);
	}

	public Card getCard(String name) {
		return piles.get(name);
	}
}
