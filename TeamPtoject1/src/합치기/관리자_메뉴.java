package ��ġ��;

import java.util.Scanner;

public class ������_�޴� {

	public static void main(String[] args) {
		������_�޴� app = new ������_�޴�();
		app.�޴�();
	}

void �޴�() {
	Scanner scanner = new Scanner(System.in);
	while(true) {
		��������Ʈ�ѷ� admincontroller = new ��������Ʈ�ѷ�();
		
		System.out.println("�����ڸ޴�");
		System.out.println("1. ��ȭ �� ��ȭ �ð���� 2. ���ĵ�� 3. ����Ȯ�� 4. �ڷ� Ȯ�� 5. �α׾ƿ�"); int ch = scanner.nextInt();
		
		if(ch == 1) {
			System.out.print("��ȭ�̸� : "); String ��ȭ�̸� = scanner.next();
			System.out.print("��ȭ �ð��� �Է����ּ��� : "); String ��ȭ�ð� = scanner.next();
			
			Boolean ��� = admincontroller.��ȭ���(��ȭ�̸�, ��ȭ�ð�);
			
			if(���) {
				System.out.println("��ȭ�� ��ϵǾ����ϴ�.");
			}else {
				System.out.println("��ȭ ��� ����.");
			}
			
		}else if(ch == 1) {
			
		}else if(ch == 2) {
			System.out.println("�԰Ÿ� ������ �Է��ϼ���");  String foodName = scanner.next();
			System.out.println("�԰Ÿ� ������ �Է��ϼ���"); 	int foodPrice = scanner.nextInt();
			
			boolean result = admincontroller.���ĵ��(foodName, foodPrice, 0);
			if(result) {System.out.println("�԰Ÿ��� ��ϵǾ����ϴ�.");}
			else {System.out.println("�԰Ÿ� ��� ����!!");}
		}else if(ch == 3) {
			System.out.println("���� Ȯ�� ");
			System.out.println("1. ��ȭ�� ���� Ȯ�� 2. ������ ���� Ȯ��");
			int ch1 = scanner.nextInt();
			if(ch1 == 1) {
				
			}
			else if(ch1 == 2) {
				
			}
			else {System.out.println("���ڸ� �߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");}
		}else if(ch == 4) {
			System.out.println("��ϵ� ��ȭ�� ��ȭ�ð� �� ���� Ȯ�� ");
			System.out.println("1. ��ϵ� ��ȭ Ȯ�� 2. ��ϵ� ���� Ȯ��");
			int ch1 = scanner.nextInt();
			if(ch1 == 1) {
				
			}
			else if(ch1 == 2) {
				
			}
			else {System.out.println("���ڸ� �߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");}
		}else if(ch == 5) {
			System.out.println("�����ڸ�带 �����մϴ�."); break;
		}else {
			System.out.println("�� �� ���� �ൿ�Դϴ�.");
		}
			
	}
	
}
void �������޴�() {
	
}

} // ce