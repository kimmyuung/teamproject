package ��ġ��;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalTime;
import java.util.ArrayList;







public class ��������Ʈ�ѷ� {

	static ArrayList<������_Ŭ����> ��ȭ����Ʈ = new ArrayList<>();
	static ArrayList<������_Ŭ����> ��ǰ����Ʈ = new ArrayList<>();
	
	boolean ��ȭ���(String ��ȭ�̸�, String ��ȭ�ð�) {
		
		for(������_Ŭ���� temp : ��ȭ����Ʈ) {
			if(temp != null && temp.get��ȭ����().equals(��ȭ�̸�)) {
				System.out.println(1); return false;
			}
		}
		
		������_Ŭ���� ������ = new ������_Ŭ����(��ȭ�̸�, ��ȭ�ð�, null, 0);
		��ȭ����Ʈ.add(������);
		return true;

	}


	boolean ���ĵ��(String �԰Ÿ�����,  int ����, int ���) {
		for(������_Ŭ���� temp : ��ǰ����Ʈ) {
			if(temp.get�԰Ÿ�����().equals(�԰Ÿ�����)) {
				return false;
			}
		}
		������_Ŭ���� ���� = new ������_Ŭ����(�԰Ÿ�����, ����, ���);
		��ǰ����Ʈ.add(����);
		return true;
	}

	void save () {
		
			try {
				// 1. ������� Ŭ���� 
				FileOutputStream outputStream = new FileOutputStream("D:/�ڹ�/������.txt");
				// 2. ���Ͽ� �ۼ��� ���� [ ����Ʈ�� ��ü 1���� = ���پ� = �Խù� 1���� = ��ü 1���� ]
				for( ������_Ŭ���� temp : ��ǰ����Ʈ ) { // , : �ʵ屸�п�     \n : ��ü���п�
					String �ۼ����� = temp.get�԰Ÿ�����() +","+ temp.get����()+","+
							temp.get���()+"\n";
					// 3. ����[���ڿ�] -> ����Ʈ�� ��ȯ  [ �ܺ����(��Ʈ��) : ��Ŵ��� : ����Ʈ ]
					outputStream.write( �ۼ�����.getBytes() ); // 4. �������� [ write() ]
				}
			}catch( Exception e ) {  System.err.println(" �˸�]] �������� ����( �����ڿ��Թ��� )"); }
		
	}
	void ������� () {
		try {
			FileInputStream inputStream = new FileInputStream("D:/�ڹ�/������.txt"); // 1. �����Է�Ŭ���� 
			byte[] bytes = new byte[1000]; // 2. ����Ʈ�迭 ����
			inputStream.read( bytes ); // 3. ��� ����Ʈ �о�ͼ� ����Ʈ�� ���� 
			String file = new String( bytes ); // 4. ����Ʈ -> ���ڿ� ��ȯ 
			String[] boards = file.split("\n"); // 5. ���ڿ� �ڸ��� [ ���پ� [ \n ] -> 1����ü ] 
			int i = 0; // �ε��� �� 
			for( ������_Ŭ���� temp : ��ǰ����Ʈ ) { // �迭�� ���ڿ� �ϳ��� ������ 
				if( i+1 == ��ǰ����Ʈ.size() ) break; // * ������ �ε���[��ü] ����
				String[] field = temp.toString().split(","); // 6. ���ڿ� �ڸ��� [ ���� [,] -> ���ʵ� ] 
				������_Ŭ���� ���� = new ������_Ŭ����( field[0], Integer.parseInt(field[1]),
						Integer.parseInt(field[2]) );  // 7. ��üȭ 
										// ��ȸ���� �ʵ�� �������̹Ƿ� ���������� ����ȯ [ Integer.parseInt( ���ڿ� ) ]
				��ǰ����Ʈ.add(����);// 8. ����Ʈ ��� 
				i++; // �ε��� ���� 
			}
			
		}catch( Exception e ) { System.err.println(" �˸�]] ���Ϸε�  ����( �����ڿ��Թ��� )"+e);  }
	}
	

}