package com.bridgelabz.tictactoe;

import java.util.*;

public class TicTacToe {
	private static char[] board = new char[10];

	// UC1
	public void assignEmptySpaceToBoard() {
		for (int position = 0; position < 10; position++)
			board[position] = ' ';
	}

	// UC2
	public char chooseXOrO(Scanner input) {
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
		System.out.println("\nEnter the position where you want to put a letter");
		int position = input.nextInt();
		if (board[position] == ' ') {
			char option = chooseXOrO(input);
			board[position] = option;
		} else {
			System.out.println("User can't move to the position: " + position);
		}
	}

	// UC5
	public void checkFreeSpace(Scanner input) {
		while (true) {
			for (int position = 0; position < 10; position++) {
				if (board[position] == ' ') {
					userMove(input);
					showBoard();
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.assignEmptySpaceToBoard();
		Scanner input = new Scanner(System.in);
		char userInput = ticTacToe.chooseXOrO(input);
		char computerInput = (userInput == 'X') ? 'O' : 'X';
		System.out.println("User Input :" + userInput);
		System.out.println("Computer Input :" + computerInput);
		ticTacToe.userMove(input);
		ticTacToe.showBoard();
		ticTacToe.checkFreeSpace(input);
	}
}
