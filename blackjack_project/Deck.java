package blackjack_project;

public class Deck {
	private  Card[] deck;
	private int index = 0;

	public Deck() {
		deck = new Card[52];
		for (int i = 0; i < createCardArray().length; i++) {
			deck[i] = createCardArray()[i];
		}
	}

	// Intitializes the deck[]
	public Card[] createCardArray() {
		Card[] cardArr = new Card[52];
		int suitNum = 1;
		int faceNum = 1;
		int index = 0;
		while (suitNum < 5) {
			cardArr[index] = new Card(suitNum, faceNum);
			index++;
			faceNum++;
			if (faceNum == 14) {
				faceNum = 1;
				suitNum++;
			}

		}
		return cardArr;
	}
	
	//Resets the index if players want to start a new game
	public void resetIndex() {
		index = 0;
	}

	// Shuffled the deck[] by replacing the i-th index with any number between [0-51]
	public void shuffle() {
		for (int i = 0; i < deck.length; i++) {
			int randNum = (int) (Math.random() * 52);
			Card temp = deck[i];
			deck[i] = deck[randNum];
			deck[randNum] = temp;
		}

	}
	
	//Gets the top card in the pile and increments the index to get the next card
	public Card getCard() {
		index++;
		return deck[index - 1];
	}

	public String toString() {
		String outputDeck = "";
		for (int i = 0; i < deck.length; i++) {
			outputDeck += deck[i] + " | ";
			if (i % 5 == 0 && i != 0) {
				outputDeck += "\n";
			}
		}
		return outputDeck;
	}
}
