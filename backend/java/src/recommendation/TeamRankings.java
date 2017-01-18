package recommendation;

import java.util.*;
import java.io.*;

public class TeamRankings {
	private HashMap<String, int[]> teamRankings;
	private HashMap<String, Integer> correspondingColumns;
	
	public TeamRankings() {
		teamRankings = new HashMap<String, int[]>();
		correspondingColumns = new HashMap<String, Integer>();
	}
	
	public void print() {
		System.out.printf("%-20s \t", "TEAM NAME");
		
		String[] correspondingColumnsInArray = new String[correspondingColumns.size()];
		
		Set set = this.correspondingColumns.entrySet();
		Iterator iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			correspondingColumnsInArray[(int)mentry.getValue()] = (String)mentry.getKey();
		}
		
		for (int i = 0; i < correspondingColumnsInArray.length; i++) {
			System.out.print(correspondingColumnsInArray[i] + "\t");
		}
		
		System.out.println("\n");
        
		set = this.teamRankings.entrySet();
		iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			System.out.printf("%-20s:\t", mentry.getKey());
			
			for (int i = 0; i < this.correspondingColumns.size(); i++) {
				System.out.print(((int[])(mentry.getValue()))[i] + "\t");
			}
			
			System.out.println();
		}
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!TeamRankings.class.isAssignableFrom(o.getClass())) {
            return false;
        }
        final TeamRankings r = (TeamRankings) o;
        
        return (r.getTeamRankings() == this.getTeamRankings()) && (r.getCorrespondingColumns() == this.getCorrespondingColumns());
    }
    
    public void setTeamRankings(HashMap<String, int[]> teamRankings) {
    	this.teamRankings = teamRankings;
    }
    
    public void setCorrespondingColumns(HashMap<String, Integer> correspondingColumns) {
    	this.correspondingColumns = correspondingColumns;
    }
    
    public HashMap<String, int[]> getTeamRankings() {
    	return this.teamRankings;
    }
    
    public HashMap<String, Integer> getCorrespondingColumns() {
    	return this.correspondingColumns;
    }
	
	public void populateData(String fileLocation) {
		String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
        	boolean firstLine = true;
        	
        	while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] lineSeparatedByCommas = line.split(cvsSplitBy);

        		if (firstLine) {
        			for (int i = 1; i < lineSeparatedByCommas.length; i++)
        			{
        				correspondingColumns.put(lineSeparatedByCommas[i], i - 1);
        			}
        			
        			firstLine = false;
        		} else {
        			int[] newLineSeparatedByCommas = new int[lineSeparatedByCommas.length];
        			for (int i = 1; i < lineSeparatedByCommas.length; i++) {
        				newLineSeparatedByCommas[i - 1] = Integer.parseInt(lineSeparatedByCommas[i]);
        			}
        			teamRankings.put(lineSeparatedByCommas[0], newLineSeparatedByCommas);
        		}
        	}

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public int getRankingByTeamAndAttribute(String team, String attribute) {
		int correspondingColumn = this.correspondingColumns.get(attribute);
		
		return this.teamRankings.get(team)[correspondingColumn];
	}
}
