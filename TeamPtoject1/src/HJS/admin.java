package HJS;

import java.time.LocalTime;

public class admin {

	private String ��ȭ����;
	private String ��ȭ�ð�;
	private String �����̸�;
	private int ���İ���;
	
	public admin() {}

	
	
	public admin(String ��ȭ����, String ��ȭ�ð�) {
		super();
		this.��ȭ���� = ��ȭ����;
		this.��ȭ�ð� = ��ȭ�ð�;
	}



	public admin(String ��ȭ����, String ��ȭ�ð�, String �����̸�, int ���İ���) {
		super();
		this.��ȭ���� = ��ȭ����;
		this.��ȭ�ð� = ��ȭ�ð�;
		this.�����̸� = �����̸�;
		this.���İ��� = ���İ���;
	}

	public String get��ȭ����() {
		return ��ȭ����;
	}

	public void set��ȭ����(String ��ȭ����) {
		this.��ȭ���� = ��ȭ����;
	}

	public String get��ȭ�ð�() {
		return ��ȭ�ð�;
	}

	public void set��ȭ�ð�(String ��ȭ�ð�) {
		this.��ȭ�ð� = ��ȭ�ð�;
	}

	public String get�����̸�() {
		return �����̸�;
	}

	public void set�����̸�(String �����̸�) {
		this.�����̸� = �����̸�;
	}

	public int get���İ���() {
		return ���İ���;
	}

	public void set���İ���(int ���İ���) {
		this.���İ��� = ���İ���;
	}
	
	
}
