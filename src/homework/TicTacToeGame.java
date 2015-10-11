//Chayala Glazer

package homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGame {

	/**
	 * This program will create a Tic Tac Toe Game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		instructions();// call a method to display the instructions of the game
		String playAgain;
		boolean set = false;

		do {
			boolean repeat = false;
			char[][] board = new char[3][3];// create a two dimensional array
			for (int i = 0; i < 5; i++) {
				// each player gets to see the board, and choose where to place
				// his token. If he didn't create a set, then the next player
				// gets a turn.
				char player = 'X';

				showBoard(board);
				do {
					repeat =false;
					//ensure that the player entered an integer value
					try {
						board = menu(player, board);
					} catch (InputMismatchException e) {
						System.out
								.println("Input not valid. Please enter an integer value.");
						repeat = true;
					}
				} while (repeat);
				set = checkSet(board);
				if (set) {
					showBoard(board);
					System.out.println("Player " + player + " won!");
					break;
				} else if (i == 4) {
					showBoard(board);
					System.out
							.println("Sorry, there is no winner to this game!");
					break;
				}
				player = 'O';

				showBoard(board);
				do{
					repeat = false;
					//ensure that the player entered an integer value
				try {
					board = menu(player, board);
				} catch (InputMismatchException e) {
					System.out
							.println("Input not valid. Please enter an integer value.");
					repeat = true;
				}
				}while(repeat);
				set = checkSet(board);
				if (set) {
					showBoard(board);
					System.out.println("Player " + player + " won!");
					break;
				}
			}
			// call a method to ask the player if he wants to play again
			playAgain = playAgainMenu();
		} while (playAgain.equalsIgnoreCase("Y"));
		System.out.println("Thank you for playing!");
	}

	/**
	 * This method will display the instructions of the game.
	 */

	public static void instructions() {
		System.out
				.println("You will be playing a Tic Tac Toe game. This game is meant for two players. The first player will be ");
		System.out
				.println("X and the second player will be O.  The players will take turns to choose the row and column on the board that they wish");
		System.out
				.println("to place their token. The goal of the game is to 3 of your tokens in a horizontal, vertical or diagnal row. \n");
	}

	/**
	 * This method will show a picture of what the tic tac toe board looks like
	 * as the game goes on and the players place their tokens around the board.
	 * 
	 * @param board
	 *            - The two dimesional array that holds the values of the tic
	 *            tac toe board
	 */

	public static void showBoard(char[][] board) {
		// picture of board
		for (int i = 0; i < board.length; i++) {
			System.out.println("-------------");
			System.out.println("| " + board[i][0] + " | " + board[i][1] + " | "
					+ board[i][2] + " |");
		}
		System.out.println("-------------");
	}

	/**
	 * This method will ask the player which row & column he wishes to place his
	 * token.
	 * 
	 * @param player
	 *            - the current player
	 * @param board
	 *            - the two dimensional array that holds the values of the tic
	 *            tac toe board
	 * @return - the updated two dimensional array that holds the values of the
	 *         tic tac toe board
	 */
	public static char[][] menu(char player, char board[][]) {
		// create a scanner object to read in the players input
		Scanner keyboard = new Scanner(System.in);
		
		

		System.out
				.print("Enter a row (0, 1, or 2) for player " + player + ": ");

		int row = keyboard.nextInt();
		// input validation
		while (!(row == 0 || row == 1 || row == 2)) {

			System.out
					.print("Input not valid. Enter a row (0, 1, or 2) for player "
							+ player + ": ");
			 row = keyboard.nextInt();

		}
		System.out.print("Enter a column (0, 1, or 2) for player " + player
				+ ": ");
		int column = keyboard.nextInt();
		// input validation
		while (!(column == 0 || column == 1 || column == 2)) {
			System.out
					.print("Input not valid. Enter a column (0, 1, or 2) for player "
							+ player + ": ");
			column = keyboard.nextInt();
		}
		// check if this space was already filled.
		while (board[row][column] == 'X' || board[row][column] == 'O') {
			System.out.println("\nSorry this space is already filled.");
			System.out.print("Enter a row (0, 1, or 2) for player " + player
					+ ": ");
			row = keyboard.nextInt();
			while (!(row == 0 || row == 1 || row == 2)) {
				System.out
						.print("Input not valid. Enter a row (0, 1, or 2) for player "
								+ player + ": ");
				row = keyboard.nextInt();
			}
			System.out.print("Enter a column (0, 1, or 2) for player " + player
					+ ": ");
			column = keyboard.nextInt();
			while (!(column == 0 || column == 1 || column == 2)) {
				System.out
						.print("Input not valid. Enter a column (0, 1, or 2) for player "
								+ player + ": ");
				column = keyboard.nextInt();
			}
		}

		// place the player's token in the desired spot
		board[row][column] = player;
		return board;
	}

	/**
	 * This method will check if any of the players made a vertical, horizontal,
	 * or diagnal row of their tokens
	 * 
	 * @param board
	 *            - the two dimensional array that holds the values of the tic
	 *            tac toe board
	 * @return a boolean variable stating whether or no a set has been found or
	 *         not
	 */
	public static boolean checkSet(char board[][]) {
		boolean set = false;
		for (int i = 0; i < board.length; i++) {
			// check for a horizontal row
			if (board[i][0] == 'X' || board[i][0] == 'O') {
				if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
					set = true;
					break;
				}
			}
			// check for a vertical row
			if (board[0][i] == 'X' || board[0][i] == 'O') {
				if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
					set = true;
					break;
				}
			}
		}
		// check for diagnal rows
		if (board[0][0] == 'X' || board[0][0] == 'O') {
			if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
				set = true;
			}
		}
		if (board[0][2] == 'X' || board[0][2] == 'O') {
			if (board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
				set = true;
			}
		}
		return set;
	}

	/**
	 * This method will ask the player if he wants to play again.
	 * 
	 * @return A value indicating whether or not they'd like to play agian.
	 */
	public static String playAgainMenu() {
		// create a scanner object to recieve input
		Scanner keyboard = new Scanner(System.in);
		System.out
				.print("Would you like to play again? Press Y to play again or any key to exit.");
		String playAgain = keyboard.nextLine();
		return playAgain;
	}
}
