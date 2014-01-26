package cards;

public abstract class Card {
	
	protected int cost;
	protected String name;
	
	public Card(int cost, String name){
		this.cost = cost;
		this.name = name;
	}
	
	public int getCost(){
		return cost;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean equals(Card other){
		return other.getName() == this.getName();
	}
}
