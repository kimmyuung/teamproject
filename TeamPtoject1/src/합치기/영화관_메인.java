package ��ġ��;

import java.util.Scanner;

public class ��ȭ��_����{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		����Ʈ�ѷ� movieController = new ����Ʈ�ѷ�();
		while(true) {
			System.out.println("-------------����ʽÿ�.ezen movie-------------------");
			System.out.println(); //������ ��ȭ ��� for�� ����
			System.out.println("---------------------------------------------------");
			System.out.println("\t\t1.��ȭ���� 2.�԰Ÿ�����");
			int ch= scanner.nextInt();
			if(ch==1){
				System.out.println("��ȭ������ �Է����ּ���.");
				String movieTitle = scanner.next();
				boolean result=movieController.��ȭ����(movieTitle);
				if(result) {
					System.out.println("�ð��� �������ּ���.");
					System.out.println("------------------------------------------");
					System.out.println(); //�ð� ����â ����
					System.out.println("------------------------------------------");
					
				}
				System.out.println("ã�� �� ���� ��ȭ�����Դϴ�.");
				
				
			}//��ȭ ����
			else if (ch==2) {
				System.out.println();//���� �԰Ÿ� �޴� ���
			}//�԰Ÿ� ����
			
		
		}
	}

}