package recommendation;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WeightedRankings {
	public TeamRankings teamRankings;
	public EloRankings eloRankings;
	
	public WeightedRankings() {
		this.teamRankings = new TeamRankings();
		this.eloRankings = new EloRankings();
	}
	
	public void print() {
		this.eloRankings.print();
		this.teamRankings.print();
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
		
	}
}
