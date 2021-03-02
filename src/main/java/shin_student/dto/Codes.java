package shin_student.dto;

public class Codes extends Students {
	private Days dayno;
	private Department deptno;
	private int grade;
	private Attendings atdno;
	private Militarys miltno;

	public Codes(int no) {
		super(no);
		// TODO Auto-generated constructor stub
	}

	public Codes(int no, Days dayno, Department deptno, int grade, Attendings atdno, Militarys miltno) {
		super(no);
		this.dayno = dayno;
		this.deptno = deptno;
		this.grade = grade;
		this.atdno = atdno;
		this.miltno = miltno;
	}

	public Days getDayno() {
		return dayno;
	}

	public void setDayno(Days dayno) {
		this.dayno = dayno;
	}

	public Department getDeptno() {
		return deptno;
	}

	public void setDeptno(Department deptno) {
		this.deptno = deptno;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Attendings getAtdno() {
		return atdno;
	}

	public void setAtdno(Attendings atdno) {
		this.atdno = atdno;
	}

	public Militarys getMiltno() {
		return miltno;
	}

	public void setMiltno(Militarys miltno) {
		this.miltno = miltno;
	}

	@Override
	public String toString() {
		return String.format("Codes [dayno=%s, deptno=%s, grade=%s, atdno=%s, miltno=%s]", dayno, deptno, grade, atdno,
				miltno);
	}

}
