package recommendation;

import java.io.*;
import java.util.Scanner;

public class TestWeightedRankings {
	public static TeamRankings teamRankings;
	
	public static void main(String[] args) {
		WeightedRankings weightedRankings = new WeightedRankings();
		
		weightedRankings.print();
		weightedRankings.nextMatch();
	}
}
