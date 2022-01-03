package blackjack_project;

import java.util.ArrayList;

public class Hand {
	private int totalScore = 0;
	ArrayList<Card> pCards = new ArrayList<Card>();
	private boolean hasAce = false;

	// Adds the card to the players hand
	public void addCardToHand(Card c) {
		pCards.add(c);
		addToScore(c);
	}

	// Adds to totalScore based off of the cards value
	private void addToScore(Card c) {
		if (c.getFace().equals("Jack") || c.getFace().equals("Queen") || c.getFace().equals("King")) {
			totalScore += 10;
		} else {
			if (c.getFace().equals("Ace")) {
				hasAce = true;
			}
			totalScore += c.getValue();
		}
	}

	// Gets the hand card at certain index
	public Card getHandCard(int index) {
		return pCards.get(index);
	}

	// Calculated automatically whether or not the ace[s] will be counted as 1 or 11.
	// It is called after the player has decided to "stand"
	public void addAceValue() {
		if (hasAce && totalScore + 10 <= 21) {
			totalScore += 10;
		}
	}

	public int getScore() {
		return totalScore;
	}

	public void clearHand() {
		pCards.removeAll(pCards);
		totalScore = 0;
		hasAce = false;
	}

	// Prints out players hand and total score
	public String toString() {
		String playerHand = "Hand: \n";
		for (int i = 0; i < pCards.size(); i++) {
			playerHand += pCards.get(i) + "\n";
		}
		playerHand += "Total Score: " + totalScore;
		return playerHand;
	}
}
