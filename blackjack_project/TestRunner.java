package blackjack_project;

public class TestRunner {

	public static void main(String[] args) {
		Deck d = new Deck();
		System.out.println(d);
		Hand h = new Hand();
		h.addCardToHand(new Card(1,1));
		System.out.println(h);
	}

}
