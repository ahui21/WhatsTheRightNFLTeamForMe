package recommendation;

import java.util.*;

public class EloRankings {
	/**Elo Rankings*/
	private HashMap<String, EloRating> eloRatings;
	private Random rand = new Random();
	
	private boolean temp = true;
	
	private String[] listOfCategories = {"FRL", "OWN", "PLA", "FUT",
										 "BWG", "TRD", "BNG", "BEH",
										 "NYP", "SLP", "AFF", "SMK",
										 "STX", "CCH", "UNI", "BMK"};
	
	public EloRankings() {
		eloRatings = new HashMap<String, EloRating>();
		
		for (int i = 0; i < listOfCategories.length; i++) {
			this.updateRating(listOfCategories[i], new EloRating(1500));
		}
	}
	
	public void print() {
		Set set = eloRatings.entrySet();
		Iterator iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			System.out.println(mentry.getKey() + ": " + ((EloRating) (mentry.getValue())).getRating());
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
    
    public EloMatch getNextMatch() {
    	int firstEloRating = rand.nextInt(listOfCategories.length);
    	int secondEloRating = firstEloRating;
    	
    	while (secondEloRating == firstEloRating) {
    		secondEloRating = rand.nextInt(listOfCategories.length);
    	}
    	
    	EloMatch eloMatch = new EloMatch(eloRatings.get(listOfCategories[firstEloRating]), eloRatings.get(listOfCategories[secondEloRating]));
		
    	System.out.println("Elo Match between " + listOfCategories[firstEloRating] + " and " + listOfCategories[secondEloRating] + " being initialized...");
		
		System.out.println("Elo Match between " + listOfCategories[firstEloRating] + " (" + eloRatings.get(listOfCategories[firstEloRating]).getRating() + ") and " + listOfCategories[secondEloRating] + " (" + eloRatings.get(listOfCategories[secondEloRating]).getRating() + ") initialized. Now calculating...");
		
		System.out.println("Expected win percentage for " + listOfCategories[firstEloRating] + ": " + eloMatch.expectedWinBy1());
		System.out.println("Expected win percentage for " + listOfCategories[secondEloRating] + ": " + eloMatch.expectedWinBy2());
    	
    	if (listOfCategories[firstEloRating].compareTo(listOfCategories[secondEloRating]) < 0) {
    		temp = true;
    	} else {
    		temp = false;
    	}
		
		return eloMatch;
    }
    
    public void nextMatch() {
    	EloMatch eloMatch = this.getNextMatch();
    	
    	int winner;
    	
    	if (temp) {
    		winner = 1;
    	} else {
    		winner = 2;
    	}
		
		eloMatch.winner(winner);
    }
}
