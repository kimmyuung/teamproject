package dto;


public class Movie {
	private int ��ȭ��ȣ;
	private String ��ȭ����;
	private String ����Ÿ��;
	private int ����;
	private String ���ɵ��;
	private String �̹���;
public Movie() {}

public Movie( int ��ȭ��ȣ, String ��ȭ����, String ����Ÿ��, int ����, String ���ɵ��,String �̹���) {
	super();
	this.��ȭ��ȣ = ��ȭ��ȣ;
	this.��ȭ���� = ��ȭ����;
	this.����Ÿ�� = ����Ÿ��;
	this.���� = ����;
	this.���ɵ�� = ���ɵ��;
	this.�̹���= �̹���;
}


public int get��ȭ��ȣ() {
	return ��ȭ��ȣ;
}
public void set��ȭ��ȣ(int ��ȭ��ȣ) {
	this.��ȭ��ȣ = ��ȭ��ȣ;
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
	public String get�̹���() {
		return �̹���;
	}
	
	public void set�̹���(String �̹���) {
		this.�̹���= �̹���;
	}
}
