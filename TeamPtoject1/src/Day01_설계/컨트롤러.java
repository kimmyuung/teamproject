package Day01_����;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ��Ʈ�ѷ� {
 
	
	
	
	���� ����޼��� = new ����();	// ��ü�����ϰ� ����Ʈ���� �����ص� �Ǵ°ǰ�?? �ް�����
	public static ArrayList<����> �Ѹ������帮��Ʈ = new ArrayList<>();
	
	// txt���Ͽ��� �ڹٷ� �о���̴� �޼���
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
					
//					���� ���� = new ����(field[0], field[1], field[2], field[3]);
//					�Ѹ������帮��Ʈ.add(������);	// �Ѹ������帮��Ʈ ����Ʈ�� ����.
				}
			}
			
		} catch (Exception e) {System.out.println("�������Ϸε� �޼��� ���� �߻�");}
	}	// �������Ϸε� �޼��� END
	
	
	public void ������������() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/���������.txt");	// 1. ���� ��� ��ü ����
			for(���� tmp : �Ѹ������帮��Ʈ) {
				String �������Ͽ������ڿ� = tmp.get����() + "," + tmp.get��() + "," + tmp.get��¥() + "," + tmp.get����ݾ�() + "\n";
				fileOutputStream.write(�������Ͽ������ڿ�.getBytes());
			}
		}catch(Exception e) {System.out.println("������������ �޼��� ���� �߻�");}
	}	// ������������ END
}	// class END
