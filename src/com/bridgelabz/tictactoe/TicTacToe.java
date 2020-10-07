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
		sc.close();
		return option;
	}
	
	//UC3
	public void showBoard() {
		for(int rowPositon=1;rowPositon<10;rowPositon++) {
			for(int columnPositon=1;columnPositon<=3;columnPositon++) {
				System.out.print(board[columnPositon]+" ");
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.assignEmptySpaceToBoard();
		char userInput = ticTacToe.chooseXOrO();
		char computerInput;
		if((userInput == 'X'))
			computerInput = 'O';
		else
			computerInput = 'X';
		
		ticTacToe.showBoard();
	}
}
