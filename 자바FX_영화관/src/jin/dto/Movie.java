package jin.dto;

public class Movie {
private String ��ȭ����;
private String ����Ÿ��;
private int ����;
private String ���ɵ��;
public Movie() {}

public Movie(String ��ȭ����, String ����Ÿ��, int ����, String ���ɵ��) {
	super();
	this.��ȭ���� = ��ȭ����;
	this.����Ÿ�� = ����Ÿ��;
	this.���� = ����;
	this.���ɵ�� = ���ɵ��;
}

public String get��ȭ����() {
	return ��ȭ����;
}

public void set��ȭ����(String ��ȭ����) {
	this.��ȭ���� = ��ȭ����;
}
public String get����Ÿ��() {
	return ����Ÿ��;
}
public void set����Ÿ��(String ����Ÿ��) {
	this.����Ÿ�� = ����Ÿ��;
}
public int get����() {
	return ����;
}
public void set����(int ����) {
	this.���� = ����;
}

public String get���ɵ��() {
	return ���ɵ��;
}

public void set���ɵ��(String ���ɵ��) {
	this.���ɵ�� = ���ɵ��;
}
}
