package shin_student.dto;

public class Days {
	private int dayno;
	private String day;

	public Days(int dayno) {
		super();
		this.dayno = dayno;
	}

	public Days(int dayno, String day) {
		super();
		this.dayno = dayno;
		this.day = day;
	}

	public int getDayno() {
		return dayno;
	}

	public void setDayno(int dayno) {
		this.dayno = dayno;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return String.format("Days [dayno=%s, day=%s]", dayno, day);
	}

}
