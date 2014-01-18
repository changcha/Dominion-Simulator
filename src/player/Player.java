package player;

import game.Supply;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import cards.Card;
import cards.CardFactory;
import cards.Treasure;

public class Player {

	protected List<Card> hand;
	protected Stack<Card> deck;
	protected List<Card> discard;
	protected Stack<Card> reveal;
	protected List<Card> play;
	protected GamePlan plan;
	protected Supply supply;
	protected Player[] opponents;
	
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
	
	public void shuffle(){
		int size = discard.size();
		Random random = new Random();
		for(int i = 0; i < size; i++){
			deck.push(discard.remove(random.nextInt(discard.size())));
		}
	}
	
	public void drawHand(){
		drawCards(5);
	}
	
	public List<Card> getHand(){
		return hand;
	}
	
	public List<Card> getDiscard(){
		return discard;
	}
	
	public List<String> mayTrashCards(int limit){
		//Returns the name of trashed cards
		int val = new Random().nextInt(Math.max(limit, getHand().size()));
		return trashCards(val);
	}
	
	public List<String> trashCards(int limit){
		List<String> trashed = plan.chooseCardsToTrash(limit);
		for(int i = 0; i < trashed.size(); i++){
			for(Card c: hand){
				if(c.getName().equals(trashed.get(i))){
					supply.addToTrash(c);
					hand.remove(c);
					break;
				}
			}
		}
		return trashed;
	}

	public void drawCards(int draw) {
		for(int i = 0; i < draw; i++){
			if(deck.isEmpty()){
				shuffle();
			}
			hand.add(deck.pop());
		}
	}

	public void addToHand(Card card){
		hand.add(card);
	}
	
	public void revealHand(){
		reveal.addAll(hand);
	}
	
	public Card revealCardsFromDeck(){
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

	public Stack<Card> getDeck() {
		return deck;
	}
	
	public int getActions(){
		return actionCount;
	}
	
	public void modifyActions(int val){
		actionCount += val;
	}
	
	public void playTreasures(){
		List<Treasure> treasures = plan.chooseTreasuresToPlay();
		int sum = 0;
		for(Treasure t: treasures){
			sum += t.getValue();
		}
		modifyTreasures(sum);
	}
	
	public GamePlan getGamePlan(){
		return plan;
	}
	
	public void setGamePlan(GamePlan plan){
		this.plan = plan;
	}
	
	public List<String> discardCards(int limit){
		List<String> discarded = plan.chooseCardsToDiscard(limit);
		for(int i = 0; i < discarded.size(); i++){
			for(Card c: hand){
				if(c.getName().equals(discarded.get(i))){
					discard.add(c);
					hand.remove(c);
					break;
				}
			}
		}
		return discarded;
	}

	public void moveCardToPlay(Card c) {
		hand.remove(c);
		play.add(c);
	}
	
	public void modifyTreasures(int amount){
		treasureCount += amount;
	}
	
	public int getTreasure(){
		return treasureCount;
	}
	
	public void discardDeck(){
		discard.addAll(deck);
		deck = new Stack<Card>();
	}
	
	public int getBuyCount(){
		return buyCount;
	}
	
	public Player[] getOpponents(){
		return opponents;
	}
	
	public void modifyBuys(int buys){
		buyCount += buys;
	}
	
	public Card gainCard(int amount){
		String name = plan.chooseCardToGain(amount);
		Card card = supply.getCard(name);
		discard.add(card);
		return card;
	}
	
	public Card buyCard(int buys, int coin){
		return null;
	}
}
