package Day01_����;

import java.util.ArrayList;
import java.util.Scanner;

import ��Ʈ�ѷ���.����;

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
			boolean isInputRight = true;	// ����ڰ� �����Ѵ�� ���� �Է��ߴ��� ����ϴ� �÷���. true : �������
			System.out.printf("�˻��� ������ ������ �Է��ϼ���.\n�Է¿���) 2022�� : 22\n�Է°��ɿ��� : 20~22\n�Է� >");
			int year = sc.nextInt();
			System.out.printf("%2d�⿡�� �˻��� ���� ������ �Է��ϼ���.\n�Է¿���)03�� : 3\n�Է� >",year);
			int month = sc.nextInt();
			System.out.print("���ı����� ���ÿ�\n1. ���� | 2. �ݾ�\n���� >");
			int sortBy = sc.nextInt();
			System.out.println("=====================================");
			
			if(sortBy<1 || sortBy>2 ) {	// ���� ���ı����� 1���̳� 2���� �ƴѰ� ����
				System.out.println("���� ���� �ȿ� �ִ°� ����ּ���...");
				isInputRight=false;
			}else if(month<1 || month>12) {	// �˻� ���� 1~12�� ������ �Է��ϸ�
				System.out.println("���� 1������ 12�������� �־��ּ���...");
				isInputRight=false;
			}else if(year<20 || year>22) {
				System.out.println("�Է³⵵�� Ȯ���ϼ���.\n�Է°��ɿ��� : 20~22��");
				isInputRight=false;
			}
			
			if(isInputRight==true) {	
				ArrayList<����> �˻������¿븮��Ʈ =  new ArrayList<>(��Ʈ�ѷ�.�������(year, month, sortBy));
				if(�˻������¿븮��Ʈ.size()==0)	// ���� ���Ϲ��� ����Ʈ�� �ϰ͵� ��������
					System.out.println("�Է��� �Ⱓ���� ������ �����ϴ�.");
				int sum=0;
				for(���� tmp : �˻������¿븮��Ʈ) {
						System.out.printf("%d�� %2d�� %3s ���� : %s��\n", year, month, tmp.get��¥(), tmp.get����ݾ�());
						sum += tmp.get����ݾ�();
				}
				System.out.printf("\n%d�� %2d���� ����� �հ�� %5d�� �Դϴ�.\n",year,month,sum);
				System.out.println("=====================================");
			}
		}
		else if(select < 0) {System.out.println("���ڸ� �߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");}
		else {System.out.println("�߸��� ���ڸ� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");}
		
		
		
		} // w1 e
		}catch(Exception e) {System.out.println(e);} // tc e
	} // m e
} // c e
