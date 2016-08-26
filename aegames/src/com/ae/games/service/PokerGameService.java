package com.ae.games.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ae.games.beans.Card;
import com.ae.games.beans.Player;
import com.ae.games.beans.PokerHand;
import com.ae.games.beans.Card.Rank;
import com.ae.games.beans.Card.Suit;
import com.ae.games.beans.PokerHand.PokerHandOption;

/**
 * 
 * The {@code PokerGameService} class contains the logic 
 * to play a Poker Game.
 * 
 * @author luzangeles
 *
 */
public class PokerGameService {
	
	private HashMap<Suit, Integer> mapSuitCounter; 
	private HashMap<Integer, Rank> mapRankCounter; 
	private List<Player> players;
	
	public PokerGameService() {
		
	}
	
	/**
	 * @param players
	 */
	public PokerGameService(List<Player> players) {
		this.players = players;
		
		assignPlayersScores();
	}
	
	/**
	 * Iterates players to set their scores depending of their cards
	 */
	private void assignPlayersScores() {
		
		for (Player player: players) {
			assignCounters(player.getPlayerCards());
			player.setScore(obtainPokerHandScore(player.getPlayerCards()));
		}
	}
	
	/**
	 * Assigns maps with a number of repetition per Suit and Rank
	 * 
	 * @param cards
	 */
	public void assignCounters(List<Card> cards) {
		
		mapSuitCounter = new HashMap<Suit, Integer>();
		mapRankCounter = new HashMap<Integer, Rank>();
		
		int counterSuit = 0;
		int counterRank = 0;
		
		for(Card currentCard: cards) {
			
			for(Card comparedCard: cards) {
				
				if(currentCard.getSuit() == comparedCard.getSuit()) {
					comparedCard.getSuit();
					counterSuit++;
				}
				if(currentCard.getRank() == comparedCard.getRank()) {
					comparedCard.getRank();
					counterRank++;
				}
			}
			
			mapSuitCounter.put(currentCard.getSuit(), counterSuit);
			mapRankCounter.put(counterRank, currentCard.getRank());
			counterSuit = 0;
			counterRank = 0;
		}
	}
	
	/**
	 * 
	 * Evaluates suits and ranks that create a poker hand and returns a score
	 * 
	 * @param cards
	 * @return
	 */
	private int obtainPokerHandScore(List<Card> cards) {

		if (null != mapSuitCounter.get(Suit.HEARTS) && mapSuitCounter.get(Suit.HEARTS) == 5){
			return PokerHandOption.FLUSH.getPokerHandScore();
			
		} else if(null != mapRankCounter.get(3)) {
			return PokerHandOption.THREEOFAKIND.getPokerHandScore();
			
		} else if(null != mapRankCounter.get(2)) {
			return PokerHandOption.ONEPAIR.getPokerHandScore();
			
		} else {
			return PokerHand.highCard(cards);
		}
	}
	
	/**
	 * Determines winners and returns a {@code List} of winning players
	 * 
	 * @return {@link List}
	 */
	public List<Player> obtainWinners() {
		
		List<Player> winners = new ArrayList<Player>();
		int previousPlayerScore = 0;
		int currentPlayerScore = 0;
		
		for (Player player: players) {
			
			currentPlayerScore = player.getScore();
			
			//Compares if the current player has higher score than the previous player
			if(currentPlayerScore > previousPlayerScore){
				//this will remove previous winner because there is a higher value
				winners.clear();
				
				//add a winner
				winners.add(player);
				previousPlayerScore = currentPlayerScore;
			} 
			//If the player has an equal score it will add it to the winners
			else if (currentPlayerScore == previousPlayerScore) {
				//it's a tie
				winners.add(player);
			}
		}
		
		return winners;
	}
}
