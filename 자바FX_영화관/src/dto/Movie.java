package dto;


public class Movie {
	private int 영화번호;
	private String 영화제목;
	private String 러닝타임;
	private int 가격;
	private String 연령등급;
	private String 이미지;
public Movie() {}

public Movie( int 영화번호, String 영화제목, String 러닝타임, int 가격, String 연령등급,String 이미지) {
	super();
	this.영화번호 = 영화번호;
	this.영화제목 = 영화제목;
	this.러닝타임 = 러닝타임;
	this.가격 = 가격;
	this.연령등급 = 연령등급;
	this.이미지= 이미지;
}


public int get영화번호() {
	return 영화번호;
}
public void set영화번호(int 영화번호) {
	this.영화번호 = 영화번호;
}

	public String get영화제목() {
		return 영화제목;
	}
	public void set영화제목(String 영화제목) {
		this.영화제목 = 영화제목;
	}
	public String get러닝타임() {
		return 러닝타임;
	}
	public void set러닝타임(String 러닝타임) {
		this.러닝타임 = 러닝타임;
	}
	public int get가격() {
		return 가격;
	}
	public void set가격(int 가격) {
		this.가격 = 가격;
	}
	
	public String get연령등급() {
		return 연령등급;
	}
	
	public void set연령등급(String 연령등급) {
		this.연령등급 = 연령등급;
	}
	public String get이미지() {
		return 이미지;
	}
	
	public void set이미지(String 이미지) {
		this.이미지= 이미지;
	}
}
