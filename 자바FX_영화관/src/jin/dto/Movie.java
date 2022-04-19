package jin.dto;

public class Movie {
private String 영화제목;
private String 러닝타임;
private int 가격;
private String 연령등급;
public Movie() {}

public Movie(String 영화제목, String 러닝타임, int 가격, String 연령등급) {
	super();
	this.영화제목 = 영화제목;
	this.러닝타임 = 러닝타임;
	this.가격 = 가격;
	this.연령등급 = 연령등급;
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
}
