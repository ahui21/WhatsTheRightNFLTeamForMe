package recommendation;

public class EloRating {
	/**Elo Rating*/
	private String category;
	private int rating;
	private int numOfMatches = 0;
	
	public EloRating() {
	}
	
	public EloRating(String category, int rating) {
		this.category = category;
		this.rating = rating;
	}
	
	public void print() {
        if (numOfMatches <= 20) {
        	System.out.println("PROVISIONAL ELO RATING for " + this.category + ": " + this.rating);
        } else {
        	System.out.println("ELO RATING for " + this.category + ": " + this.rating);
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
        
        return (r.getCategory() == this.getCategory() && r.getRating() == this.getRating() && r.getNumOfMatches() == this.getNumOfMatches());
    }
    
    public void setCategory(String category) {
    	this.category = category;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public void setNumOfMatches(int numOfMatches) {
    	this.numOfMatches = numOfMatches;
    }
    
    public String getCategory() {
    	return this.category;
    }

    public int getRating() {
        return this.rating;
    }
    
    public int getNumOfMatches() {
    	return this.numOfMatches;
    }
    
    public void updateRating(int rating) {
    	this.rating = rating;
    	this.numOfMatches++;
    }
}
