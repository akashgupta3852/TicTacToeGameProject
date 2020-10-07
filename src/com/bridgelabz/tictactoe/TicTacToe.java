package com.bridgelabz.tictactoe;
import java.util.*;

public class TicTacToe {
	private static char[] board = new char[10];	
	//UC1
	public void assignEmptySpaceToBoard() {
		for(int position=0;position<10;position++)
			board[position] = ' ';
	}
	//UC2
	public char chooseXOrO() {
		System.out.println("Choose the letter X or O");
		Scanner sc = new Scanner(System.in);
		char option = sc.next().charAt(0);
		return option;
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.assignEmptySpaceToBoard();
		char option = ticTacToe.chooseXOrO();
	}
}
