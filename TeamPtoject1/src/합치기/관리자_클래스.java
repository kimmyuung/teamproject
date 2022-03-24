package 합치기;

import java.time.LocalTime;

public class 관리자_클래스 {

	private String 영화제목;
	private String 영화시간;
	private String 음식이름;
	private int 음식가격;
	
	public 관리자_클래스() {}

	
	
	public 관리자_클래스(String 영화제목, String 영화시간) {
		super();
		this.영화제목 = 영화제목;
		this.영화시간 = 영화시간;
	}



	public 관리자_클래스(String 영화제목, String 영화시간, String 음식이름, int 음식가격) {
		super();
		this.영화제목 = 영화제목;
		this.영화시간 = 영화시간;
		this.음식이름 = 음식이름;
		this.음식가격 = 음식가격;
	}

	public String get영화제목() {
		return 영화제목;
	}

	public void set영화제목(String 영화제목) {
		this.영화제목 = 영화제목;
	}

	public String get영화시간() {
		return 영화시간;
	}

	public void set영화시간(String 영화시간) {
		this.영화시간 = 영화시간;
	}

	public String get음식이름() {
		return 음식이름;
	}

	public void set음식이름(String 음식이름) {
		this.음식이름 = 음식이름;
	}

	public int get음식가격() {
		return 음식가격;
	}

	public void set음식가격(int 음식가격) {
		this.음식가격 = 음식가격;
	}
	
	
}
