package shin_student.dto;

public class ScoPrint {
	private Codes code;
	private int sub1;
	private int sub2;
	private int sub3;
	private int total;
	private double avg;
	private String rank;
	private double rankSco;
	
	
	public ScoPrint(Codes code, int sub1, int sub2, int sub3) {
		super();
		this.code = code;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	
	}
	
	public Codes getCode() {
		return code;
	}
	public void setCode(Codes code) {
		this.code = code;
	}
	public int getSub1() {
		return sub1;
	}
	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}
	public int getSub2() {
		return sub2;
	}
	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}
	public int getSub3() {
		return sub3;
	}
	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
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

	@Override
	public String toString() {
		return String.format("ScoPrint [code=%s, sub1=%s, sub2=%s, sub3=%s, total=%s, avg=%s, rank=%s, rankSco=%s]%n",
				code, sub1, sub2, sub3, total, avg, rank, rankSco);
	}
	

	
	
	

}
