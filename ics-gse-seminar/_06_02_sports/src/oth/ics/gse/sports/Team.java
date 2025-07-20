package oth.ics.gse.sports;

import java.util.LinkedHashSet;
import java.util.Set;

public class Team {
	private String name;
	private Set<Player> players;
	
	public Team(String name) {
		this.name = name;
		this.players = new LinkedHashSet<>();
	}
	
	public String getName() {
		return name;
	}

	public void addPlayer(Player player) {
		if (players.size() > 35) return;
		if (player.getTeam() != this) {
			player.setTeam(this);
		}
		this.players.add(player);
	}

	public void removePlayer(Player player) {
		if (player.getTeam() == this) {
			player.setTeam(null);
		}
		this.players.remove(player);
	}	
}
