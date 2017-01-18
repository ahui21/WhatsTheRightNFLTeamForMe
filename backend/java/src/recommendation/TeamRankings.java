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
}
