package shin_student.dto;

public class Militarys {
	private String miltno;
	private String military;

	public Militarys(String miltno) {
		super();
		this.miltno = miltno;
	}

	public Militarys(String miltno, String military) {
		super();
		this.miltno = miltno;
		this.military = military;
	}

	public String getMiltno() {
		return miltno;
	}

	public void setMiltno(String miltno) {
		this.miltno = miltno;
	}

	public String getMilitary() {
		return military;
	}

	public void setMilitary(String military) {
		this.military = military;
	}

	@Override
	public String toString() {
		return String.format("Militarys [miltno=%s, military=%s]", miltno, military);
	}

}
