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
		��ȭ����();
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
		����������();
		return true;
	}

	static void  ���������� () {
		
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
	static void  ������� () {
		try {
			FileInputStream inputStream = new FileInputStream("D:/�ڹ�/������.txt"); // 1. �����Է�Ŭ���� 
			byte[] bytes = new byte[1000]; // 2. ����Ʈ�迭 ����
			inputStream.read( bytes ); // 3. ��� ����Ʈ �о�ͼ� ����Ʈ�� ���� 
			String file = new String( bytes ); // 4. ����Ʈ -> ���ڿ� ��ȯ 
			String[] files = file.split("\n"); // 5. ���ڿ� �ڸ��� [ ���پ� [ \n ] -> 1����ü ] 
			int i = 0; // �ε��� �� 
			for( String temp : files ) { // �迭�� ���ڿ� �ϳ��� ������ 
				if( i+1 == files.length ) { break; }// * ������ �ε���[��ü] ����
				String[] field = temp.split(","); // 6. ���ڿ� �ڸ��� [ ���� [,] -> ���ʵ� ] 
				������_Ŭ���� ������ = new ������_Ŭ����( field[0], Integer.parseInt(field[1]), 
						Integer.parseInt(field[2]) );  // 7. ��üȭ
				��ǰ����Ʈ.add(������);// 8. ����Ʈ ��� 
				i++; // �ε��� ���� 
			}
			���������� ();
		}catch( Exception e ) { System.err.println(" �˸�]] ���Ϸε�  ����( �����ڿ��Թ��� )"+e);  }
	}
	boolean ����԰�(String foodname, int ���) {
		for(������_Ŭ���� temp : ��ǰ����Ʈ) {
			if(temp.get�԰Ÿ�����().equals(foodname)) {
				temp.set���(temp.get���() + ���);
				����������();
				return true;
			}
		}
	return false;
	}
	boolean ������(String foodname, int ���) {
		for(������_Ŭ���� temp : ��ǰ����Ʈ) {
			if(temp.get�԰Ÿ�����().equals(foodname)) {
				temp.set���(temp.get���() - ���);
				����������();
				return true;
			}
		}
	return false;
	}
	
	boolean ��ȭ�Ϳ�ȭ�ð����� (String movieName, String movieTime, String movieName1, String movieTime1) {
		for(������_Ŭ���� temp : ��ȭ����Ʈ) {
			if(temp.get��ȭ����().equals(movieName) && temp.get��ȭ�ð�().equals(movieTime)) {
				temp.set��ȭ����(movieName1);
				temp.set��ȭ�ð�(movieTime1);
				System.out.println(1);
				��ȭ����();
				return true;
			}
		}
		return false;
	}
	boolean ���İ����İ��ݼ��� (String FoodName, String FoodName1, int FoodPrice, int FoodPrice1) {
		for(������_Ŭ���� temp : ��ǰ����Ʈ) {
			if(temp.get�԰Ÿ�����().equals(FoodName) && temp.get����() == FoodPrice) {
				temp.set�԰Ÿ�����(FoodName1);
				temp.set����(FoodPrice1);
				����������();
				return true;
			}
		}
		return false;
	}
	public static void ��ȭ���� () {
		
		try {
			// 1. ������� Ŭ���� 
			FileOutputStream outputStream = new FileOutputStream("D:/�ڹ�/��ȭ.txt");
			// 2. ���Ͽ� �ۼ��� ���� [ ����Ʈ�� ��ü 1���� = ���پ� = �Խù� 1���� = ��ü 1���� ]
			for(  ������_Ŭ���� temp : ��ȭ����Ʈ ) { // , : �ʵ屸�п�     \n : ��ü���п�
				String �ۼ����� = temp.get��ȭ����() +","+ temp.get��ȭ�ð�()+"\n";
				// 3. ����[���ڿ�] -> ����Ʈ�� ��ȯ  [ �ܺ����(��Ʈ��) : ��Ŵ��� : ����Ʈ ]
				outputStream.write( �ۼ�����.getBytes() ); // 4. �������� [ write() ]
			}
		}catch( Exception e ) {  System.err.println(" �˸�]] �������� ����( �����ڿ��Թ��� )"); }
	
}
	public static void ��ȭ��� () {
		try {
		FileInputStream inputStream = new FileInputStream("D:/�ڹ�/��ȭ.txt"); // 1. �����Է�Ŭ���� 
		byte[] bytes = new byte[1000]; // 2. ����Ʈ�迭 ����
		inputStream.read( bytes ); // 3. ��� ����Ʈ �о�ͼ� ����Ʈ�� ���� 
		String file = new String( bytes ); // 4. ����Ʈ -> ���ڿ� ��ȯ 
		String[] files = file.split("\n"); // 5. ���ڿ� �ڸ��� [ ���پ� [ \n ] -> 1����ü ] 
		int i = 0; // �ε��� �� 
		for( String temp : files ) { // �迭�� ���ڿ� �ϳ��� ������ 
			if( i+1 == files.length ) { break; }// * ������ �ε���[��ü] ����
			String[] field = temp.split(","); // 6. ���ڿ� �ڸ��� [ ���� [,] -> ���ʵ� ] 
			������_Ŭ���� ��ȭ = new ������_Ŭ����( field[0], field[1]);  // 7. ��üȭ
			��ȭ����Ʈ.add(��ȭ);// 8. ����Ʈ ��� 
			
			i++; // �ε��� ���� 
		}
		
	}catch( Exception e ) { System.err.println(" �˸�]] ���Ϸε�  ����( �����ڿ��Թ��� )"+e);  }
	}
	boolean ��ȭ�ͽð�����(String MovieName, String MovieTime) {
		for(������_Ŭ���� temp : ��ȭ����Ʈ) {
			if(temp.get��ȭ����().equals(MovieName) && temp.get��ȭ�ð�().equals(MovieTime)) {
				temp.set��ȭ�ð�("null");
				temp.set��ȭ����("null");
				��ȭ����();
				return true;
			}
		}
		return false;
	}
	boolean ���İ����ݻ���(String FoodName) {
		for(������_Ŭ���� temp : ��ǰ����Ʈ) {
			if(temp.get�԰Ÿ�����().equals(FoodName) ) {
				temp.set�԰Ÿ�����(null);
				temp.set����(0);
				temp.set���(0);
				����������();
				return true;
			}
		}
		return false;
	}
}