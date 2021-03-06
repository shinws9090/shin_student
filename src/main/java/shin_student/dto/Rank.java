package shin_student.dto;

public class Rank {
	private String rank;
	private double rankSco;
	
	public Rank(String rank, double rankSco) {
		super();
		this.rank = rank;
		this.rankSco = rankSco;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public double getRankSco() {
		return rankSco;
	}
	public void setRankSco(double rankSco) {
		this.rankSco = rankSco;
	}
	
}
