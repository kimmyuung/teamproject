package ��ġ��;

import java.util.Scanner;


public class ������_�޴� {

	public static void main(String[] args) {
		������_�޴� app = new ������_�޴�();
		app.�޴�();
	}

static void �޴�() {
	Scanner scanner = new Scanner(System.in);
	
	while(true) {
		
		��������Ʈ�ѷ� admincontroller = new ��������Ʈ�ѷ�();
		
		System.out.println("�����ڸ޴�");
		System.out.println("1. ��ȭ �� ��ȭ �ð���� 2. ���ĵ�� 3. ������ ��� ��� 4. ��ϵ� �ڷ� Ȯ�� 5. �α׾ƿ�"); int ch = scanner.nextInt();
		
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
			System.out.println("��� ��� ");
			System.out.println("1. ��� �԰� 2. ��� ���");
			int ch1 = scanner.nextInt();
			if(ch1 == 1) {
				System.out.println("��� �԰��� �԰Ÿ� ������ �Է����ּ���"); String foodname = scanner.next();
				System.out.println("�԰��� ��� ���� �Է����ּ���");	int ��� = scanner.nextInt();
				boolean result = admincontroller.����԰�(foodname, ���);
				if(result) System.out.println("�԰� ����");
				else System.out.println("�԰� ����!");
			}
			else if(ch1 == 2) {
				System.out.println("��� �԰��� �԰Ÿ� ������ �Է����ּ���"); String foodname = scanner.next();
				System.out.println("����� ��� ���� �Է����ּ���");	int ��� = scanner.nextInt();
				boolean result = admincontroller.����԰�(foodname, ���);
				if(result) System.out.println("��� ����!");
				else System.out.println("��� ����!");
			}
			else {System.out.println("���ڸ� �߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");}
		}else if(ch == 4) {
			
			System.out.println("��ϵ� ��ȭ�� ��ȭ�ð� �� ���� Ȯ�� ");
			
			System.out.println("1. ��ϵ� ��ȭ�� ��ȭ�ð� Ȯ�� 2. ��ϵ� ���� Ȯ��");
			int ch1 = scanner.nextInt();
			if(ch1 == 1) {
				int i = 0;
				admincontroller.��ȭ���();
				System.out.printf("\t%10s\t%10s\t \n", "��ȭ","��ȭ�ð�");
				 // ����Ʈ�� �ε���
				for( ������_Ŭ���� temp : admincontroller.��ȭ����Ʈ ) {
					if(temp.get��ȭ����().equals(null)) System.out.println();
					else {
						System.out.printf("%d\t%10s\t%10s \n", i , temp.get��ȭ����() ,
						temp.get��ȭ�ð�() );
							i++;
							}
				}
				System.out.println("1. ��ȭ �� ��ȭ�ð� ���� 2. ��ȭ �� ��ȭ�ð� ����");
				int ch2 = scanner.nextInt();
				if(ch2 == 1) {
					System.out.println("������ �ε��� ��ȣ�� �Է��ϼ���");
					int x = scanner.nextInt();
					System.out.println("������ ��ȭ �̸��� �Է��ϼ���");
					String movieName1 = scanner.next();
					System.out.println("������ ��ȭ �ð��� �Է��ϼ���");
					String movieTime1 = scanner.next();
					boolean result = admincontroller.��ȭ�Ϳ�ȭ�ð�����(x, movieName1, movieTime1);
					if(result) System.out.println("���� ����!");
					else System.out.println("���� ����!");
				}
				else if(ch2 == 2) {
					System.out.println("������ ��ȭ�� ��ȣ�� �Է��ϼ���");
					int x = scanner.nextInt();
					boolean result = admincontroller.��ȭ�ͽð�����(x);
					if(result) System.out.println("��������");
					else System.out.println("���� ����!");
				}
			}
			else if(ch1 == 2) {
				int index = 1;
				admincontroller.�������();
				System.out.println("1. ���� �� ���İ��� ���� 2. ���� �� ���İ��� ����");
				System.out.printf("%d\t%s\t%10s\t%10s\t%s \n", index,"��ȣ","�԰Ÿ�����","����", "���");
				for( ������_Ŭ���� temp : admincontroller.��ǰ����Ʈ ) {
					if(temp.get�԰Ÿ�����() != "null") {
					System.out.printf("%d\t%10s\t%10d\t%d \n", index , temp.�԰Ÿ����� ,
							temp.get����(), temp.get���() );
					}
					index++;
				}
				int ch2 = scanner.nextInt();
				if(ch2 == 1) {
					admincontroller.�������();
					System.out.printf("%s\t%10s\t%10s\t%s \n","��ȣ","�԰Ÿ�����","����", "���");
					for( ������_Ŭ���� temp : admincontroller.��ǰ����Ʈ ) {
						if(temp.get�԰Ÿ�����() != "null") {
						System.out.printf("%d\t%10s\t%10d\t%d \n", index , temp.�԰Ÿ����� ,
								temp.get����(), temp.get���() );
						}
						index++;
					}
					System.out.println("������ ������ ��ȣ�� �Է��ϼ���"); int x = scanner.nextInt();
					System.out.println("������ ���� �̸��� �Է��ϼ���"); String FoodName1 = scanner.next();
					System.out.println("������ ���� ������ �Է��ϼ���"); int FoodPrice1 = scanner.nextInt();
					boolean result = admincontroller.���İ����İ��ݼ���(x, FoodName1, FoodPrice1);
					if(result) {System.out.println("���� ����!"); admincontroller.����������();}
					else System.out.println("���� ����!");
					
				}
				else if(ch2 == 2) {
					admincontroller.�������();
					System.out.printf("%s\t%10s\t%10s\t%s \n","��ȣ","�԰Ÿ�����","����", "���");
					for( ������_Ŭ���� temp : admincontroller.��ǰ����Ʈ ) {
						if(temp.get�԰Ÿ�����() != "null") {
						System.out.printf("%d\t%10s\t%10d\t%d \n", index , temp.�԰Ÿ����� ,
								temp.get����(), temp.get���() );
						}
						index++;
					}
					System.out.println("������ ������ ��ȣ�� �Է��ϼ���"); int FoodName = scanner.nextInt();
					boolean result = admincontroller.���İ����ݻ���(FoodName);
					if(result) {System.out.println("���� ����!"); }
					else System.out.println("���� ����!");
				}
			}
			else {System.out.println("���ڸ� �߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");}
		}else if(ch == 5) {
			System.out.println("�����ڸ�带 �����մϴ�."); break;
		}else {
			System.out.println("�� �� ���� �ൿ�Դϴ�.");
		}
			
	}
	
}
static void �������޴�() { // ���� ���� ������ �޴�
	Scanner sc = new Scanner(System.in);
	while(true) {
	System.out.println("�������� ���� �� ȯ���մϴ�.");
	System.out.println("1. �ֹ�          2. ����");
	��������Ʈ�ѷ�.�������();
	for(������_Ŭ���� temp : ��������Ʈ�ѷ�.��ǰ����Ʈ) {
		System.out.println("���� ���� : "+temp.get�԰Ÿ�����());
		System.out.println("���� : "+temp.get����());
		}
	int ch = sc.nextInt();
	if(ch== 1) {
	System.out.println("���� ������ ������ �Է����ּ���"); 	String foodName = sc.next();
	for(������_Ŭ���� temp : ��������Ʈ�ѷ�.��ǰ����Ʈ) {
		if(temp.get�԰Ÿ�����().equals(foodName)) {
			System.out.println("��ǰ�� ���� : " + temp.get����() + "�Դϴ�. ");
			System.out.println("1. ����     2. ���� ���"); 
			int ch1 = sc.nextInt();
			if(ch1 == 1) {
				System.out.println("������ ���� �ݾ��� �Է����ּ���");
				int money = sc.nextInt();
				if(temp.get����() <= money) {
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					System.out.println((temp.get����() - money) + "���� ��ȯ�մϴ�.");
					temp.set���(temp.get���()-1);
					break;
				}
				else {System.out.println("�������� �����մϴ�. ");
						System.out.println((temp.get����() - money) + "�� �� �������ּ���.");}
			}
			else if(ch1 == 2) {
				System.out.println("������ ����ϼ̽��ϴ�. ó������ �ٽ� �õ����ּ���");
				break;
			}
		}
		else System.out.println("���� �����Դϴ�. �ٽ� �ֹ����ּ���");
	}
			}
	else if(ch==2) {System.out.println("�������� �̿����ּż� �����մϴ�."); break;}
	
	
	}
}

} // ce