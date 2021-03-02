package shin_student.dto;

public class Militarys {
	private int miltno;
	private String military;
	public Militarys(int miltno) {
		super();
		this.miltno = miltno;
	}
	public Militarys(int miltno, String military) {
		super();
		this.miltno = miltno;
		this.military = military;
	}
	public int getMiltno() {
		return miltno;
	}
	public void setMiltno(int miltno) {
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
