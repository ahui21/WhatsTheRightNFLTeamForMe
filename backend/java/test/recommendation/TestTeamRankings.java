package recommendation;

import java.io.*;
import java.util.Scanner;

public class TestTeamRankings {
	public static TeamRankings teamRankings;
	
	public static void main(String[] args) {
		teamRankings = new TeamRankings();
		
		teamRankings.populateData("resources/team-picking-categories.csv");
		
		teamRankings.print();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n\nChoose a team: ");
		String team = scanner.nextLine();
		
		System.out.println("Choose an attribute: ");
		String attribute = scanner.nextLine();
		
		System.out.println(teamRankings.getRankingByTeamAndAttribute(team, attribute));
		
		scanner.close();
	}
}
