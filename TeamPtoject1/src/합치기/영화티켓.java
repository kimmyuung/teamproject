package 합치기;

public class 영화티켓 {
	private String 영화시간;
	private String 영화제목;
	private String 티켓번호;
	private int 인원수;
	
	public 영화티켓() {
		// TODO Auto-generated constructor stub
	}

	public 영화티켓(String 영화시간, String 영화제목, String 티켓번호, int 인원수) {
		super();
		this.영화시간 = 영화시간;
		this.영화제목 = 영화제목;
		this.티켓번호 = 티켓번호;
		this.인원수 = 인원수;
	}

	public String get영화시간() {
		return 영화시간;
	}

	public void set영화시간(String 영화시간) {
		this.영화시간 = 영화시간;
	}

	public String get영화제목() {
		return 영화제목;
	}

	public void set영화제목(String 영화제목) {
		this.영화제목 = 영화제목;
	}

	public String get티켓번호() {
		return 티켓번호;
	}

	public void set티켓번호(String 티켓번호) {
		this.티켓번호 = 티켓번호;
	}

	public int get인원수() {
		return 인원수;
	}

	public void set인원수(int 인원수) {
		this.인원수 = 인원수;
	}
	
	
	
}
