package ��Ʈ�ѷ���;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		��Ʈ�ѷ� ������Ʈ�ѷ� = new ��Ʈ�ѷ�();
		
		
		/*
		 *  ��ĥ�� �ؾ��Ұ�
		 *  1. ������ �����ϱ� ��(mainŬ���� �� �ֻ��) �������Ϸε� �޼��� ����
		 *  2. if ch==1 �κ��� �ʿ����. ch==2�κи� �����ϸ� ��.
		 */
		
		
		Scanner scanner = new Scanner(System.in);
		������Ʈ�ѷ�.�������Ϸε�();
		������Ʈ�ѷ�.�׽�Ʈ���ϰ����();	// �׽�Ʈ�� �޼���
		for(int i=0; i<200; i++)	// �׽�Ʈ�� ����� ���� ��������
			������Ʈ�ѷ�.�밡�ٱ�����();	
		
		while(true) {
			System.out.println("1. ����������ݾ� �Է� | 2. �˻�");
			System.out.print("�Է� >");
			int ch=scanner.nextInt();
			if(ch==1) {
				System.out.println("��������ݾ� �Է�");
				int �����ϸ鼭�����ݾ� = scanner.nextInt();
				������Ʈ�ѷ�.����ݴ���(�����ϸ鼭�����ݾ�);
			}	
			
				
			
			else if(ch==2) {	
				boolean isInputRight = true;	// ����ڰ� �����Ѵ�� ���� �Է��ߴ��� ����ϴ� �÷���. true : �������
				System.out.printf("�˻��� ������ ������ �Է��ϼ���.\n�Է¿���) 2022�� : 22\n�Է°��ɿ��� : 20~22\n�Է� >");
				int year = scanner.nextInt();
				System.out.printf("%2d�⿡�� �˻��� ���� ������ �Է��ϼ���.\n�Է¿���)03�� : 3\n�Է� >",year);
				int month = scanner.nextInt();
				System.out.print("���ı����� ���ÿ�\n1. ���� | 2. �ݾ�\n���� >");
				int sortBy = scanner.nextInt();
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
					ArrayList<����> �˻������¿븮��Ʈ =  new ArrayList<>(������Ʈ�ѷ�.�������(year, month, sortBy));
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
			}	// �˻��Ŵ����� else if END
		}	// while END
	}	// main END
}	// class END
