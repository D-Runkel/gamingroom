package com.gamingroom;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// next team/player Identifier

	private static long nextTeamId = 100;

	private static long nextPlayerId = 1000;



	// private constructor to prevent making more instances of gameservice.
	private GameService() {
	}
	
	// The creation of GameService
	private static GameService instance = new GameService();

	// public method to access gameservice
	public static GameService getInstance() {
		return instance;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// Get the Iterator object. 
		Iterator<Game> it = games.iterator();

		while(it.hasNext()) {

			//local instance equals next game in iterator
			game = it.next();

			if(game.getName().equalsIgnoreCase(name)) {
				// if game with same name is found, returns the one already created.
				return game;
			}
			
		}
		/* 
		*Using the iterator built in to the java utilities is a good way to iterate over a list of
		*objects. It is used to effciently find a particular element by examining each element 1 by 1. 
		* All of this is done without exposing the data structure underneath.  
		*/
		// sets game back to NULL, if no matches found. 
		game = null;

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		Iterator<Game> it = games.iterator();

		while (it.hasNext()) {

			game = it.next();

			if(id == game.getId()){

				return game;
			}
		}

		game = null;
		return game;
	
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		
		Iterator<Game> it = games.iterator();
		
		while (it.hasNext()){

			game = it.next();

			if(game.getName().equalsIgnoreCase(name)) {
				
				return game;

			}
		}

		game = null;  // returns an empty game object if none are found
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}

	/* 
	issues next team id.
	increments teamId so a unique number is given every time. 
	*/
	public long getNextTeamId() {
		nextTeamId++;
		return nextTeamId;
	}

	/* 
	issues next player id. 
	incremented playerid so a unique number is issued every time.
	*/

	public long getNextPlayerId() {
		nextPlayerId++;
		return nextPlayerId;
	}
}
