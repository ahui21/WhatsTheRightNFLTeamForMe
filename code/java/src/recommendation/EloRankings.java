package recommendation;

import java.util.*;

public class EloRankings {
	/**Elo Rankings*/
	private HashMap<String, EloRating> eloRatings;
	
	private Random rand = new Random();
	private Scanner scanner;
	private boolean temp = true;
	
	private String[] listOfCategories = {"FRL", "OWN", "PLA", "FUT",
										 "BWG", "TRD", "BNG", "BEH",
										 "NYP", "SLP", "AFF", "SMK",
										 "STX", "CCH", "UNI", "BMK"};
	
	public EloRankings() {
		this.eloRatings = new HashMap<String, EloRating>();
		
		for (int i = 0; i < listOfCategories.length; i++) {
			this.updateRating(listOfCategories[i], new EloRating(100));
		}

    	this.scanner = new Scanner(System.in);
	}
	
	public void print() {
		Set set = this.eloRatings.entrySet();
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
    	this.eloRatings.put(category, rating);
    }
    
    public EloRating getRating(String category) {
    	return eloRatings.get(category);
    }
    
    public EloMatch getNextMatch() {
    	int firstEloRating = rand.nextInt(this.listOfCategories.length);
    	int secondEloRating = firstEloRating;
    	
    	while (secondEloRating == firstEloRating) {
    		secondEloRating = rand.nextInt(this.listOfCategories.length);
    	}
    	
    	EloMatch eloMatch = new EloMatch(eloRatings.get(this.listOfCategories[firstEloRating]), this.eloRatings.get(this.listOfCategories[secondEloRating]));
		
    	System.out.println("Elo Match between " + this.listOfCategories[firstEloRating] + " and " + this.listOfCategories[secondEloRating] + " being initialized...");
		
		System.out.println("Elo Match between " + this.listOfCategories[firstEloRating] + " (" + this.eloRatings.get(this.listOfCategories[firstEloRating]).getRating() + ") and " + this.listOfCategories[secondEloRating] + " (" + this.eloRatings.get(this.listOfCategories[secondEloRating]).getRating() + ") initialized. Now calculating...");
		
		System.out.println("Expected win percentage for " + this.listOfCategories[firstEloRating] + ": " + eloMatch.expectedWinBy1());
		System.out.println("Expected win percentage for " + this.listOfCategories[secondEloRating] + ": " + eloMatch.expectedWinBy2());
		
		if ((this.listOfCategories[firstEloRating].compareTo(this.listOfCategories[secondEloRating])) < 0) {
			temp = true;
		} else {
			temp = false;
		}
		
		return eloMatch;
    }
    
    public void nextMatch() {
    	EloMatch eloMatch = this.getNextMatch();
    	
    	int winner = this.getWinner();
		
		eloMatch.winner(winner);
    }
    
    public int getWinner() {    	
    	/**System.out.println("Please enter the winner (1 or 2):");
    	
    	return scanner.nextInt();*/
    	
    	//return rand.nextInt(2) + 1;
    	
    	if (temp) {
    		return 1;
    	} else {
    		return 2;
    	}
    }
}
