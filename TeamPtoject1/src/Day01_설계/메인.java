package Day01_����;

import java.util.Scanner;

public class ���� { // c s
public static void main(String[] args) { // ms
	Scanner sc = new Scanner(System.in);
	
		try { // t s
	while(true) { // w s
		
//		System.out.println("����¥�� ���������� �Է����ּ���.");
//		int floor = sc.nextInt();
		
		System.out.println("[[1. ����  2. ����  3. ����Ȯ��]]");
		int select = sc.nextInt();
		��Ʈ�ѷ�.�������Ϸε�(); 
		
		if(select == 1) {
				System.out.println("������ȣ�� �Է����ּ���");
				String carNumber = sc.next();
				��Ʈ�ѷ�.�������(carNumber);				
				System.out.println("�����Ǿ����ϴ�.");
				
				for(int i = 0; i < ��Ʈ�ѷ�.����Ÿ��.length; i++) {
					if(��Ʈ�ѷ�.����Ÿ��[i][0] != null) {System.out.print(��Ʈ�ѷ�.����Ÿ��[i][0]);}
					if(i % 4 == 3) System.out.println();
				}
		}
		
		else if(select == 2) {
			System.out.println("������ȣ�� �Է����ּ���");
			String carNumber = sc.next();
			��Ʈ�ѷ�.��������(carNumber);
			
			System.out.println("�ݾ��� �Է����ּ���");
			int �ݾ� = sc.nextInt();
			��Ʈ�ѷ�.�������(�ݾ�);
			
			int ����� = ��Ʈ�ѷ�.�������(�ݾ�);
			��Ʈ�ѷ�.����ݴ���(�����);
			
		}
		
		else if(select == 3) {
			System.out.println("���� Ȯ��");
			System.out.println("������ Ȯ���� ������ �Է����ּ���");
			int ���� = sc.nextInt();
			System.out.println("������ Ȯ���� ������ �Է����ּ���");
			int �� = sc.nextInt();
			��Ʈ�ѷ�.����˻����(����, ��);
			
		}
		else if(select < 0) {System.out.println("���ڸ� �߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");}
		else {System.out.println("�߸��� ���ڸ� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");}
		
		
		
		} // w1 e
		}catch(Exception e) {System.out.println("���ڸ� �Է��Ͻʽÿ�");} // tc e
	} // m e
} // c e
