package player;

import game.Supply;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import cards.Action;
import cards.Card;
import cards.CardFactory;
import cards.Treasure;

public class Player {

	private List<Card> hand;
	private List<Card> discard;
	private List<Card> play;
	
	private Stack<Card> deck;
	private Stack<Card> reveal;
	
	private GamePlan plan;
	private Supply supply;
	private Player[] opponents;
	
	private int actionCount;
	private int buyCount;
	private int treasureCount;
	
	public Player(){
		this(null, null, null);
	}
	
	public Player(Supply s, Player[] opponents){
		this(null, s, opponents);
	}
	
	public Player(GamePlan plan, Supply supply, Player[] opponents){
		this.plan = plan;
		this.supply = supply;
		this.opponents = opponents;
		play = new ArrayList<Card>();
		deck = new Stack<Card>();
		discard = new ArrayList<Card>();
		reveal = new Stack<Card>();
		Card c = CardFactory.getCard("Copper");
		Card e = CardFactory.getCard("Estate");
		for(int i = 0; i < 7; i++){
			if(i < 3)
				discard.add(e);
			discard.add(c);
		}
		hand = new ArrayList<Card>();
		shuffle();
		drawHand();
	}
	
	/********CARD MANAGEMENT********/
	public void shuffle(){
		int size = discard.size();
		Random random = new Random();
		for(int i = 0; i < size; i++){
			deck.push(discard.remove(random.nextInt(discard.size())));
		}
	}
	
	public void addToHand(Card card){
		hand.add(card);
	}

	public Card buyCard(int buys, int coin){
		return null;
	}
	
	public void drawHand(){
		drawCards(5);
	}
	
	public void drawCards(int draw) {
		for(int i = 0; i < draw; i++){
			if(deck.isEmpty()){
				shuffle();
			}
			hand.add(deck.pop());
		}
	}
	
	public Card gainCard(int amount){
		String name = plan.chooseCardToGain(amount, supply);
		Card card = supply.getCard(name);
		discard.add(card);
		return card;
	}
	
	private List<Card> removeCards(List<Card> from, List<String> toRemove){
		List<Card> removed = new ArrayList<Card>();
		for(int i = 0; i < toRemove.size(); i++){
			Iterator<Card> it = from.iterator();
			while(it.hasNext()){
				Card c = it.next();
				if(c.getName().equals(toRemove.get(i))){
					removed.add(c);
					it.remove();
					break;
				}
			}
		}
		System.out.println(removed);
		return removed;
	}
	
	//Assumed card was from Hand for now
	public String trashCard(Card c){
		hand.remove(c);
		supply.addToTrash(c);
		return c.getName();
	}
	
	public List<String> trashCardsFromHand(int limit, boolean exact){
		List<String> trashed = plan.chooseCardsToTrash(limit, exact, hand);
		supply.getTrash().addAll(removeCards(hand, trashed));
		return trashed;
	}
	
	public List<String> discardCardsFromHand(int limit, boolean exact){
		List<String> discarded = plan.chooseCardsToDiscard(limit, exact, hand);
		discard.addAll(removeCards(hand, discarded));
		return discarded;
	}
	
	public void revealHand(){
		reveal.addAll(hand);
	}
	
	public Card revealCardFromDeck(){
		Card card = deck.pop();
		reveal.push(card);
		return card;
	}
	
	public void removeFromReveal(Card card){
		reveal.remove(card);
	}
	
	public void discardReveal(){
		discard.addAll(reveal);
		reveal = new Stack<Card>();
	}
	
	public boolean noCardsAvailable(){
		return deck.isEmpty() && discard.isEmpty();
	}
	
	public void playTreasures(){
		List<Treasure> treasures = plan.chooseTreasuresToPlay();
		int sum = 0;
		for(Treasure t: treasures){
			sum += t.getValue();
		}
		modifyTreasures(sum);
	}
	
	public boolean playAction(){
		if(getActionCount() > 0){
			Action action = plan.chooseActionToPlay();
			if(action != null){
				action.execute(this);
				return true;
			}
		}
		return false;
	}

	public void moveCardToPlay(Card c) {
		hand.remove(c);
		play.add(c);
	}

	public void discardDeck(){
		discard.addAll(deck);
		deck = new Stack<Card>();
	}
	
	/********GETTERS/SETTERS********/
	public List<Card> getHand(){
		return hand;
	}
	
	public List<Card> getDiscard(){
		return discard;
	}
	
	public Stack<Card> getDeck() {
		return deck;
	}
	
	public Player[] getOpponents(){
		return opponents;
	}
	
	public int getActionCount(){
		return actionCount;
	}
	
	public int getBuyCount(){
		return buyCount;
	}
	
	public int getTreasureCount(){
		return treasureCount;
	}
	
	public GamePlan getGamePlan(){
		return plan;
	}
	
	public void setGamePlan(GamePlan plan){
		this.plan = plan;
	}
	
	/********TURN COUNTERS********/
	public void modifyTreasures(int amount){
		treasureCount += amount;
	}
	
	public void modifyBuys(int buys){
		buyCount += buys;
	}
	
	public void modifyActions(int val){
		actionCount += val;
	}
	
	public void resetCounters(){
		treasureCount = 0;
		buyCount = 0;
		actionCount = 0;
	}
}
