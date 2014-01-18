package cards;

import game.Supply;
import player.Player;

public class Action extends Card{
	
	protected int action;
	protected int buy;
	protected int coin;
	protected int draw;
	
	public Action(int cost, String name) {
		this(cost, name, 0, 0, 0, 0);
	}
	
	public Action(int cost, String name, int action, int buy, int coin, int draw){
		super(cost, name);
		this.action = action;
		this.buy = buy;
		this.coin = coin;
		this.draw = draw;
	}
	
	public boolean isTerminal(){
		return getAction() == 0;
	}
	
	public void execute(Player p, Supply s){
		p.modifyActions(getAction());
		p.modifyBuys(getBuy());
		p.modifyTreasures(getTreasure());
		p.drawCards(getDraw());
	}
	
	public int getAction(){
		return action;
	}
	
	public int getBuy(){
		return buy;
	}
	
	public int getTreasure(){
		return coin;
	}
	
	public int getDraw(){
		return draw;
	}
}
