package project;



public class Card {
	private Faces face;
	private Suit suit;
	private int value;
	public Card(Faces f, Suit s, int v) {
		face = f;
		suit = s;
		value = v;
	}

	public Faces getFace() {
		return face;
	}

	public void setFace(Faces face) {
		this.face = face;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String toString() {
		return (face + " of " + suit).toLowerCase();
	}
	
	public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((face == null) ? 0 : face.hashCode());
        result = prime * result
                + ((suit == null) ? 0 : suit.hashCode());
        return result;
    }

    
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (face != other.face)
            return false;
        if (suit != other.suit)
            return false;
        return true;
    }

}
