package com.ae.games.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.ae.games.beans.Player;

public class PokerValidationServiceTest {

	@Test
	public void testCorrectArgs() throws Exception {
		String [] args = {	"Joe", "3H", "4H", "5H", "6H", "8H",
			  				"Bob", "3C", "3D", "3S", "10D", "10H", 
			  				"Sally", "AC", "10C", "5C", "2S", "2C"};

		PokerValidationService pokerValidationService = new PokerValidationService();
		List<Player> players = pokerValidationService.getValidPlayers(args);
		
		assertEquals(3, players.size());
	}
	
	@Test(expected=Exception.class)
	public void testMissingParameters() throws Exception {
		String [] args = {	"Joe", "3H", "4H", "5H", "6H", "8H",
			  	"Bob", "3C", "3D", "3S", "10D", 
			  	"Sally", "AC", "10C", "5C", "2S", "2C"};

		PokerValidationService pokerValidationService = new PokerValidationService();
		pokerValidationService.getValidPlayers(args);
	}
	
	@Test(expected=Exception.class)
	public void testInvalidSuit() throws Exception {
		String [] args = {	"Joe", "3C", "4T", "5H", "6H", "8H",
			  				"Bob", "3C", "3D", "3S", "10D", "10H", 
			  				"Sally", "AC", "10C", "5C", "2S", "2C"};

		PokerValidationService pokerValidationService = new PokerValidationService();
		pokerValidationService.getValidPlayers(args);
	}
	
	@Test(expected=Exception.class)
	public void testInvalidRank() throws Exception {
		String [] args = {	"Clark", "3C", "4H", "5H", "6H", "8H",
			  				"Diana", "3C", "1D", "3S", "10D", "10H"};

		PokerValidationService pokerValidationService = new PokerValidationService();
		pokerValidationService.getValidPlayers(args);
	}
	
	@Test(expected=Exception.class)
	public void testInvalidCardSize() throws Exception {
		String [] args = {	"Bob", "3C", "4H", "5H", "6H", "80HY",
			  				"Diana", "3C", "2D", "3S", "10D", "10H"};

		PokerValidationService pokerValidationService = new PokerValidationService();
		pokerValidationService.getValidPlayers(args);
	}
}
