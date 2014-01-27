package player;

import game.Supply;

import java.util.ArrayList;
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
		hand.addAll(drawCards(5));
		resetCounters();
	}
	
	/********CARD MANAGEMENT********/
	public void shuffle(){
		int size = discard.size();
		Random random = new Random();
		for(int i = 0; i < size; i++){
			deck.push(discard.remove(random.nextInt(discard.size())));
		}
	}

	public void moveCard(List<Card> from, List<Card> to, Card c){
		if(from.remove(c))
			to.add(c);
		else 
			throw new IllegalArgumentException("Can't remove card");
	}
	
	public void moveCards(List<Card> from, List<Card> to){
		if(from == null || to == null)
			throw new IllegalArgumentException();
		to.addAll(from);
		from.clear();
	}
	
	public List<Card> discard(int limit, int min, boolean exact, List<Card> from){
		List<Card> discarded = plan.chooseCardsToDiscard(limit, min, exact, from);
		removeCards(from, discarded);
		discard.addAll(discarded);
		return discarded;
	}
	
	public String discard(Card card){
		if(hand.remove(card))
			discard.add(card);
		else
			throw new IllegalArgumentException("Can't discard card from hand");
		return card.getName();
	}
	
	public List<Card> trash(int limit, int min, boolean exact, List<Card> from){
		List<Card> trashed = plan.chooseCardsToTrash(limit, min, exact, from);
		removeCards(from, trashed);
		supply.addToTrash(trashed);
		return trashed;
	}
	
	public String trash(Card card){
		if(hand.remove(card))
			supply.addToTrash(card);
		else
			throw new IllegalArgumentException("Can't trash card from hand");
		return card.getName();
	}
	
	private void removeCards(List<Card> from, List<Card> toRemove){
		for(int i = 0; i < toRemove.size(); i++){
			Card c = toRemove.get(i);
			if(!from.remove(c)){
				throw new IllegalArgumentException();
			}
		}
	}
	
	public List<Card> drawCards(int drawCount) {
		List<Card> drawn = new ArrayList<Card>();
		for(int i = 0; i < drawCount; i++){
			if(noCardsAvailable()){
				break;
			} else if(deck.isEmpty()){
				shuffle();
			}
			drawn.add(deck.pop());
		}
		return drawn; 
	}
	
	public void drawIntoHand(int drawCount){
		moveCards(drawCards(drawCount), hand);
	}
	
	public void gainCard(int amount, boolean exact){
		gainCard(amount, exact, discard);
	}
	
	public void gainCard(int amount, boolean exact, List<Card> to){
		String name = plan.chooseCardToGain(amount, exact, supply);
		Card card = supply.getCard(name);
		to.add(card);
	}
	
	public void gainCard(String name){
		gainCard(name, discard);
	}
	
	public void gainCard(String name, List<Card> to){
		to.add(supply.getCard(name));
	}
	
	public void buyCard(int coin, int buys){
		buyCard(coin, buys, discard);
	}
	
	public void buyCard(int coin, int buys, List<Card> to){
		List<Card> purchases = plan.chooseCardsToBuy(coin, buys);
		for(int i = 0; i < purchases.size(); i++){
			Card card = supply.getCard(purchases.get(i).getName());
			to.add(card);
		}
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
	
	public boolean actionPhase(){
		if(getActionCount() > 0){
			Action action = plan.chooseActionToPlay();
			if(action != null){
				action.execute(this);
				return true;
			}
		}
		return false;
	}
	
	public void buyPhase(){
		buyCard(getTreasureCount(), getBuyCount());
	}
	
	public void cleanupPhase(){
		moveCards(hand, discard);
		moveCards(play, discard);
		moveCards(reveal, discard);
		resetCounters();
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
	
	public List<Card> getReveal(){
		return reveal;
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
		buyCount = 1;
		actionCount = 1;
	}
}
