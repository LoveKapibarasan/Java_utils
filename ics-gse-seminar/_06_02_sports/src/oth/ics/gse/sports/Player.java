package oth.ics.gse.sports;

public class Player {
	
	private String name;
	private Team team;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		if (this.team != null && this.team != team) {
			this.team.removePlayer(this);
		}
		this.team = team;
		if (team != null) {
			team.addPlayer(this);
		}
	}
}
