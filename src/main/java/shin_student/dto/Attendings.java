package shin_student.dto;

public class Attendings {
	private String atdno;
	private String attending;

	public Attendings(String atdno) {
		super();
		this.atdno = atdno;
	}

	

	public Attendings(String atdno, String attending) {
		super();
		this.atdno = atdno;
		this.attending = attending;
	}



	public String getAtdno() {
		return atdno;
	}

	public void setAtdno(String atdno) {
		this.atdno = atdno;
	}

	public String getAttending() {
		return attending;
	}

	public void setAttending(String attending) {
		this.attending = attending;
	}

	@Override
	public String toString() {
		return String.format("Attenfings [atdno=%s, attending=%s]", atdno, attending);
	}

}
