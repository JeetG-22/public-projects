package blackjack_project;

public class Player {
	private double money = 0;
	private double bet = 0;
	private boolean hasWon, hasTied;

	// This is the players unique hand
	Hand hand;

	// Creates a deck object that is already instantiated & shuffled in BlackJack
	// Class
	// Creates a hand object
	public Player(double startingMoney) {
		hand = new Hand();
		money = startingMoney;
	}

	// If Dealer Object is Created
	public Player() {
		hand = new Hand();
	}

	// Shows dealer's first card
	public Card getDealersUpCard() {
		return getHand().getHandCard(0);
	}

	//
	public void setMoney(double reloadMoney) {
		money += reloadMoney;
	}

	public double getMoney() {
		return money;
	}

	// Adds the bet to that the player wants to make
	public void addBet(double amount) {
		bet += amount;
	}

	public void hasWon() {
		hasWon = true;
	}

	public void hasTied() {
		hasTied = true;
	}

	// Prints out New Total based off of the round and resets the variables if
	// player wants to play again
	public double newTotal() {
		if (hasBlackJack()) { // If player get blackjack they get 2.5x his bet
			money += (bet * 2.5);
		} else if (hasWon) { // If player wins he gets 2x his bet
			money += (bet * 2);
		} else if (hasTied) { // If player pushes then he gets nothing
			money += 0;
		} else {
			money -= bet;
		}
		bet = 0;
		hasTied = false;
		hasWon = false;
		return money;
	}

	// Checks to see if Player has Ace and a 10
	public boolean hasBlackJack() {
		boolean hasAce = hand.getHandCard(0).getValue() == 1 || hand.getHandCard(1).getValue() == 1;
		boolean hasTen = hand.getHandCard(0).getValue() == 10 || hand.getHandCard(1).getValue() == 10
				|| hand.getHandCard(0).getValue() == 11 || hand.getHandCard(1).getValue() == 11
				|| hand.getHandCard(0).getValue() == 12 || hand.getHandCard(1).getValue() == 12
				|| hand.getHandCard(0).getValue() == 13 || hand.getHandCard(1).getValue() == 13;
		if (hasAce && hasTen) {
			return true;
		}
		return false;
	}

	// Gives two new cards to players if they want to play again
	public void startRound(Card c) {
		hand.addCardToHand(c);
	}

	public void stand() {
		hand.addAceValue();
		System.out.println(hand);
	}

	public void hit(Card c) {
		hand.addCardToHand(c);
		System.out.println(hand);
	}

	public boolean bust() {
		if (hand.getScore() > 21) {
			return true;
		}
		return false;
	}

	public Hand getHand() {
		return hand;
	}
}
