package recommendation;

public class TestEloMatch {
	
	public static void main(String[] args) {		
		EloRankings eloRankings = new EloRankings();
		
		boolean continueTest = true;
		int counter = 0;
		
		while(counter < 100) {
			counter++;
			eloRankings.print();
			eloRankings.nextMatch();
			System.out.println("On iteration #" + counter);
		}
	}
}
