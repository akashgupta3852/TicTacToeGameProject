package com.bridgelabz.tictactoe;

public class TicTacToe {
	private static char[] board = new char[10];	
	
	public void assignEmptySpace() {
		for(int i=1;i<10;i++) {
			board[i] = ' ';
		}
		
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Toe Game");
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.assignEmptySpace();
	}

}
