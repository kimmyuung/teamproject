package Day01_����;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ��Ʈ�ѷ� {
 
	
	
	
	���� ����޼��� = new ����();	// ��ü�����ϰ� ����Ʈ���� �����ص� �Ǵ°ǰ�?? �ް�����
	public static ArrayList<����> �Ѹ������帮��Ʈ = new ArrayList<>();
	
	
	// �ֿܼ��� �Է¹��� ������ ���� �������� ���� ���⳻���� ArrayList�� ����
	public ArrayList<����> �������(int ����, int ��) {	// mainŬ���� �ֿܼ��� ������ ���� �Է¹޾� ���޹޴´�.
		ArrayList<����> ���ϸ��� = new ArrayList<>();
		/*
		 * 	1. int�� ���޹��� ������ ���� String���� ��ȯ.
		 *  2. �Ѹ������帮��Ʈ ArrayList���� ������ ���� �������� �˻�.
		 *  3. ���ϸ��� ArrayList�� ��¥, ����ݾ� ��üȭ.
		 *  4. mainŬ������ ����!
		 */
		
		String ã������ = ����+"��";	// int -> String + ���� ��ȯ	ex) 2020 -> "2020��"
		String ã���� = ��+"��";	// ��
		
		
		if(�Ѹ������帮��Ʈ.contains(ã������) && �Ѹ������帮��Ʈ.contains(ã����)) {	
			for(���� tmp : �Ѹ������帮��Ʈ) {
				
			}
		}
		
		return ���ϸ���;
	}
	
	// txt���Ͽ��� java�� �о���̴� �޼���
	public void �������Ϸε�() {
		try {	// FileInputStream ������ �Ϲݿ��� �߻�
			FileInputStream fileInputStream = new FileInputStream("D:/java/���������.txt");
			byte[] �ӽù���Ʈ�迭 = new byte[4096];	// �˳��ϰ� 4KB¥�� �ӽ������ ����Ʈ�� �迭 ����
			fileInputStream.read(�ӽù���Ʈ�迭);	// ���������.txt ���� �о���� ���� ����Ʈ�� �迭�� ����
			String ���ϳ��� = new String(�ӽù���Ʈ�迭);	// ����Ʈ�迭-> ���ڿ��� �̵�
			
			String[] ���ϳ���迭 = ���ϳ���.split("\n");	
			
			for(String tmp : ���ϳ���迭) {
				String[] �ӽù迭 = tmp.split("/t");
					���� ���� = new ����(Integer.parseInt(�ӽù迭[0]), �ӽù迭[1], �ӽù迭[2], �ӽù迭[3]);
					�Ѹ������帮��Ʈ.add(����);	// �Ѹ������帮��Ʈ ����Ʈ�� ����.
			}
		} catch (Exception e) {System.out.println("�������Ϸε� �޼��� ���� �߻�");}
	}	// �������Ϸε� �޼��� END
	
	// java���� txt���Ϸ� �������� �޼���
	public void ������������() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/���������.txt");	// 1. ���� ��� ��ü ����
			for(���� tmp : �Ѹ������帮��Ʈ) {
				String �������Ͽ������ڿ� = tmp.get����ݾ�() + "," + tmp.get��¥() + "," + tmp.get��() + "," + tmp.get����() + "\n";
				fileOutputStream.write(�������Ͽ������ڿ�.getBytes());
			}
		}catch(Exception e) {System.out.println("������������ �޼��� ���� �߻�");}
	}	// ������������ END
	
}	// class END
