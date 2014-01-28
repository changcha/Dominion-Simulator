package player;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import game.Supply;

public class BasicBigMoney extends BasicGamePlan{

	@Override
	public List<Card> chooseCardsToBuy(int coin, int buys, Supply s){
		List<Card> cards = new ArrayList<Card>();
		while(coin >= 0 && buys >= 0){
			if(coin >= 8){
				cards.add(s.getCard("Province"));
			} else if(coin >= 6) {
				cards.add(s.getCard("Gold"));
			} else if(coin >= 3) {
				cards.add(s.getCard("Silver"));
			} else {
				buys = 0;
			}
			buys--;
			if(cards.size() > 0)
				coin -= cards.get(cards.size() - 1).getCost();
		}
		return cards;
	}
}
