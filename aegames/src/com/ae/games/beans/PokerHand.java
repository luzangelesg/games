package com.ae.games.beans;

import java.util.List;


/**
 * 
 * The {@code PokerHand} class represents different types of poker hands 
 * such as:
 * <p>Flush 			
 * <p>Three of a Kind 	
 * <p>One Pair 
 * <p>High Card	
 * 
 * @author luzangeles
 *
 */
public class PokerHand {
	
	
	/**
	 * 
	 * Represents types of Poker Hands (flush, Three of a Kind, One Pair)
	 * 	
	 * @author luzangeles
	 *
	 */
	public enum PokerHandOption { FLUSH(80), THREEOFAKIND(70), ONEPAIR(60);
		
		private final int pokerHandScore;
		
		private PokerHandOption(int pokerHandScore) {
			this.pokerHandScore = pokerHandScore;
		}
		
		public int getPokerHandScore() {
			return pokerHandScore;
		}	
	}
	
	/**
	 * 
	 * Return the maximum score of 5 cards comparing the rank
	 * 
	 * @param cards
	 * @return
	 */
	public static int highCard(List<Card> cards) {
		
		int maxValue = 0;
		
		for(Card card: cards) {
			
			if(card.getRank().getRankScore() > maxValue) {
				maxValue = card.getRank().getRankScore();
			}
		}

		return maxValue;
	}
	
}
