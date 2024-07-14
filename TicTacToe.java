package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
	
	Scanner s = new Scanner(System.in); 
	
	private Player A;
	private Player B;	
	private Board board;
	private Player currPlayer; 

	public TicTacToe() {
		System.out.println("Hello, and welcome to TicTacToe");
	}
	
	public void play() {
		
		initializePlayers(); 
		initializeBoard(); 
		printInstructions(); 
		
		currPlayer = B; 
		
		while(true) {
			switchPlayers(); 
			if(board.count==board.n*board.n) {
				System.out.println("GAME TIED");
				return; 
			}
			System.out.println(currPlayer.getName()+"'s turn:");
			if(boardInput()) {
				break; 
			}
		}
		
		//RESULTS
		System.out.println("GAME OVER");
		System.out.println(currPlayer.getName()+" WINS!!!");
		
	}


	private boolean boardInput() {
		System.out.print("Enter row and column: ");
		
		int row = s.nextInt(); 
		int column = s.nextInt(); 
		
		while(row<1||column<1||row>board.n||column>board.n||board.getChar(row-1, column-1)!=' ') {
			if(row<1||column<1||row>board.n||column>board.n) {
				System.out.println("Your input is out of bounds, try again");
			}else {
				System.out.println("The cell entered is already occupied, try again");
			}
			System.out.print("Enter row and column: ");
			row = s.nextInt(); 
			column = s.nextInt(); 
		}
		
		board.input(row, column, currPlayer.getSymbol()); 
		
		board.printBoard(); 
		
		return board.isFinished(row-1, column-1); 
	}


	private void switchPlayers() {
		if(currPlayer==A) {
			currPlayer = B; 
		}else {
			currPlayer = A; 
		}
	}


	private void printInstructions() {
		
		System.out.println("RULES: ");
		System.out.println("When its your turn, enter row and column of the cell where you would like to place your symbol");
		System.out.println("Please note that the row/column ranges from 1 to "+board.n);
		System.out.println("\n\nGOOD GAME!!!\n\n");
		
	}


	private void initializeBoard() {
		
		System.out.print("Please enter your desired board size: ");
		int size = s.nextInt(); 
		board = new Board(size);
		
	}


	private void initializePlayers() {
		
		//Pick Names
			System.out.println("Please enter your names:");
			
			System.out.print("Player 1: ");
			A = new Player(s.nextLine());
			
			System.out.print("Player 2: ");
			B = new Player(s.nextLine());
			
			//Pick Symbols
			System.out.print(A.getName()+", please pick a symbol between X or 0: ");
			
			while(!A.setSymbol(s.next().charAt(0))) {
				System.out.println("Sorry, the symbol entered is not X or 0, try again");
				System.out.print("Please pick a symbol between X or 0: ");
			}
			
			if(A.getSymbol()=='X') {
				B.setSymbol('0'); 
			}else {
				B.setSymbol('X'); 
			}
			
			//Display Names and Symbols
			System.out.println(A.getName()+": "+A.getSymbol());
			System.out.println(B.getName()+": "+B.getSymbol());
	
	}

	

}
