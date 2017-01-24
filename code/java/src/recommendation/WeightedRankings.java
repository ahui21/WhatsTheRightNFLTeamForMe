package recommendation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WeightedRankings {
	public TeamRankings teamRankings;
	public EloRankings eloRankings;
	
	private String defaultFileLocation = "resources/team-picking-categories.csv";
	
	public WeightedRankings() {
		this.teamRankings = new TeamRankings();
		teamRankings.populateData(defaultFileLocation);
		this.eloRankings = new EloRankings();
	}
	
	public WeightedRankings(String fileLocation) {
		this.teamRankings = new TeamRankings();
		teamRankings.populateData(fileLocation);
		this.eloRankings = new EloRankings();
	}
	
	public void print() {
		System.out.println("\n\nElo Rankings\n"
				+ "---------------------------------------------------------");
		this.eloRankings.print();
		
		System.out.println("\n\nTeam Rankings\n"
				+ "---------------------------------------------------------");
		this.teamRankings.print();
		
		System.out.println("\n\n");
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!WeightedRankings.class.isAssignableFrom(o.getClass())) {
            return false;
        }
        final WeightedRankings r = (WeightedRankings) o;
        
        return (r.getTeamRankings() == this.getTeamRankings()) && (r.getEloRankings() == this.getEloRankings());
    }
    
    public void setTeamRankings(TeamRankings teamRankings) {
    	this.teamRankings = teamRankings;
    }
    
    public void setEloRankings(EloRankings eloRankings) {
    	this.eloRankings = eloRankings;
    }
    
    public TeamRankings getTeamRankings() {
    	return this.teamRankings;
    }
    
    public EloRankings getEloRankings() {
    	return this.eloRankings;
    }
	
	public void nextMatch() {
		this.eloRankings.nextMatch();
	}
	
	public void calculateRankings() {
		HashMap<String, EloRating> eloRatings = this.eloRankings.getEloRatings();
		int numOfTeams = this.teamRankings.getTeamRankings().size();
		
		for (int i = 0; i < numOfTeams; i++) {
			
		}
	}
}
