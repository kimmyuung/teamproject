package HSB;

public class MovieTicket {
	private String 영화시간;
	private String 영화제목;
	private String 티켓번호;
	private String 인원수;
	
	public MovieTicket() {
		// TODO Auto-generated constructor stub
	}

	public MovieTicket(String 영화시간, String 영화제목, String 티켓번호, String 인원수) {
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

	public String get인원수() {
		return 인원수;
	}

	public void set인원수(String 인원수) {
		this.인원수 = 인원수;
	}
	
	
	
}
