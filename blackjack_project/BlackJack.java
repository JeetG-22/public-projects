package blackjack_project;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BlackJack {

	// Instantiate Objects
	static ArrayList<Player> players = new ArrayList<Player>();
	static Deck deck = new Deck();
	static Scanner kbd = new Scanner(System.in);

	public static void main(String[] args) {
		String userInput;

		// Shuffle Deck
		deck.shuffle();

		// Introductory Game Text
		System.out.println("Welcome To BlackJack!");
		System.out.println("How many players?");
		int numPlayers = kbd.nextInt();

		// Initialize Player List
		for (int i = 0; i < numPlayers; i++) { // Last Index is Dealer
			System.out.println("Player " + (i + 1) + ": How much do you want to start with?");
			players.add(new Player(kbd.nextInt()));
		}

		// Dealer
		players.add(new Player());

		// Gives Cards to Players
		playerStartingCards();

		do {
			
			//Checks to see if player wants to reload money if they run out or leave the table
			reloadMoney();
			
			// Player Bets
			placingBets();

			// Players Turn
			playersTurn();

			// Dealers Turn
			if (!allPlayersBust()) { // Checks to see if dealers needs to play or not
				dealersTurn();
			}

			// Deciding the winner
			decideWinner();

			// Prints New Totals
			printPlayerNewTotals();

			// Ask to play again
			System.out.println("Do you want to play again? [Yes/No] : ");
			userInput = kbd.next();

			if (userInput.equalsIgnoreCase("Yes")) {
				// Reset Player's Hands and Shuffle Deck
				clearAllHands();
				deck.resetIndex();
				deck.shuffle();

				// Gives two new cards to the players
				playerStartingCards();
			}
		} while (userInput.equalsIgnoreCase("Yes"));
		kbd.close();
	}

	//Gives the user the option to reload with more money after they run out.
	//If they say no, they get kicked from the table
	public static void reloadMoney() {
		for (int i = 0; i < players.size() - 1; i++) {
			if (players.get(i).getMoney() <= 0) {
				System.out.println("Player " + (i + 1) + ": You have no money. Would you like to reload? [Yes/No]");
				String userInput = kbd.next();
				if(userInput.equalsIgnoreCase("Yes")) {
					double reloadMoney = 0;
					System.out.println("How much would you like to reload with?");
					reloadMoney = kbd.nextDouble();
					while(reloadMoney < 0) {
						System.out.println("Invalid Amount");
						System.out.println("How much would you like to reload with?");
						reloadMoney = kbd.nextDouble();
					}
					players.get(i).setMoney(reloadMoney);
				} else {
					players.remove(i);
				}
			}
		}
	}

	public static void clearAllHands() {
		for (int i = 0; i < players.size(); i++) {
			players.get(i).getHand().clearHand();
		}
	}

	public static void playerStartingCards() {
		int count = 0;
		while (count < 2) {
			for (int i = 0; i < players.size(); i++) {
				players.get(i).startRound(deck.getCard());
			}
			count++;
		}

	}

	public static void decideWinner() {
		System.out.println("Winner[s] : ");
		if (allPlayersBust()) { // Condition if all Players busts
			System.out.println("Dealer");
		} else if (players.get(players.size() - 1).bust()) { // Condition if Dealer busts
			for (int i = 0; i < players.size() - 1; i++) {
				if (!players.get(i).bust()) {
					System.out.println("Player " + (i + 1));
					players.get(i).hasWon();
				}
			}
		} else { // Condition to see what Players beat the Dealer or if none did
			boolean beatDealer = false;
			for (int i = 0; i < players.size() - 1; i++) {
				int dealerScore = players.get(players.size() - 1).getHand().getScore();
				int playerScore = players.get(i).getHand().getScore();
				if (!players.get(i).bust() && playerScore >= dealerScore) {
					beatDealer = true;
					if (playerScore == dealerScore) { // If Player Ties With Dealer
						players.get(i).hasTied();
						System.out.println("Player " + (i + 1) + " (Tied)");
					} else { // If Player Beats Dealer
						players.get(i).hasWon();
						System.out.println("Player " + (i + 1));
					}
				}
			}
			if (beatDealer == false) {
				System.out.println("Dealer");
			}
		}
		System.out.println();
	}

	public static void printPlayerNewTotals() {
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("------------------------------------------");
		for (int i = 0; i < players.size() - 1; i++) {
			System.out.println("Player " + (i + 1) + "'s Total: " + df.format(players.get(i).newTotal()));
		}
		System.out.println("------------------------------------------");
	}

	// Game text for Player
	public static void playersTurn() {
		for (int i = 0; i < players.size() - 1; i++) {
			System.out.println("\nDealers up Card: " + players.get(players.size() - 1).getDealersUpCard());
			System.out.println("\nPlayer " + (i + 1) + "'s Turn: ");
			System.out.println("------------------------------------------");
			System.out.println("\n" + players.get(i).getHand());

			// If Player Has BlackJack
			if (players.get(i).hasBlackJack()) {
				System.out.println("------------------------------------------");
				players.get(i).stand();
				System.out.println("\nBlackJack!");
			} else {
				System.out.println("------------------------------------------");
				System.out.println("Would You Like To (1) Stand or (2) Hit ?");
				int standOrHit = kbd.nextInt();
				while (standOrHit == 2) {
					players.get(i).hit(deck.getCard());
					System.out.println("------------------------------------------");
					if (players.get(i).bust()) {
						System.out.println("\nYour Score is Above 21. You Lose!\n");
						break;
					} else {
						System.out.println("Would You Like To (1) Stand or (2) Hit ?");
						standOrHit = kbd.nextInt();
					}
				}
				// Automatically Changes any Aces to 11 if it helps the player get closer to 21
				if (!players.get(i).bust()) {
					players.get(i).stand();
					System.out.println("------------------------------------------");
				}
			}
		}
	}

	public static void placingBets() {
		for (int i = 0; i < players.size() - 1; i++) {
			double bet = 0;
			System.out.println("Player " + (i + 1) + ": How much would you like to bet?");
			bet = kbd.nextDouble();
			while(bet > players.get(i).getMoney() || bet <= 0) {
				System.out.println("Invalid Bet!");
				System.out.println("Player " + (i + 1) + ": How much would you like to bet?");
				bet = kbd.nextDouble();
			}
			players.get(i).addBet(bet);
		}
	}

	// Game text for Dealer
	public static void dealersTurn() {
		System.out.println("\nDealer's Turn: ");
		System.out.println("------------------------------------------");
		System.out.println(players.get(players.size() - 1).getHand());
		if (players.get(players.size() - 1).hasBlackJack()) {
			System.out.println("------------------------------------------");
			players.get(players.size() - 1).stand();
			System.out.println("\nBlackJack!\n");
		} else {
			System.out.println("------------------------------------------");
			while (players.get(players.size() - 1).getHand().getScore() < 17) {
				players.get(players.size() - 1).hit(deck.getCard());
				System.out.println("------------------------------------------");
			}
			// Automatically Changes any Aces to 11 if it helps the Dealer get closer to 21
			if (!players.get(players.size() - 1).bust()) {
				players.get(players.size() - 1).stand();
				System.out.println("------------------------------------------");
			}
		}
	}

	// If true then Dealer does not have to play
	public static boolean allPlayersBust() {
		for (int i = 0; i < players.size() - 1; i++) {
			if (!players.get(i).bust()) {
				return false;
			}
		}
		return true;
	}

}
