package initial;

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
	public void setHomeGoals(int homeGoals) {
		this.homeGoals = homeGoals;
	}
	public void setAwayGoals(int awayGoals) {
		this.awayGoals = awayGoals;
	}
	
	@Override
	public String toString() {
		return homeTeam + " " + homeGoals + ":" + awayGoals + " " + awayTeam;
	}
	
	public static void main(String[] args) {
		BasketballMatch match = new BasketballMatch("Bulls", "Lakers");
		match.setHomeGoals(2);		match.setHomeGoals(5);
		match.setAwayGoals(2);		match.setAwayGoals(4);
		System.out.println(match.toString()); // Bulls 5:4 Lakers
		match.setHomeGoals(9); // cheating!
	}	
}