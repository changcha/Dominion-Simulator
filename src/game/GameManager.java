package game;
import player.Player;

public class GameManager {
	public static void main(String[] args){
		setupKingdom();
		Player[] players = createGamePlayers();
		int count = 0;
		while(!gameIsOver()){
			int playerTurn = count % players.length;
			Player currentPlayer = players[playerTurn];
			while(currentPlayer.actionPhase());
			currentPlayer.buyPhase();
			currentPlayer.cleanupPhase();
			count++;
		}
		reportGame(players);
	}
	
	public static void setupKingdom(){
		
	}
	
	public static Player[] createGamePlayers(){
		return null;
	}
	
	public static boolean gameIsOver(){
		return false;
	}
	
	public static void reportGame(Player[] players){
		
	}
}
