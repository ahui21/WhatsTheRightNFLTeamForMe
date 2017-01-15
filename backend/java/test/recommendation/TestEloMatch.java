package recommendation;

import java.util.Scanner;

public class TestEloMatch {
	private static EloMatch eloMatch;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter the first rating category: ");
		String category1 = scanner.nextLine();
		
		System.out.println("Please enter the second rating category: ");
		String category2 = scanner.nextLine();
		
		System.out.println("Elo Match between " + category1 + " and " + category2 + " being initialized...");
		
		System.out.println("Please enter the Elo rating for " + category1 + ":");
		int rating1 = scanner.nextInt();
		
		System.out.println("Please enter the Elo rating for " + category2 + ":");
		int rating2 = scanner.nextInt();
		
		System.out.println("Elo Match between " + category1 + " (" + rating1 + ") and " + category2 + " (" + rating2 + ") initialized. Now calculating...");
		
		EloRating eloRating1 = new EloRating(category1, rating1);
		EloRating eloRating2 = new EloRating(category2, rating2);
		
		eloMatch = new EloMatch(eloRating1, eloRating2);
		
		eloMatch.getEloRating1().print();
		eloMatch.getEloRating2().print();
		
		System.out.println("Expected win percentage for " + category1 + ": " + eloMatch.expectedWinBy1());
		System.out.println("Expected win percentage for " + category2 + ": " + eloMatch.expectedWinBy2());
		
		boolean continueTest = true;
		
		while(continueTest) {
			System.out.println("Please enter the winner ('1' for " + category1 + " and '2' for " + category2 + "): ");
			int winner = scanner.nextInt();
			
			eloMatch.winner(winner);
			
			eloMatch.getEloRating1().print();
			eloMatch.getEloRating2().print();
		}
		
		scanner.close();
	}
}
