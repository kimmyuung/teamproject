/* 
 * 	1. ���� ����
 * 		��� : D:\java\���������.txt
 * 	
 * 	2. ��Ʈ�ѷ��� �޼���� �̻��Ű��
 */

package Day01_����;

public class ���� {
	
	// 1. �ʵ�
	private int ����ݾ�;
	private int ��¥;
	private String ��;
	private String ����;

	// 2. ������
	public ����() { }
	
	public ����(int ����ݾ�, int ��¥, String ��,String ����) {
		this.����ݾ� = ����ݾ�;
		this.��¥ = ��¥;
		this.�� = ��;
		this.���� = ����;
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
	
	public int get��¥() {
		return ��¥;
	}

	public void set��¥(int ��¥) {
		this.��¥ = ��¥;
	}

	
}