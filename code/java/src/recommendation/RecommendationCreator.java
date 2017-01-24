package recommendation;

import java.util.*;

public class RecommendationCreator {
	private WeightedRankings weightedRankings;
	private Recommendation[] recommendations;
	
	public RecommendationCreator() {
		this.weightedRankings = new WeightedRankings();
		this.recommendations = new Recommendation[32];
	}
	
	public void print() {
		this.sort();
		
		for (int i = 0; i < this.recommendations.length; i++) {
			this.recommendations[i].print();
		}
	}
	
	public void setWeightedRankings(WeightedRankings weightedRankings) {
		this.weightedRankings = weightedRankings;
	}
	
	public void setRecommendations(Recommendation[] recommendations) {
		this.recommendations = recommendations;
	}
	
	public WeightedRankings getWeightedRankings() {
		return this.weightedRankings;
	}
	
	public Recommendation[] getRecommendations() {
		return this.recommendations;
	}
	
	public void sort() {
		
	}
	
	public Recommendation[] getRecommendations(int numberOfRecommendations) {
		return Arrays.copyOfRange(this.recommendations, 0, numberOfRecommendations);
	}
}
