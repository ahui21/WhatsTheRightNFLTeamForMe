package recommendation;

import java.util.Scanner;

public class TestEloMatch {
	private static EloMatch eloMatch;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		EloRankings eloRankings = new EloRankings();
		
		eloRankings.print();
		
		boolean continueTest = true;
		
		String category1, category2;
		EloRating eloRating1, eloRating2;
		
		while(continueTest) {
			System.out.println("Please enter the first rating category: ");
			category1 = scanner.nextLine();
			
			System.out.println("Please enter the second rating category: ");
			category2 = scanner.nextLine();
			
			System.out.println("Elo Match between " + category1 + " and " + category2 + " being initialized...");
			
			eloRating1 = eloRankings.getRating(category1);
			eloRating2 = eloRankings.getRating(category2);
			
			System.out.println("Elo Match between " + category1 + " (" + eloRating1.getRating() + ") and " + category2 + " (" + eloRating2.getRating() + ") initialized. Now calculating...");
			
			eloMatch = new EloMatch(eloRating1, eloRating2);
			
			System.out.println("Expected win percentage for " + category1 + ": " + eloMatch.expectedWinBy1());
			System.out.println("Expected win percentage for " + category2 + ": " + eloMatch.expectedWinBy2());
			
			System.out.println("Please enter the winner ('1' for " + category1 + " and '2' for " + category2 + "): ");
			int winner = scanner.nextInt();
			String temp = scanner.nextLine();
			
			eloMatch.winner(winner);
			
			eloRankings.print();
		}
		
		scanner.close();
	}
}
