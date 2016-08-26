package com.ae.games;

import java.util.List;

import com.ae.games.beans.Player;
import com.ae.games.service.PokerGameService;
import com.ae.games.service.PokerValidationService;



/**
 * 
 * The {@code PokerGame} class simulates a poker game with multiple 
 * players using as criteria four regular hands
 * <p>Flush
 * <p>Three of a Kind
 * <p>One Pair
 * <p>High Card
 * The input should be a collection of players that contain:
 * <p>Player Name
 * <p>5 Cards (each specifying the card rank and suit of the card)
 * <p>
 * <p>Output: Collection of winning players (more than one in case of a tie)
 * <p>Example
 * <p>Input:
 * <p>Joe, 3H, 4H, 5H, 6H, 8H
 * <p>Bob, 3C, 3D, 3S, 8C, 10D
 * <p>Sally, AC, 10C, 5C, 2S, 2C
 * <p>Output:
 * <p>Joe
 * 
 * 
 * @author luzangeles
 *
 */
public class PokerGame {
		
	public static void main(String[] args)  {
		
		PokerValidationService pokerValidationService = new PokerValidationService();
		
		try {
			List<Player> players = pokerValidationService.getValidPlayers(args);
			PokerGameService pokerGameService = new PokerGameService(players);
			
			for(Player winner: pokerGameService.obtainWinners()) {
				System.out.println(winner.getPlayerName());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
