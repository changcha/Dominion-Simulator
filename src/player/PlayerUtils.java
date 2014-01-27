package player;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.Treasure;

public class PlayerUtils {
	public static int countTreasures(List<Card> cards){
		int count = 0;
		for(int i = 0; i < cards.size(); i++){
			if(cards.get(i) instanceof Treasure){
				count++;
			}
		}
		return count;
	}
	
	public static int sumTreasures(List<Card> cards){
		int sum = 0;
		for(Card c: cards){
			if(c instanceof Treasure){
				sum += ((Treasure) c).getValue();
			}
		}
		return sum;
	}
	
	public static List<Card> getTreasures(List<Card> cards){
		List<Card> treasures = new ArrayList<Card>();
		for(Card c: cards){
			if(c instanceof Treasure){
				treasures.add(c);
			}
		}
		return treasures;
	}
}
