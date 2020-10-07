package com.bridgelabz.tictactoe;

import java.util.*;

public class TicTacToe {
	private final static int USER = 0, COMPUTER = 1;
	private static char[] board = new char[10];

	// UC1
	public void assignEmptySpaceToBoard() {
		for (int position = 1; position < 10; position++)
			board[position] = ' ';
	}

	// UC2
	public char chooseSymbol(Scanner input) {
		while (true) {
			System.out.println("Choose the letter X or O");
			char option = input.next().charAt(0);
			if (option == 'X' || option == 'O')
				return option;
			else {
				System.out.println("Sorry, the option: " + option + " is not available.");
				continue;
			}
		}
	}

	// UC3
	public void showBoard() {
		for (int rowPositon = 1; rowPositon < 10; rowPositon = rowPositon + 3) {
			for (int columnPositon = rowPositon; columnPositon <= rowPositon + 2; columnPositon++) {
				System.out.print(board[columnPositon]);
				if (columnPositon != rowPositon + 2)
					System.out.print(" | ");
				if (columnPositon == 9)
					rowPositon = 0;
			}
			if (rowPositon == 0)
				break;
			if (rowPositon != rowPositon + 2)
				System.out.println("\n_________\n");
		}
	}

	// UC4
	public void userMove(Scanner input) {
		System.out.println("Enter the position where you want to put a letter");
		int position = input.nextInt();
		if (position < 1 || position > 9)
			System.out.println("This is wrong position.");
		else if (board[position] == ' ') {
			char option = chooseSymbol(input);
			board[position] = option;
		} else {
			System.out.println("User can't move to the position: " + position);
		}
	}

	// UC5
	public List<Integer> checkFreeSpace() {
		List<Integer> freeIndexList = new ArrayList<>();
		for (int position = 0; position < 10; position++) {
			if (board[position] == ' ') {
				freeIndexList.add(position);
			}
		}
		return freeIndexList;
	}
	
	

	// UC6
	public void tossToDecidePlayer() {
		int check=(int)Math.floor(Math.random()*10)%2;
		switch(check) {
		case USER:
			System.out.println("User is playing now");
			break;
		case COMPUTER:
			System.out.println("Computer is playing now");
			break;
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.tossToDecidePlayer();
		ticTacToe.assignEmptySpaceToBoard();
		Scanner input = new Scanner(System.in);
		ticTacToe.userMove(input);
		ticTacToe.showBoard();
		System.out.println("");
		System.out.println("The free index(es) are: "+ticTacToe.checkFreeSpace());
	}
}
