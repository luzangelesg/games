package com.ae.games.service;

import java.util.ArrayList;
import java.util.List;

import com.ae.games.beans.Card;
import com.ae.games.beans.Player;
import com.ae.games.beans.Card.Rank;
import com.ae.games.beans.Card.Suit;
import com.ae.games.util.ConvertionUtil;

/**
 * 
 * The {@code PokerValidationService} class contains validations for a poker game
 * 
 * @author luzangeles
 *
 */
public class PokerValidationService  {

	/**
	 * Validates number is divisible by six 
	 * 
	 * @param number
	 * @return true: input has a name and 5 cards 
	 * <p>false if input is less or more than 6 
	 */
	public boolean validateDivisibleBySix(int number) {
		if(!(number % 6 == 0)) {
			
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * Evaluates if card size is 2 to 3 characters
	 * 
	 * @param number
	 * @return
	 */
	public boolean validateCardSize(int number) {
		if(number < 2 || number > 3) {
			return false;
		}
		return true;
	}
	
	/**
	 * @param args
	 * @return {@link List}
	 * @throws Exception
	 */
	public List<Player> getValidPlayers(String[] args) throws Exception {
		
		List<Player> players;
		List<Card> playerCards = null;
		String playerName = null;
		String playerValue = null;
		Card card = null;
		Player player = null;
		Suit suit = null;
		Rank rank = null;
		
		if(null != args && validateDivisibleBySix(args.length)) {
				
			players = new ArrayList<Player>();
			
			for(int i = 0; i < args.length; i++) {
			
				playerValue = args[i];
					
				if(null != playerValue) {
				
					playerValue = playerValue.replace(",", "").toUpperCase();
				
//					Validates if it's the name of the player
					if(validateDivisibleBySix(i)) {
						playerName = playerValue;
						player = new Player();
						player.setPlayerName(playerName);
						playerCards = new ArrayList<Card>();
						
					} else {

						if(validateCardSize(playerValue.length())) {
							rank = ConvertionUtil.convertToRank(playerValue.substring(0, playerValue.length() - 1));
							suit = ConvertionUtil.convertToSuit(playerValue.substring(playerValue.length()-1, playerValue.length()));
							
							if(null != rank && null != suit) {
								card = new Card();
								card.setRank(rank);
								card.setSuit(suit);
								playerCards.add(card);
									
							} else {
								throw new Exception("Card rank or suit are not correct. Rank should be 2, 3, 4, 5, 6, 7, 8, 9,10, Jack (J), Queen (Q), King (K), or Ace (A). Suits should be hearts (H), clubs (C), spades (S), and diamonds (D)");
							}
						} else {
							throw new Exception("Card should has at least 2 or 3 characters");
						}
					
						//When player has 5 cards they will be stored	
						if(null != playerCards && playerCards.size() == 5) {
							player.setPlayerCards(playerCards);
							players.add(player);
						}
					}
				}
			}
				
		} else {
			throw new Exception("please add name of the player and 5 cards");
		}
		
		return players;
	}
}
