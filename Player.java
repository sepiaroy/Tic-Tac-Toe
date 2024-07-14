package TicTacToe;

public class Player {
	
	private String name; 
	private char symbol; 
	
	public Player(String str) {
		name = str; 
	}
	
	public boolean setSymbol(char ch) {
		if(ch=='0'||ch=='X') {
			symbol = ch; 
			return true; 
		}else {
			return false; 
		}
	}
	
	public char getSymbol() {
		return symbol; 
	}
	
	public String getName() {
		return name; 
	}

}
