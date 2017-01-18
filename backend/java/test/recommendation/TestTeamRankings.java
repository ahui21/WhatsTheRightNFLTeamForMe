package recommendation;

import java.io.*;

public class TestTeamRankings {
	public static TeamRankings teamRankings;
	
	public static void main(String[] args) {
		teamRankings = new TeamRankings();
		
		teamRankings.populateData("resources/team-picking-categories.csv");
		
		teamRankings.print();
	}
}
