package shin_student.dto;

public class Ranking {
	private String rank;
	private double rankSoc;

	public Ranking() {
	}

	public Ranking(String rank, double ranksoc) {
		super();
		this.rank = rank;
		this.rankSoc = ranksoc;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public double getRanksoc() {
		return rankSoc;
	}

	public void setRanksoc(double ranksoc) {
		this.rankSoc = ranksoc;
	}

	@Override
	public String toString() {
		return String.format("Ranking [rank=%s, ranksoc=%s]", rank, rankSoc);
	}

}
