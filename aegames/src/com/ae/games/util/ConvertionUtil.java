package com.ae.games.util;

import com.ae.games.beans.Card.Rank;
import com.ae.games.beans.Card.Suit;

/**
 * The {@code ConvertionUtil} is a helper to pass data from one type to another
 * 
 * @author luzangeles
 *
 */
public class ConvertionUtil {
	
	/**
	 * Returns a {@code Rank} type where possible values are 
	 * 2, 3, 4, 5, 6, 7, 8, 9,10, Jack (J), Queen (Q), King (K), and Ace (A).
	 * 
	 * @param input
	 * @return
	 */
	public static Rank convertToRank(String input) {
		
		Rank rank = null; 
		
		switch (input) {
		case "2":
			rank = Rank.TWO;
			break;
		case "3":
			rank = Rank.THREE;
			break;
		case "4":
			rank = Rank.FOUR;
			break;
		case "5":
			rank = Rank.FIVE;
			break;
		case "6":
			rank = Rank.SIX;
			break;
		case "7":
			rank = Rank.SEVEN;
			break;
		case "8":
			rank = Rank.EIGHT;
			break;
		case "9":
			rank = Rank.NINE;
			break;
		case "10":
			rank = Rank.TEN;
			break;
		case "J":
			rank = Rank.JACK;
			break;
		case "Q":
			rank = Rank.QUEEN;
			break;
		case "K":
			rank = Rank.KING;
			break;
		case "A":
			rank = Rank.ACE;
			break;
		default:
			rank = null;
			break;
		}
		
		return rank;
	}
	
	/**
	 * 
	 * Returns a {@code Suit} type where possible values are 
	 * hearts (H), clubs (C), spades (S), and diamonds (D). 
	 * 
	 * @param input
	 * @return {@link Suit}
	 */
	public static Suit convertToSuit(String input) {
		
		Suit suit = null; 
		
		switch (input) {
		case "H":
			suit = Suit.HEARTS;
			break;
		case "C":
			suit = Suit.CLUBS;
			break;
		case "S":
			suit = Suit.SPADES;
			break;
		case "D":
			suit = Suit.DIAMONDS;
			break;
		default:
			suit = null;
			break;
		}
		
		return suit;
	}
}
