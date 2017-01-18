package recommendation;

import java.util.*;

public class TestEloRankings {
	
	public static void main(String[] args) {		
		double[] highs = new double[100];
		double[] lows = new double[100];
		
		for (int i = 0; i < 100; i++) {
			EloRankings eloRankings = new EloRankings();
		
			boolean continueTest = true;
			int counter = 0;
			
			while(counter < 100) {
				counter++;
				eloRankings.print();
				eloRankings.nextMatch();
				System.out.println("On iteration #" + counter);
			}
			
			double high = 100;
			double low = 100;
			
			HashMap<String, EloRating> eloRatings = eloRankings.getEloRatings();
			
			Set set = eloRatings.entrySet();
			Iterator iterator = set.iterator();
			
			while(iterator.hasNext()) {
				Map.Entry mentry = (Map.Entry)iterator.next();
				
				if (((EloRating) (mentry.getValue())).getRating() < low) {
					low = ((EloRating) (mentry.getValue())).getRating();
				}
				
				if (((EloRating) (mentry.getValue())).getRating() > high) {
					high = ((EloRating) (mentry.getValue())).getRating();
				}
			}
			
			highs[i] = high;
			lows[i] = low;
		}
		
		System.out.println("\n\n\n");
		
		double sum = 0;
		
		for (int i = 0; i < highs.length; i++) {
			sum = sum + highs[i];
		}
		
		System.out.println("High average: " + sum/100);
		
		System.out.println("\n");
		
		sum = 0;
		
		for (int i = 0; i < lows.length; i++) {
			sum = sum + lows[i];
		}
		
		System.out.println("Low average: " + sum/100);
	}
}
