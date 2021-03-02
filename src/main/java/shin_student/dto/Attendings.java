package shin_student.dto;

public class Attendings {
	private int atdno;
	private String attending;

	public Attendings(int atdno) {
		super();
		this.atdno = atdno;
	}

	public Attendings(int atdno, String attending) {
		super();
		this.atdno = atdno;
		this.attending = attending;
	}

	public int getAtdno() {
		return atdno;
	}

	public void setAtdno(int atdno) {
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
