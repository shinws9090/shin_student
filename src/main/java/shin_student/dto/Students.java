package shin_student.dto;

public class Students {
	private int no;
	private String name;
	private int birthday;
	private int social;

	public Students(int no) {
		super();
		this.no = no;
	}

	public Students(int no, String name, int birthday, int social) {
		super();
		this.no = no;
		this.name = name;
		this.birthday = birthday;
		this.social = social;
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
		return String.format("Students [no=%s, name=%s, birthday=%s, social=%s]", no, name, birthday, social);
	}

}
