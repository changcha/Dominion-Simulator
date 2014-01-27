package game;

import java.util.*;

import cards.Card;
import cards.CardFactory;

public class Supply {

	private List<Card> trash;
	private Map<String, Card> piles = new HashMap<String, Card>();
	private Card lastTrashed;
	
	public Supply(){
		trash = new ArrayList<Card>();
		//Set piles.
	}
	
	public List<Card> getTrash() {
		return trash;
	}

	public void addToTrash(Card card){
		trash.add(card);
		lastTrashed = card;
	}
	
	public void addToTrash(List<Card> cards){
		for(Card card: cards){
			addToTrash(card);
		}
	}

	public Card getCard(String name) {
		return CardFactory.getCard(name); //Incorrect implementation for now. Just getting it to work.
	}
	
	public List<Card> getCardList(){
		//TODO: Actually implement this. Just using for tests now. 
		List<Card> list = new ArrayList<Card>();
		list.add(getCard("Copper"));
		list.add(getCard("Gold"));
		return list;
	}
	
	public Card getLastTrashed(){
		return lastTrashed; 
	}
}
