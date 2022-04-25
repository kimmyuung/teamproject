package dto;



public class Theater {
private int 관번호;
private String 관이름;
private String 관좌석;
private String 관좌표;

public Theater() {}



public Theater(int 관번호, String 관이름, String 관좌석,String 관좌표) {
	super();
	this.관번호 = 관번호;
	this.관이름 = 관이름;
	this.관좌석 = 관좌석;
	this.관좌표 = 관좌표;
}


public int get관번호() {
	return 관번호;
}
public void set관번호(int 관번호) {
	this.관번호 = 관번호;
}
public String get관이름() {
	return 관이름;
}
public void set관이름(String 관이름) {
	this.관이름 = 관이름;
}
public String get관좌석() {
	return 관좌석;
}
public void set관좌석(String 관좌석) {
	this.관좌석 = 관좌석;
}

public String get관좌표() {
	return 관좌표;
}

public void set관좌표(String 관좌표) {
	this.관좌표 = 관좌표;
}






}
