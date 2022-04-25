	package dto;

public class Ticket {
private int 가격;
private String 영화제목;
private int 인원수;
private String 관이름;
private String 날짜;
private String 좌석;
public Ticket() {}
public Ticket(int 가격, String 영화제목, int 인원수, String 관이름, String 날짜, String 좌석) {
	super();
	this.가격 = 가격;
	this.영화제목 = 영화제목;
	this.인원수 = 인원수;
	this.관이름 = 관이름;
	this.날짜 = 날짜;
	this.좌석 = 좌석;
	
	
}
public int get가격() {
	return 가격;
}
public void set가격(int 가격) {
	this.가격 = 가격;
}
public String get영화제목() {
	return 영화제목;
}
public void set영화제목(String 영화제목) {
	this.영화제목 = 영화제목;
}
public int get인원수() {
	return 인원수;
}
public void set인원수(int 인원수) {
	this.인원수 = 인원수;
}
public String get관이름() {
	return 관이름;
}
public void set관이름(String 관이름) {
	this.관이름 = 관이름;
}
public String get날짜() {
	return 날짜;
}
public void set날짜(String 날짜) {
	this.날짜 = 날짜;
}
public String get좌석() {
	return 좌석;
}
public void set좌석(String 좌석) {
	this.좌석 = 좌석;
}
}
