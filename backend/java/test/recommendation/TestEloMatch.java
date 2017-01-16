package recommendation;

import java.util.Scanner;

public class TestEloMatch {
	
	public static void main(String[] args) {		
		EloRankings eloRankings = new EloRankings();
		
		boolean continueTest = true;
		
		while(continueTest) {
			eloRankings.print();
			eloRankings.nextMatch();
		}
	}
}
