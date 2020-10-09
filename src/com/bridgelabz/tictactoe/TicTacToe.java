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

	// UC5
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

	// UC8
	private boolean computerMove(char option) {
		while (true) {
			int computerPosition = (int) Math.floor(Math.random() * 10) % 9 + 1;
			if (board[computerPosition] == ' ') {
				option = (option == 'X') ? 'O' : 'X';
				board[computerPosition] = option;
				System.out.println("Computer moved at the position: " + computerPosition);
				if (isWinner(option)) {
					showBoard();
					System.out.println("Computer is winner");
					return true;
				}
				return false;
			}
		}
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
