package com.ae.games.beans;

import java.util.List;

/**
 * 
 * The {@code Player} class is a bean which contains basic player information
 * such as name, playerCards and score for his/her poker hand.
 * 
 * @author luzangeles
 *
 */
public class Player {

	private String playerName;
	private List<Card> playerCards;
	private int score;

	/**
	 * 
	 * Retrieves player name
	 * 
	 * @return
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * 
	 * Assign players name
	 * 
	 * @param playerName
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * 
	 * Retrieve player cards
	 * 
	 * @return
	 */
	public List<Card> getPlayerCards() {
		return playerCards;
	}

	/**
	 * 
	 * Sets player cards
	 * 
	 * @param playerCards
	 */
	public void setPlayerCards(List<Card> playerCards) {
		this.playerCards = playerCards;
	}

	/**
	 * Retrieves a score
	 * 
	 * @return
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Assign a score
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		sb.append("|playerName:" + playerName);
		sb.append("|score:" + score);
		sb.append("|playerCards:" + playerCards);
		
		
		return sb.toString();
	}
	
}
