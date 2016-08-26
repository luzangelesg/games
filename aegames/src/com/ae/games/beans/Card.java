package com.ae.games.beans;

/**
 * 
 * The {@code Card} class represents a game card
 * <p> Every Card has a suit and a number
 * 
 * @author luzangeles
 *
 */
public class Card {
	
	private Suit suit;
	private Rank rank;
	
	/**
	 * The {@code Suit} represents the different types of suits in a card
	 * <p>hearts (H), clubs (C), spades (S), and diamonds (D). are suits types
	 * @author luzangeles
	 *
	 */
	public enum Suit { HEARTS, CLUBS, SPADES, DIAMONDS }
	
	/**
	 * The {@code Rank} represents the different types of ranks in a card
	 * <p>2, 3, 4, 5, 6, 7, 8, 9,10, Jack (J), Queen (Q), King (K), and Ace (A) are rank types
	 * @author luzangeles
	 *
	 */
	public enum Rank { TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(20), QUEEN(30), KING(40), ACE(50);
	
		private final int rankScore;
	
		private Rank(int rankScore) {
			this.rankScore = rankScore;
		}
		
		public int getRankScore() {
			return rankScore;
		}
		
		public Rank getRank() {
			return this;
		}
	}
	
	/**
	 * 
	 * Returns the type of {@code Suit} of a card.
	 * 
	 * @return {@link Suit}
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * 
	 * Set the type of {@code Suit} of a card.
	 * 
	 * @param suit
	 */
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	/**
	 * 
	 * Returns the type of {@code Rank} of a card.
	 * 
	 * @return {@link Rank}
	 */
	public Rank getRank() {
		return rank;
	}
	
	/**
	 * Set the type of {@code Rank} of a card.
	 * 
	 * @param rank
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		sb.append("|rank:"+rank);
		sb.append("|suit:"+suit);
		
		return sb.toString();
	}
}
