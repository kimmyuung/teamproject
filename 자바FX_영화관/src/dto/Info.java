package dto;

public class Info {

	private int num;
	private String movie;
	private String time;
	private String name;
	private String grade;
	
	public Info() {}

	public Info(int num, String movie, String time, String name, String grade) {
		super();
		this.num = num;
		this.movie = movie;
		this.time = time;
		this.name = name;
		this.grade = grade;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
