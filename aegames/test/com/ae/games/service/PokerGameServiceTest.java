package com.ae.games.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.ae.games.beans.Player;
import com.ae.games.service.PokerGameService;
import com.ae.games.service.PokerValidationService;

public class PokerGameServiceTest {

	@Test
	public void testFlush() {
		
		String [] args = {	"Joe", "3H", "4H", "5H", "6H", "8H",
						  	"Bob", "3C", "3D", "3S", "8C", "10D", 
						  	"Sally", "AC", "10C", "5C", "2S", "2C"};

		List<Player> players = getPlayers(args);
		System.out.println("testFlush:" + players.size());
		assertEquals(1, players.size());
		assertEquals("JOE", players.get(0).getPlayerName());
	}
	
	@Test
	public void testFlushWithTie() {
		
		String [] args = {	"Zoe", "2H", "8H", "5H", "6H", "8H",
						  	"Tom", "8H", "3H", "6H", "2H", "10H"};

		List<Player> players = getPlayers(args);
		System.out.println("testFlushWithTie:" + players.size());
		assertEquals(2, players.size());
		assertEquals("ZOE", players.get(0).getPlayerName());
		assertEquals("TOM", players.get(1).getPlayerName());
	}
	
	@Test
	public void testThreeOfAKind() {
		
		String [] args = {	"Joe", "3H", "4H", "5H", "6H", "8C",
						  	"Bob", "3C", "3D", "3S", "8C", "10D", 
						  	"Sally", "AC", "10C", "5C", "2S", "2C"};

		List<Player> players = getPlayers(args);
		System.out.println("testThreeOfAKind:" + players.size());
		assertEquals(1, players.size());
		assertEquals("BOB", players.get(0).getPlayerName());
	}
	
	@Test
	public void testThreeOfAKindWithTie() {
		
		String [] args = {	"Joe", "3D", "4C", "3H", "6H", "3C",
						  	"John", "3C", "3D", "3S", "8C", "10D", 
						  	"Mattew", "AC", "10C", "5C", "2S", "2C",
						  	"Cloe", "3H", "4H", "5H", "4H", "4C",
						  	"Ron", "3C", "3D", "10S", "8C", "10D", 
						  	"Matt", "AC", "10C", "5C", "2S", "2C",
						  	"Andy", "10H", "10H", "10H", "6H", "8C"};

		List<Player> players = getPlayers(args);
		System.out.println("testThreeOfAKind:" + players.size());
		assertEquals(4, players.size());
		assertEquals("JOE", players.get(0).getPlayerName());
		assertEquals("JOHN", players.get(1).getPlayerName());
		assertEquals("CLOE", players.get(2).getPlayerName());
		assertEquals("ANDY", players.get(3).getPlayerName());
	}
	

	@Test
	public void testOnePair() {
		
		String [] args = {	"Joe", "3H", "4H", "5H", "6H", "8C",
						  	"Bob", "5C", "3D", "4S", "8C", "10D", 
						  	"Sally", "AC", "10C", "5C", "2S", "2C"};

		List<Player> players = getPlayers(args);
		System.out.println("testOnePair:" + players.size());
		assertEquals(1, players.size());
		assertEquals("SALLY", players.get(0).getPlayerName());
	}
	
	@Test
	public void testOnePairWithTie() {
		
		String [] args = {	"Rose", "10H", "4H", "10C", "6D", "8S",
						  	"Daniel", "5C", "3D", "3D", "8S", "10D", 
						  	"Josh", "7S", "QH", "5C", "2S", "7D"};

		List<Player> players = getPlayers(args);
		System.out.println("testOnePairWithTie:" + players.size());
		
		assertEquals(3, players.size());
		assertEquals("ROSE", players.get(0).getPlayerName());
		assertEquals("DANIEL", players.get(1).getPlayerName());
		assertEquals("JOSH", players.get(2).getPlayerName());
	}
	
	@Test
	public void testHighCard() {
		
		String [] args = {	"Joe", "AH", "4H", "5H", "6H", "8C",
						  	"Bob", "5C", "3D", "4S", "8C", "10D", 
						  	"Sally", "2C", "10C", "5C", "3S", "4C",
						  	"Luz", "3C", "4H", "KS", "2H", "10D"};

		List<Player> players = getPlayers(args);
		System.out.println("testHighCard:" + players.size());
		assertEquals(1, players.size());
		assertEquals("JOE", players.get(0).getPlayerName());
	}
	
	@Test
	public void testHighCardWithTie() {
		
		String [] args = {	"Joe", "3H", "4H", "5H", "6H", "8C",
						  	"Bob", "5C", "3D", "4S", "8C", "10D", 
						  	"Sally", "AC", "10C", "5C", "3S", "2C",
						  	"Luz", "3C", "4H", "AS", "2H", "10D"};

		List<Player> players = getPlayers(args);
		System.out.println("testHighCardWithTie:" + players.size());
		assertEquals(2, players.size());
		assertEquals("SALLY", players.get(0).getPlayerName());
		assertEquals("LUZ", players.get(1).getPlayerName());
	}
	
	private List<Player> getPlayers(String [] args) {
		
		PokerValidationService pokerValidationService = new PokerValidationService();
		
		List<Player> players = null;
		
		try {
			players = pokerValidationService.getValidPlayers(args);
			
			PokerGameService pokerGameService = new PokerGameService(players);
			players = pokerGameService.obtainWinners();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return players;
	}
}
