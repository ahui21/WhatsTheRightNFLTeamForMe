package recommendation;

public class EloRating {
	/**Elo Rating*/
	private double rating;
	private int numOfMatches = 0;
	private boolean provisional = true;
	
	public EloRating() {
	}
	
	public EloRating(double rating) {
		this.rating = rating;
	}
	
	public void print() {
        if (this.provisional) {
        	System.out.println("PROVISIONAL ELO RATING: " + this.rating);
        } else {
        	System.out.println("ELO RATING: " + this.rating);
        }
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!EloRating.class.isAssignableFrom(o.getClass())) {
            return false;
        }
        final EloRating r = (EloRating) o;
        
        return (r.getRating() == this.getRating() && r.getNumOfMatches() == this.getNumOfMatches() && r.getProvisional() == this.getProvisional());
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public void setNumOfMatches(int numOfMatches) {
    	this.numOfMatches = numOfMatches;
    }
    
    public void setProvisional(boolean provisional) {
    	this.provisional = provisional;
    }

    public double getRating() {
        return this.rating;
    }
    
    public int getNumOfMatches() {
    	return this.numOfMatches;
    }
    
    public boolean getProvisional() {
    	return this.provisional;
    }
    
    public void updateRating(double rating) {
    	this.rating = rating;
    	this.numOfMatches++;
    	
    	if (this.numOfMatches > 20) {
    		this.provisional = false;
    	}
    }
}
