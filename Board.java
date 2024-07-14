package TicTacToe;

public class Board {
	
	private char[][] board; 
	public int count; 
	public int n; 
	
	public Board(int size) {
		n = size; 
		board = new char[n][n]; 
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				board[i][j] = ' '; 
			}
		}
		count = 0; 
	}
	
	public void input(int row, int column, char ch) {
		board[row-1][column-1]=ch;
		count++; 
	}

	public void printBoard() {
		System.out.print("\n   ");
		for(int i = 1; i<=n; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		for(int i = 0; i<n; i++) {
			System.out.print(i+1+" ");
			for(int j = 0; j<n; j++) {
				System.out.print("|"+board[i][j]);
			}
			System.out.println("|");
		}
		System.out.println("\n");
	}

	public boolean isFinished(int row, int column) {
		//Check Horizontal
		int j = 0; 
		for(j = 0; j<n; j++) {
			char ch = board[row][0]; 
			if(board[row][j]==' ') {
				break; 
			}
			if(board[row][j]!=ch) {
				break; 
			}
		}
		if(j==n) {
			return true; 
		}
		
		//Check Vertical
		int i = 0; 
		for(i = 0; i<n; i++) {
			char ch = board[0][column]; 
			if(board[i][column]==' ') {
				break; 
			}
			if(board[i][column]!=ch) {
				break; 
			}
		}
		if(i==n) {
			return true; 
		}
		
		//Check diagonal 1
		if(row==column) {
			char ch = board[0][0]; 
			for(i = 0; i<n; i++) {
				if(board[i][i]==' ') {
				break; 
				}
				if(board[i][i]!=ch) {
					break; 
				}
			}
			if(i==n) {
				return true; 
			}
		}
		
		//Check diagonal 2
		j = n-1; 
		char ch = board[0][n-1]; 
		boolean present = false; 
		for(i = 0, j = n-1; i<n&&j>=0; i++, j--) { 
			if(i==row&&j==column) {
				present = true; 
			}
			if(board[i][j]==' ') {
				break; 
			}
			if(board[i][j]!=ch) {
				break; 
			}
		}
		if(i==n&&present) {
			return true; 
		}
		
		return false; 
		
	}

	public char getChar(int i, int j) {
		return board[i][j];
	}

}
