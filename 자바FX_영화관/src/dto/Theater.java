package dto;

import java.util.ArrayList;

public class Theater {
private int ����ȣ;
private String ���̸�;
private String ���¼�;
private ArrayList<String> txy;

public Theater() {}



public Theater(int ����ȣ, String ���̸�, String ���¼�, ArrayList<String> txy) {
	super();
	this.����ȣ = ����ȣ;
	this.���̸� = ���̸�;
	this.���¼� = ���¼�;
	this.txy = txy;
}


public int get����ȣ() {
	return ����ȣ;
}
public void set����ȣ(int ����ȣ) {
	this.����ȣ = ����ȣ;
}
public String get���̸�() {
	return ���̸�;
}
public void set���̸�(String ���̸�) {
	this.���̸� = ���̸�;
}
public String get���¼�() {
	return ���¼�;
}
public void set���¼�(String ���¼�) {
	this.���¼� = ���¼�;
}


public ArrayList<String> getTxy() {
	return txy;
}

public void setTxy(ArrayList<String> txy) {
	this.txy = txy;
}



}
