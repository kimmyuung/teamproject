/* 
 * 	1. ���� ���� ��� : D:\java\���������.txt
 * 	
 * 	2. ��Ʈ�ѷ��� �޼���� �̻��Ű��
 */

package Day01_����;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ���� {
	
	// 1. �ʵ�
	private int ����ݾ�;
	private String ��¥;
	private String ��;
	private String ����;

	// 2. ������
	
	public ����() { }		// ���������
	
	// ��Ʈ�ѷ�.����, �ε� �޼��尡 ����� Ǯ ������
	public ����(int ����ݾ�, String ��¥, String ��,String ����) {	
		this.����ݾ� = ����ݾ�;
		this.��¥ = ��¥;
		this.�� = ��;
		this.���� = ����;
	}
	
	public ����(int ����ݾ�) {
		this.����ݾ� = ����ݾ�;
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy��");
		this.���� = dateformat.format(date);
		dateformat = new SimpleDateFormat("MM��");
		this.�� = dateformat.format(date);
		dateformat = new SimpleDateFormat("dd��");
		this.��¥ = dateformat.format(date);
	}
	
	// ��Ʈ�ѷ�.������� �޼��忡�� ���ϰ� ��üȭ������ �� ������
	public ����(int ����ݾ�, String ��¥) {
		this.����ݾ� = ����ݾ�;
		this.��¥ = ��¥;
	}

	// 3. �޼���
	public int get����ݾ�() {
		return ����ݾ�;
	}

	public void set����ݾ�(int ����ݾ�) {
		this.����ݾ� = ����ݾ�;
	}

	public String get����() {
		return ����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}

	public String get��() {
		return ��;
	}

	public void set��(String ��) {
		this.�� = ��;
	}
	
	public String get��¥() {
		return ��¥;
	}

	public void set��¥(String ��¥) {
		this.��¥ = ��¥;
	}

	
}