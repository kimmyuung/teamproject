package HSB;

import java.util.Scanner;

public class ��ȭ��_����{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		������_�޴� �����ڸ޴� = new ������_�޴�();
		����Ʈ�ѷ� movieController = new ����Ʈ�ѷ�();
		
		while(true) {
			try {
				System.out.println("");
				System.out.println("-------------����ʽÿ�.ezen movie-------------------");
//			System.out.print("��"); //������ ��ȭ ��� for�� ����
//			Thread.sleep(1000);
//			System.out.print("\t��");
//			Thread.sleep(1000);
//			System.out.print("\t��");
//			Thread.sleep(1000);
//			System.out.print("\t��");
//			Thread.sleep(1000);
//			System.out.print("\t��");
//			Thread.sleep(1000);
//			System.out.println("");
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
					
					System.out.println("�¼����������ּ���.");
					System.out.println("------------------------------------------");
					while(true) {
					movieController.�¼����();
						System.out.println("------------------------------------------");
						System.out.print("���ϴ� �¼��� �������ּ���.  >");
						int ch1=scanner.nextInt();
						
						boolean result2=movieController.�¼�����(ch1);
						if(result2) {
							System.out.println("�¼��� ���õǾ����ϴ�.");
						}else {
							System.out.println("�¼����� ���� !! ");
						}
					}	
				}else{			
					System.out.println("wellcome admin");
				}
			}//��ȭ ����
			else if (ch==2) {
				System.out.println();//���� �԰Ÿ� �޴� ���
			}//�԰Ÿ� ����
		
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}