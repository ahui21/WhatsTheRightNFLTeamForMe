package recommendation;

import java.util.*;

public class EloRankings {
	/**Elo Rankings*/
	private HashMap<String, EloRating> eloRatings;
	
	private String[] listOfCategories = {"FRL", "OWN", "PLA", "FUT",
										 "BWG", "TRD", "BNG", "BEH",
										 "NYP", "SLP", "AFF", "SMK",
										 "STX", "CCH", "UNI", "BMK"};
	
	public EloRankings() {
		eloRatings = new HashMap<String, EloRating>();
		
		for (int i = 0; i < listOfCategories.length; i++) {
			this.updateRating(listOfCategories[i], new EloRating(100));
		}
	}
	
	public void print() {
		Set set = eloRatings.entrySet();
		Iterator iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			System.out.println("The Elo Rating for "+ mentry.getKey() + " is " + ((EloRating) (mentry.getValue())).getRating());
		}
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!EloRankings.class.isAssignableFrom(o.getClass())) {
            return false;
        }
        final EloRankings r = (EloRankings) o;
        
        return (r.getEloRatings() == this.getEloRatings());
    }
    
    public void setEloRatings(HashMap<String, EloRating> eloRatings) {
    	this.eloRatings = eloRatings;
    }
    
    public HashMap<String, EloRating> getEloRatings() {
    	return this.eloRatings;
    }
    
    public void updateRating(String category, EloRating rating) {
    	eloRatings.put(category, rating);
    }
    
    public EloRating getRating(String category) {
    	return eloRatings.get(category);
    }
}
