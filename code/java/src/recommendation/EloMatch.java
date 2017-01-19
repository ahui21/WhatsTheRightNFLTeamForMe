package recommendation;

public class EloMatch {
	private final int K_FACTOR1 = 25;
	private final int K_FACTOR2 = 50;
	
	private EloRating eloRating1;
	private EloRating eloRating2;
	
	public EloMatch() {
	}
	
	public EloMatch(EloRating eloRating1, EloRating eloRating2) {
		this.eloRating1 = eloRating1;
		this.eloRating2 = eloRating2;
	}

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!EloMatch.class.isAssignableFrom(o.getClass())) {
            return false;
        }
        final EloMatch r = (EloMatch) o;
        
        return (r.getEloRating1() == this.getEloRating1() && r.getEloRating2() == this.getEloRating2());
    }
	
	public void setEloRating1(EloRating eloRating1) {
		this.eloRating1 = eloRating1;
	}
	
	public void setEloRating2(EloRating eloRating2) {
		this.eloRating2 = eloRating2;
	}
	
	public EloRating getEloRating1() {
		return this.eloRating1;
	}
	
	public EloRating getEloRating2() {
		return this.eloRating2;
	}
	
	public double expectedWinBy1() {
		return 1/(1 + Math.pow(10, ((double)(this.eloRating2.getRating() - this.eloRating1.getRating()) / 25)));
	}
	
	public double expectedWinBy2() {
		return 1 - this.expectedWinBy1();
	}
	
	public void winner(int winner) {
		double newRating1;
		double newRating2;
		
		if (winner == 1) {if (this.eloRating1.getProvisional()) {
				newRating1 = this.eloRating1.getRating() + K_FACTOR2 * (1 - this.expectedWinBy1());
			} else {
				newRating1 = this.eloRating1.getRating() + K_FACTOR1 * (1 - this.expectedWinBy1());
			}
			
			if (this.eloRating2.getProvisional()) {
				newRating2 = this.eloRating2.getRating() + K_FACTOR2 * (0 - this.expectedWinBy2());
			} else {
				newRating2 = this.eloRating2.getRating() + K_FACTOR1 * (0 - this.expectedWinBy2());
			}
		} else if (winner == 2) {
			if (this.eloRating1.getProvisional()) {
				newRating1 = this.eloRating1.getRating() + K_FACTOR2 * (0 - this.expectedWinBy1());
			} else {
				newRating1 = this.eloRating1.getRating() + K_FACTOR1 * (0 - this.expectedWinBy1());
			}
			
			if (this.eloRating2.getProvisional()) {
				newRating2 = this.eloRating2.getRating() + K_FACTOR2 * (1 - this.expectedWinBy2());
			} else {
				newRating2 = this.eloRating2.getRating() + K_FACTOR1 * (1 - this.expectedWinBy2());
			}
		} else {
			throw new IllegalArgumentException("Invalid winner of match");
		}
		
		this.eloRating1.updateRating(newRating1);
		this.eloRating2.updateRating(newRating2);
	}
}
