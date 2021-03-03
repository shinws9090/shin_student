package shin_student.dto;

public class Codes {
	private int no;
	private String name;
	private int birthday;
	private int social;
	private Days dayno;
	private Department deptno;
	private int grade;
	private Attendings atdno;
	private Militarys miltno;

	

	public Codes(int no, String name, Attendings atdno) {
		super();
		this.no = no;
		this.name = name;
		this.atdno = atdno;
	}

	public Codes(int no, String name, int birthday, int social, Days dayno, Department deptno, int grade,
			Attendings atdno, Militarys miltno) {
		super();
		this.no = no;
		this.name = name;
		this.birthday = birthday;
		this.social = social;
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	@Override
	public String toString() {
		return String.format(
				"Codes [no=%s, name=%s, birthday=%s, social=%s, dayno=%s, deptno=%s, grade=%s, atdno=%s, miltno=%s]",
				no, name, birthday, social, dayno, deptno, grade, atdno, miltno);
	}

	

}
