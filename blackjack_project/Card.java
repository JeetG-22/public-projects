package blackjack_project;

public class Card {
	private int faceVal;
	private int suit;

	public Card(int suit, int val) {
		faceVal = val;
		this.suit = suit;
	}

	// Spades = 1, Diamonds = 2, Clubs = 3, Hearts = 4
	public int getSuit() {
		return suit;
	}

	public int getValue() {
		return faceVal;
	}

	//Figuring out Face of Card
	public String getFace() {
		String face = "";
		if (1 < faceVal && faceVal < 11) {
			face += faceVal;
		} else if (faceVal == 1) {
			face = "Ace";
		} else if (faceVal == 11) {
			face = "Jack";
		} else if (faceVal == 12) {
			face = "Queen";
		} else if (faceVal == 13) {
			face = "King";
		}
		return face;
	}
	
	//Printing out the Card
	public String toString() {
		String card = getFace() + " of ";
		if (suit == 1) {
			card += "SPADES";
		} else if (suit == 2) {
			card += "DIAMONDS";
		} else if (suit == 3) {
			card += "CLUBS";
		} else if (suit == 4) {
			card += "HEARTS";
		}
		return card;
	}
}
