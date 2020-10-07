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
		System.out.println("Choose the letter X or O");
		char option = input.next().charAt(0);
		return option;
	}

	// UC3
	public void showBoard() {
		for (int rowPositon = 1; rowPositon <= 3; rowPositon++) {
			for (int columnPositon = 1; columnPositon <= 3; columnPositon++) {
				System.out.print(board[columnPositon]);
				if (columnPositon != 3)
					System.out.print(" | ");
			}
			if (rowPositon != 3)
				System.out.println("\n_________\n");
		}
	}

	// UC4
	public void userMove(Scanner input) {
		System.out.println("\nEnter the position where you want to put a letter");
		int position = input.nextInt();
		if (board[position] == ' ') {
			System.out.println("Enter the letter which you want to put");
			char option = input.next().charAt(0);
			board[position] = option;
		} else {
			System.out.println("User can't move to the " + position);
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
		ticTacToe.showBoard();
		ticTacToe.userMove(input);
	}
}
