/* 
 * 	1. ���� ����
 * 		��� : D:\java\���������.txt
 * 		���� ����
 * 			1. \n : ��
 * 			2. \t : ��
 * 			3. ,  : ��
 * 			
 * 		�ʵ�, �����ڴ� ����� �޼���δ� ��Ʈ�ѷ��� �ű��.
 * 		day10_07_Ű����ũ, �Ե����� ����.
 * 
 * 		Ŭ���� : car, ����, ��Ʈ�ѷ�, ����.
 * 
 */

package Day01_����;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Stack;

public class ���� {
	
	// 1. �ʵ�
	private int ����ݾ�;
	private int ��¥;
	private String ����;
	private String ��;

	// 2. ������
	public ����() { }
	
	public ����(int ����ݾ�, int ��¥, String ����, String ��) {
		this.����ݾ� = ����ݾ�;
		this.��¥ = ��¥;
		this.���� = ����;
		this.�� = ��;
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
	
	
	public void ������������(int ��¥, int �ݾ�) {
		try {	// FileInputStream ������ �Ϲݿ��� �߻�
			
			
			
			
			
			
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/���������.txt");
		} catch(Exception e) {}
	}
	
	
	public void �������Ϸε�() {
		try {	// FileInputStream ������ �Ϲݿ��� �߻�
		FileInputStream fileInputStream = new FileInputStream("D:/java/���������.txt");
		byte[] �ӽù���Ʈ�迭 = new byte[4096];	// �˳��ϰ� 4KB¥�� �ӽ������ ����Ʈ�� �迭 ����
		fileInputStream.read(�ӽù���Ʈ�迭);	// ���������.txt ���� �о���� ���� ����Ʈ�� �迭�� ����
		String ���ϳ��� = new String(�ӽù���Ʈ�迭);	// ����Ʈ�迭-> ���ڿ��� �̵�
		
		String[] ������ = ���ϳ���.split("\n");	
		
		for(String tmp : ������) {
			String[] ������ = tmp.split("/t");
			for(String tmp2 : ������) {
				// ���Ϸε��� ���� ������. ������ ��ĳ���� Ȯ���ϰ��� �ϼ� ����
				// �ް����� Day10_07 Ű����ũ, �Ե����� ����
			}
		}
		
		
		} catch (Exception e) {	}
	}	// ���Ϸε� �޼��� END 
	
	public void ��������ȣ��() {}
	

	
}