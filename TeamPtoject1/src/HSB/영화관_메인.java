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
//			System.out.print(""); //������ ��ȭ ��� for�� ����
//			Thread.sleep(500);
//			System.out.print("\t��");
//			Thread.sleep(500);
//			System.out.print("\t��");
//			Thread.sleep(500);
//			System.out.print("\t��");
//			Thread.sleep(500);
//			System.out.print("\t¯");
//			Thread.sleep(500);
//			System.out.println("");
			System.out.println("---------------------------------------------------");
			System.out.println("\t\t1.��ȭ���� 2.�԰Ÿ�����");
			int ch= scanner.nextInt();
			
			//��ȭ���� ���� ��
			if(ch==1){
				System.out.println("��ȭ������ �Է����ּ���.");
				String movieTitle = scanner.next();
				boolean result=movieController.��ȭ����(movieTitle);
				
				if(result) {
					System.out.println("�ð��� �������ּ���.");
					System.out.println("------------------------�ð�����----------------------");
					System.out.println(); //�ð� ����â ����
					System.out.println("----------------------------------------------------");
					System.out.println("------------------------�ο�����-----------------------");
					System.out.println("�����ο��� ������ �ּ���.");
					int adult = scanner.nextInt();
					System.out.println("û�ҳ� �ο��� ������ �ּ���");
					int yougth =scanner.nextInt();
					System.out.println("���� �ο��� ������ �ּ���.");
					int child =scanner.nextInt();
					System.out.println("����� �ο��� �������ּ���.");
					int dp =scanner.nextInt();
					System.out.println("------------------------�¼�����-----------------------");				
					while(true) {
						System.out.println("����������������SCREEN����������������  ����");
						System.out.println("��������������������������������������������  ��e");
						System.out.println("			��x");
						System.out.println("			��i");
						System.out.println("			��t");
						System.out.println("			����");
						movieController.�¼����(adult, yougth, child, dp);
  						System.out.println("                      ��IN��");
						System.out.println("--------------------------------------------------");
						System.out.print("���ϴ� �¼��� �������ּ���.  >");
						int ch1=scanner.nextInt();
						boolean result2=movieController.�¼�����(adult ,yougth , child ,dp ,ch1);
						if(result2) {
							System.out.println("�¼��� ���õǾ����ϴ�.");
						String sum=movieController.����(adult, yougth, child, dp);
						System.out.println("�� ���� �ݾ� :"+sum);
						System.out.println("�����ݾ��� �Է����ּ���.");
						int pay = scanner.nextInt();
						String ticket=movieController.Ƽ�Ϲ߱�();
						System.out.println("Ƽ�Ϲ�ȣ : "+ticket);
						
							break;
						}else {
							System.out.println("�¼����� ���� !! ");
						}
					}	
				}else{			
					System.out.println("wellcome admin");
				}
			}//��ȭ ����
			
			//�԰Ÿ� ���� ��
			else if (ch==2) {
				System.out.println();//���� �԰Ÿ� �޴� ���
			}//�԰Ÿ� ����
		
			}catch (Exception e) {
				scanner = new Scanner(System.in);
			}
		}
	}

}