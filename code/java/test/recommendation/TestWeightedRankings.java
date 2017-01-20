package recommendation;

import java.io.*;
import java.util.Scanner;

public class TestWeightedRankings {
	public static TeamRankings teamRankings;
	
	public static void main(String[] args) {
		WeightedRankings weightedRankings = new WeightedRankings();
		
		weightedRankings.print();
		
		int counter = 0;
		
		while(counter < 100) {
			counter++;
			weightedRankings.print();
			weightedRankings.nextMatch();
			System.out.println("On iteration #" + counter);
		}
	}
}
