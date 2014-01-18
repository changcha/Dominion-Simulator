package cards;

import java.util.HashMap;
import java.util.Map;

import cards.base.*;
import cards.dominion.*;
import cards.base.Copper;

public class CardFactory {
	
	private static Map<String, Card> cards;
	
	static {
		cards = new HashMap<String, Card>();
		cards.put("Copper", new Copper(0, "Copper"));
		cards.put("Silver", new Silver(3, "Silver"));
		cards.put("Gold", new Gold(6, "Gold"));
		cards.put("Estate", new Estate(2, "Estate"));
		cards.put("Duchy", new Duchy(5, "Duchy"));
		cards.put("Province", new Province(8, "Province"));
		cards.put("Adventurer", new Adventurer(6, "Adventurer", 0, 0, 0, 0));
		cards.put("Bureaucrat", new Bureaucrat(4, "Bureaucrat", 0, 0, 0, 0));
		cards.put("Cellar", new Cellar(2, "Cellar", 1, 0, 0, 0));
		cards.put("Chancellor", new Chancellor(3, "Chancellor", 0, 0, 2, 0));
		cards.put("Chapel", new Chapel(2, "Chapel", 0, 0, 0, 0));
		cards.put("CouncilRoom", new CouncilRoom(5, "CouncilRoom", 0, 1, 0, 4));
		cards.put("Feast", new Feast(4, "Feast", 0, 0, 0, 0));
		cards.put("Festival", new Festival(5, "Festival", 2, 1, 2, 0));
		
		//case "CouncilRoom": return new CouncilRoom(4, name);
				//case "Feast": return new Feast(4, name);
				//case "Festival": return new Festival(5, name);
				//case "Gardens": return new Gardens(4, name);
				//case "Laboratory": return new Laboratory(5, name);
				//case "Library": return new Library(5, name);
				//case "Market": return new Market(5, name);
				//case "Militia": return new Militia(4, name);
				//case "Mine": return new Mine(5, name);
				//case "Moat": return new Moat(2, name);
				//case "Moneylender": return new Moneylender(4, name);
				//case "Remodel": return new Remodel(4, name);
				//case "Smithy": return new Smithy(4, name);
				//case "Spy": return new Spy(4, name);
				//case "Thief": return new Thief(4, name);
				//case "ThroneRoom": return new ThroneRoom(4, name);
				//case "Village": return new Village(3, name);
				//case "Witch": return new Witch(5, name);
				//case "Woodcutter": return new Woodcutter(3, name);
				//case "Workshop": return new Workshop(3, name);
	}
	
	public static Card getCard(String name){
		return cards.get(name);
	}
}
