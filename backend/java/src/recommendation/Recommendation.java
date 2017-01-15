package recommendation;
import java.util.*;

/**
*   The list of recommendations given to user.
*/
public class Recommendation {
    /**Recommended team and percentage*/
    private String team;
    private int percentage;

    public Recommendation() {
    }

    public Recommendation (String team, int percentage) {
        this.team = team;
        this.percentage = percentage;
    }
    
    public void print() {
        System.out.println("TEAM: " + this.team + ", PERCENTAGE: " + this.percentage);
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!Recommendation.class.isAssignableFrom(o.getClass())) {
            return false;
        }
        final Recommendation r = (Recommendation) o;
        
        if (r.getTeam() == this.getTeam() && r.getPercentage() == this.getPercentage()) {
        	return true;
        } else {
        	return false;
        }
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getTeam() {
        return this.team;
    }
    public int getPercentage() {
        return this.percentage;
    }
}