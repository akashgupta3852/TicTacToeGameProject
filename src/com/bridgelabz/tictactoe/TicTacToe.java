package com.bridgelabz.tictactoe;

import java.util.*;

public class TicTacToe {
	private final static int HEAD = 0, TAIL = 1;
	private static char[] board = new char[10];
	private static String player;

	// UC1 - Assigning empty space to the board
	public void assignEmptySpaceToBoard() {
		for (int position = 1; position < 10; position++)
			board[position] = ' ';
	}

	// UC2 - Deciding the symbols of user and computer
	public char chooseSymbol(Scanner input) {
		while (true) {
			System.out.println("Choose the letter X or O");
			char option = input.next().charAt(0);
			if (option == 'X') {
				System.out.println("X = User");
				System.out.println("O = Computer");
				return option;
			} else if (option == 'O') {
				System.out.println("O = User");
				System.out.println("X = Computer");
				return option;
			} else {
				System.out.println("Sorry, the option: " + option + " is not available.");
				continue;
			}

		}
	}

	// UC3 - Displaying the game board
	public void showBoard() {
		for (int rowPositon = 1; rowPositon < 10; rowPositon = rowPositon + 3) {
			for (int columnPositon = rowPositon; columnPositon <= rowPositon + 2; columnPositon++) {
				System.out.print(board[columnPositon]);
				if (columnPositon != rowPositon + 2)
					System.out.print(" | ");
				if (columnPositon == 9)
					rowPositon = 0;
			}
			if (rowPositon == 0) {
				System.out.print("\n");
				break;
			}
			if (rowPositon != rowPositon + 2)
				System.out.println("\n_________\n");
		}
	}

	// UC4 - Entering position where user can move
	public void userMove(Scanner input, char option) {
		while (true) {
			System.out.println("Enter the position where you want to put a letter:");
			int position = input.nextInt();
			if (position < 1 || position > 9) {
				System.out.println("This is wrong position.");
				continue;
			} else if (board[position] == ' ') {
				board[position] = option;

				break;
			} else {
				System.out.println("User can't move to the position: " + position);
				continue;
			}
		}
	}

	// UC5 - Checking free space for which user can move
	public void checkFreeSpace(Scanner input, char option) {

		for (int position = 1; position < 10; position++) {
			if (board[position] == ' ') {
				if (player.equals("User")) {
					userMove(input, option);
					showBoard();
					player = "Computer";
					if (isWinner(option)) {
						System.out.println("User is winner");
						break;
					}
				}
				if (player.equals("Computer")) {
					if (computerMove(option))
						break;
					else {
						showBoard();
						player = "User";
					}

				}
				position = 1;
			}
		}
	}

	// UC6 - Deciding the player who plays first
	public int tossToDecideFirstPlayer() {
		int toss = (int) Math.floor(Math.random() * 10) % 2;
		switch (toss) {
		case HEAD:
			System.out.println("User is playing first.");
			break;
		case TAIL:
			System.out.println("Computer is playing first.");
			return TAIL;
		}
		return HEAD;
	}

	// UC7 - Checking the winner
	public boolean isWinner(char option) {
		return (board[1] == board[2] && board[2] == board[3] && board[3] == option
				|| board[4] == board[5] && board[5] == board[6] && board[6] == option
				|| board[7] == board[8] && board[8] == board[9] && board[9] == option
				|| board[1] == board[5] && board[5] == board[9] && board[9] == option
				|| board[3] == board[5] && board[5] == board[7] && board[7] == option
				|| board[1] == board[4] && board[4] == board[7] && board[7] == option
				|| board[2] == board[5] && board[5] == board[8] && board[8] == option
				|| board[3] == board[6] && board[6] == board[9] && board[9] == option);
	}

	// UC8 - Computer plays
	private boolean computerMove(char option) {
		while (true) {
			int computerPosition = block(option);
			option = (option == 'X') ? 'O' : 'X';
			if (computerPosition != 0) {
				if (board[computerPosition] == ' ') {
					board[computerPosition] = option;
					System.out.println("Computer moved at the position: " + computerPosition + " to block the user");
					if (isWinner(option)) {
						showBoard();
						System.out.println("Computer is winner");
						return true;
					}
				}
			} else {
				computerPosition = moveCorner();
				if(computerPosition!=0) {
					board[computerPosition] = option;
				}	
				else {
					computerPosition = (int) Math.floor(Math.random() * 10) % 9 + 1;
					if (board[computerPosition] == ' ')
						board[computerPosition] = option;
					else {
						option = (option == 'X') ? 'O' : 'X';
						continue;
					}
				}
				System.out.println("Computer moved at the random position: " + computerPosition);
				if (isWinner(option)) {
					showBoard();
					System.out.println("Computer is winner");
					return true;
				}
			}
			return false;
		}
	}

	// UC9 - Blocking the opponent
	public int block(char option) {
		if (board[1] == board[2] && board[2] == option && board[3] ==' ')	return 3;
		else if (board[2] == board[3] && board[2] == option && board[1] ==' ')	return 1;
		else if (board[1] == board[3] && board[3] == option && board[2] ==' ')	return 2;
		else if (board[4] == board[5] && board[4] == option && board[6] ==' ')	return 6;
		else if (board[5] == board[6] && board[5] == option && board[4] ==' ')	return 4;
		else if (board[4] == board[6] && board[4] == option && board[5] ==' ')	return 5;
		else if (board[7] == board[8] && board[7] == option && board[9] ==' ')	return 9;
		else if (board[8] == board[9] && board[8] == option && board[7] ==' ')	return 7;
		else if (board[7] == board[9] && board[7] == option && board[8] ==' ')	return 8;
		else if (board[1] == board[5] && board[1] == option && board[9] ==' ')	return 9;
		else if (board[5] == board[9] && board[5] == option && board[1] ==' ')	return 1;
		else if (board[1] == board[9] && board[1] == option && board[5] ==' ')	return 5;
		else if (board[3] == board[5] && board[3] == option && board[7] ==' ')	return 7;
		else if (board[5] == board[7] && board[5] == option && board[3] ==' ')	return 3;
		else if (board[3] == board[7] && board[3] == option && board[5] ==' ')	return 5;
		else if (board[1] == board[4] && board[1] == option && board[7] ==' ')	return 7;
		else if (board[4] == board[7] && board[4] == option && board[1] ==' ')	return 1;
		else if (board[1] == board[7] && board[1] == option && board[4] ==' ')	return 4;
		else if (board[2] == board[5] && board[2] == option && board[8] ==' ')	return 8;
		else if (board[5] == board[8] && board[5] == option && board[2] ==' ')	return 2;
		else if (board[2] == board[8] && board[2] == option && board[5] ==' ')	return 5;
		else if (board[3] == board[6] && board[3] == option && board[9] ==' ')	return 9;
		else if (board[6] == board[9] && board[6] == option && board[3] ==' ')	return 3;
		else if (board[3] == board[9] && board[3] == option && board[6] ==' ') return 6;
		return 0;
	}
	
	// UC10 - Moving to the corner position if available
	public int moveCorner() {
		if(board[1] == ' ')
			return 1;
		else if(board[3] == ' ')
			return 3;
		else if(board[7] == ' ')
			return 7;
		else if(board[9] == ' ')
			return 9;
		return 0;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.assignEmptySpaceToBoard();
		System.out.println("The board initally is:");
		ticTacToe.showBoard();
		Scanner input = new Scanner(System.in);
		char option = ticTacToe.chooseSymbol(input);
		int toss = ticTacToe.tossToDecideFirstPlayer();
		if (toss == HEAD)
			player = "User";
		else
			player = "Computer";
		ticTacToe.checkFreeSpace(input, option);
	}
}
