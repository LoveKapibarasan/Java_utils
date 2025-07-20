package information_hiding;

public class BasketballMatch {
	private String homeTeam;
	private String awayTeam;
	private int homeGoals;
	private int awayGoals;
	
	public BasketballMatch(String homeTeam, String awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}
	
	public int getHomeGoals() { return homeGoals; }
	public int getAwayGoals() {	return awayGoals; }
	
	public void score(boolean home, int goals) {
		if (goals < 0 || goals > 2) {
			throw new IllegalArgumentException("Invalid scored goals: " + goals);
		}
		if (home) {	homeGoals += goals;	} else {awayGoals += goals;	}
	}
	
	@Override
	public String toString() {
		return homeTeam + " " + homeGoals + ":" + awayGoals + " " + awayTeam;
	}
	
	public static void main(String[] args) {
		BasketballMatch match = new BasketballMatch("Bulls", "Lakers");
		match.score(true, 2);		match.score(true, 3);
		match.score(false, 2);		match.score(false, 2);
		System.out.println(match.toString()); // Bulls 5:4 Lakers
		match.score(true, 4); // exception is thrown
	}
	
}