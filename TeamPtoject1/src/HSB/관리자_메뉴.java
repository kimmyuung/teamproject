package HSB;

import java.time.LocalTime;
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
		System.out.println("1. ��ȭ��� 2. ��ȭ�ð���� 3. ���ĵ�� 4. ����Ȯ�� 5. �α׾ƿ�"); int ch = scanner.nextInt();
		
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
			
		}else if(ch == 3) {
			
		}else if(ch == 4) {
			
		}else if(ch == 5) {
			
		}else {
			System.out.println("�� �� ���� �ൿ�Դϴ�.");
		}
			
	}
	
}


} // ce