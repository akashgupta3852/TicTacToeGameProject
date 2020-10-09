package com.bridgelabz.tictactoe;

import java.util.*;

public class TicTacToe {
	private final static int HEAD = 0, TAIL = 1;
	private static char[] board = new char[10];
	private static String player;

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
			if (option == 'X') {
				System.out.println("User = X");
				return 'O';
			} else if (option == 'O') {
				System.out.println("User = O");
				return 'X';
			} else {
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
			if (rowPositon == 0) {
				System.out.print("\n");
				break;
			}
			if (rowPositon != rowPositon + 2)
				System.out.println("\n_________\n");
		}
	}

	// UC4
	public void userMove(Scanner input, char option) {
		System.out.println("Enter the position where you want to put a letter:");
		int position = input.nextInt();
		if (position < 1 || position > 9)
			System.out.println("This is wrong position.");
		else if (board[position] == ' ') {
			board[position] = option;
		} else {
			System.out.println("User can't move to the position: " + position);
		}
	}

	// UC5
	public void checkFreeSpace(Scanner input, char option) {
		for (int position = 0; position < 10; position++) {
			if (board[position] == ' ') {
				if (option == 'X')
					option = 'O';
				else
					option = 'X';
				userMove(input, option);
				showBoard();
				if (isWinner(option)) {
					System.out.println(option + " is winner");
					break;
				}
				position = 0;
			}
		}
		System.out.println("Tie: no one won");
	}

	// UC6
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

	// UC7
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

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.assignEmptySpaceToBoard();
		int toss = ticTacToe.tossToDecideFirstPlayer();
		if (toss == HEAD)
			player = "User";
		else
			player = "Computer";

		Scanner input = new Scanner(System.in);
		char option = ticTacToe.chooseSymbol(input);
		ticTacToe.showBoard();
		ticTacToe.checkFreeSpace(input, option);
	}
}
