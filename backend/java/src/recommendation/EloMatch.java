package recommendation;

public class EloMatch {
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
	
	private double expectedWinBy1() {
		return 1/(1 + Math.pow(10, ((this.eloRating1.getRating() - this.eloRating2.getRating()) / 25)));
	}
	
	private double expectedWinBy2() {
		return 1 - this.expectedWinBy1();
	}
}
