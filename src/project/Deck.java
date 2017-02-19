package project;

import java.util.ArrayList;
import java.util.List;

public class Deck {

	List<Card> deck = new ArrayList<>(52);
	public void createDeck(){
		int counter = 1;
		for (Faces face : Faces.values()) {
			for (Suit suit : Suit.values()) {
				if(counter == 1){
				deck.add(new Card(face, suit, 11));
				}
				else if (counter < 10){
					
					deck.add(new Card(face, suit, counter));
				}
				else{
					deck.add(new Card(face, suit, 10));
					
				}
			}
			counter++;
		}
	
	}
	public List<Card> getDeck() {
		return deck;
	}
	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

}
