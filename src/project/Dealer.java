package project;

import java.util.Collections;

public class Dealer extends Player {
	Deck deck1 = new Deck();
	Hand hand = new Hand();

	public void shuffleDeck() {
		deck1.createDeck();

		Collections.shuffle(deck1.getDeck());

	}

	public Card deal() {
		return deck1.getDeck().remove(0);
	}

	public Deck getDeck1() {
		return deck1;
	}

	public void setDeck1(Deck deck1) {
		this.deck1 = deck1;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	
}
