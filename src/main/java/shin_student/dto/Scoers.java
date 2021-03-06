package shin_student.dto;

public class Scoers {
	
	private Codes no;
	private	int subNo;
	private String subiect;
	private int scoer;
	
	

	public Scoers(Codes no, int subNo, String subiect, int scoer) {
		super();
		this.no = no;
		this.subNo = subNo;
		this.subiect = subiect;
		this.scoer = scoer;
	}
	
	

	@Override
	public String toString() {
		return String.format("Scoers [no=%s, subNo=%s, subiect=%s, scoer=%s]%n", no, subNo, subiect, scoer);
	}



	public Codes getNo() {
		return no;
	}



	public void setNo(Codes no) {
		this.no = no;
	}



	public int getSubNo() {
		return subNo;
	}



	public void setSubNo(int scorNo) {
		this.subNo = scorNo;
	}



	public String getSubiect() {
		return subiect;
	}



	public void setSubiect(String subiect) {
		this.subiect = subiect;
	}



	public int getScoer() {
		return scoer;
	}

	public void setScoer(int scoer) {
		this.scoer = scoer;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + subNo;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scoers other = (Scoers) obj;
		if (no != other.no)
			return false;
		return true;
	}

	



	

	



}
