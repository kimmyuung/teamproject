package dto;

import java.util.ArrayList;

public class Theater {
private int 관번호;
private String 관이름;
private String 관좌석;
private ArrayList<String> txy;

public Theater() {}



public Theater(int 관번호, String 관이름, String 관좌석, ArrayList<String> txy) {
	super();
	this.관번호 = 관번호;
	this.관이름 = 관이름;
	this.관좌석 = 관좌석;
	this.txy = txy;
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


public ArrayList<String> getTxy() {
	return txy;
}

public void setTxy(ArrayList<String> txy) {
	this.txy = txy;
}



}
