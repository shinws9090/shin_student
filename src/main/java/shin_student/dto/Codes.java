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

	public Codes(int no) {
		super();
		this.no = no;
	}

	

	public Codes(Days dayno, Department deptno, int grade, Attendings atdno) {
		super();
		this.dayno = dayno;
		this.deptno = deptno;
		this.grade = grade;
		this.atdno = atdno;
	}



	public Codes(int no, String name, Department deptno, int grade) {
		super();
		this.no = no;
		this.name = name;
		this.deptno = deptno;
		this.grade = grade;
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

	public Codes(int social, int grade, Attendings atdno, Militarys miltno) {
		super();
		this.social = social;
		this.grade = grade;
		this.atdno = atdno;
		this.miltno = miltno;
	}

	public Codes(Department deptno, int grade) {
		this.deptno = deptno;
		this.grade = grade;
	}

	public Codes(int no, String name, Department deptno) {
		this.no = no;
		this.name = name;
		this.deptno = deptno;
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
				"[no=%s, name=%s , grade =%s]",
				no, name, grade);
	}
//	@Override
//	public String toString() {
//		return String.format(
//				"Codes [no=%s, name=%s, birthday=%s, social=%s, dayno=%s, deptno=%s, grade=%s, atdno=%s, miltno=%s]",
//				no, name, birthday, social, dayno, deptno, grade, atdno, miltno);
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no;
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
		Codes other = (Codes) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no != other.no)
			return false;
		return true;
	}

	

}
