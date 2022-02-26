package com.gamingroom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {

	private List<Player> players = new ArrayList<Player>();

	GameService service = GameService.getInstance();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}

	/*add player method, searches current players and adds new player
	if no player with existing name is found.
	*/

	public Player addPlayer(String name) {

		Player player = null;

		Iterator<Player> it = players.iterator();

		while(it.hasNext()){
			
			player = it.next();

			if (player.getName().equalsIgnoreCase(name)) {
				//lets me know if the player name already exists
				System.out.println("Player: "+ name + "Already exists.");
				return player;
			}
		}
	

	player = null;

	if (player == null) {

		player = new Player(service.getNextPlayerId(),name);

		players.add(player);
	}
	//return new player for chain
	return player;

	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
