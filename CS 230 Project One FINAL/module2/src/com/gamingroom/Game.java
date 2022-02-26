package com.gamingroom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * author coce@snhu.edu
 *
 */
public class Game extends Entity {

	GameService service = GameService.getInstance();

	//List of teams in current game

	
	/**
	 * Constructor with an identifier and name
	 */

	public Game(long id, String name) {
		this.id = id;
		this.name = name;
	}

	/*
	* add team searches list of current teams, if no team matches
	* current team name, it is added to the list of teams.
	*/

	private List<Team> teams = new ArrayList<Team>();

	public Team addTeam(String name) {

		

		//empty team object
		Team team = null;

		// calling iterator
		Iterator<Team> it = teams.iterator();

		//searching list for team with name provided
		while(it.hasNext()) {

			team = it.next();
			
			if(team.getName().equalsIgnoreCase(name)) {
				
				//returns initial team if duplicate name exists
				return team;

			}
		}

		team = null;

		//if no team is found, team is added with name

		if (team == null) {
			
			  team = new Team(service.getNextTeamId(), name);

			teams.add(team);
		}

		return team;
	}

	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + " Teams: " + teams + "]" ;
	}


}
