package ��¥����;

import java.text.DecimalFormat;
import java.util.Scanner;



import java.text.DecimalFormat;
import java.util.Scanner;



public class ��ȭ��_����{
	static Scanner scanner = new Scanner(System.in);
	static ����Ʈ�ѷ� movieController = new ����Ʈ�ѷ�();
	��ȭƼ�� ��ȭƼ�� = new ��ȭƼ��();
	public static void main(String[] args) {
		��ȭ��_���� app = new ��ȭ��_����();
		app.���θ޴�();
	}	
	static void ���θ޴�() {
		try {
		while(true) {
			
			System.out.println("");
			System.out.println("-------------����ʽÿ�.ezen movie-------------------");
			��������Ʈ�ѷ�.��ȭ���();
			System.out.printf("%10s \t %10s \n", "��ȭ����", "��ȭ�ð�");
			
			for( ������_Ŭ���� temp : ��������Ʈ�ѷ�.��ȭ����Ʈ ) {
				System.out.printf("%10s\t%10s \n", temp.get��ȭ����() ,
						temp.get��ȭ�ð�() );
			}
			System.out.println("---------------------------------------------------");
			System.out.println("\t1.��ȭƼ�Ϲ߱�  2.�԰Ÿ�����  3.��ȭ����");
			int ch= scanner.nextInt();
			
			//��ȭ���� ���� ��
			if(ch==1){
				System.out.println("��ȭ������ �Է����ּ���.");
				String movieTitle = scanner.next();
				boolean result=movieController.��ȭ����(movieTitle);
				
				if(result) {
					System.out.println("�ð��� �������ּ���.");		
					String movieTime = scanner.next();
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
					int personSum =(adult+yougth+child+dp);
					
					for(int i= 0; i<personSum; i++) {
						System.out.println("------------------------�¼�����-----------------------");			
						System.out.println("����������������SCREEN����������������  ����");
						System.out.println("��������������������������������������������  ��E");
						System.out.println("			��X");
						System.out.println("			��I");
						System.out.println("			��T");
						System.out.println("			����");
						movieController.�¼����(adult, yougth, child, dp);
  						System.out.println("                      ��IN��");
						System.out.println("--------------------------------------------------");
						System.out.print("���ϴ� �¼��� �������ּ���.  >");
						int ch1=scanner.nextInt();
						
						
						//�¼�����
							boolean result2=movieController.�¼�����(adult ,yougth , child ,dp ,ch1);
							if(result2) {
								System.out.println("�¼��� ���õǾ����ϴ�.");
							
							}else {
								System.out.println("�¼����� ���� !! ");
								System.out.println("�̹� ���õ� �¼��̰ų� �������� �ʴ� �¼��Դϴ�.");
								System.out.println("�ٸ� �¼��� ������ �ּ���.");
								personSum++;
								
							}	
						}	
						//�ݾװ��
						int sum=movieController.�ݾװ��(adult, yougth, child, dp);
						//�����ݾ� ���� ��ȯ
						DecimalFormat df= new DecimalFormat("###,###��");
						String sum2 = df.format(sum);
						System.out.println("�� ���� �ݾ� :"+sum2);
						System.out.print("�����ݾ��� �Է����ּ���.");
						int pay = scanner.nextInt();
						
						//�ܾ� ��� ���� ��ȯ
						int payBack1=(pay-sum);
						String payBack =df.format(payBack1);
						//����
						int result3=movieController.����(adult, yougth, child, dp, pay);
						System.out.print("��");
						Thread.sleep(500);
						System.out.print("��");
						Thread.sleep(500);
						System.out.print("Ȯ");
						Thread.sleep(500);
						System.out.println("��");
						Thread.sleep(500);
						if(result3==1) {
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
							
						}
						else if(result3==2){
							System.out.println("���� �ݾ��� �����մϴ�.");
							movieController.�������();	
						}
						else if(result3==3){
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
							System.out.println("�ܾ�:"+(payBack));
							
						
						}else {
							System.out.println("�˼����� �ൿ�Դϴ�.");
							
						}
				
						if(result3==1 || result3==3) {
						String ticket=movieController.Ƽ�Ϲ߱�();
						System.out.println("Ƽ�Ϲ�ȣ : "+ticket);
						
						//Ƽ�� ����
						movieController.Ƽ������(movieTime, movieTitle , ticket , personSum);
						}	
					
				}else{			
					System.out.println("wellcome admin");
				}
				
			}//��ȭ ����
			
			//�԰Ÿ� ���� ��
			else if (ch==2) {
				movieController.�������̿�();
				// ������_�޴��� �������̿� ���
			}//�԰Ÿ� ���� end
			
			//����Ƽ�� Ȯ��
			else if(ch==3) {
				 System.out.println("�߱� ������ ����Ƽ�� ��ȣ�� �Է��Ͽ� �ּ���.");
				 String reser = scanner.next();
				boolean anyReser = movieController.����Ƽ��Ȯ��(reser);
				
				if(anyReser) {
					
					for(��ȭƼ�� temp : ����Ʈ�ѷ�.movieTicket) {
						if(temp.getƼ�Ϲ�ȣ().equals(reser)) {
							System.out.println("\t������������������Movie ticket������������������");
							System.out.println("");
							System.out.println("\t   ��ȭ �ð�: "+temp.get��ȭ�ð�());
							System.out.println("\t------------------------------");
							System.out.println("\t   ��ȭ ����: "+temp.get��ȭ����());
							System.out.println("\t------------------------------");
							System.out.println("\t   Ƽ�� ��ȣ: "+temp.getƼ�Ϲ�ȣ());
							System.out.println("\t------------------------------");
							System.out.println("\t   �� �ο���: "+temp.get�ο���()+"��");
							System.out.println("");
							System.out.println("\t������������������������������������������������������������");
						}
					}
					System.out.println("��ſ� ���� �ǽʽÿ�.");
				}else {
					System.out.println("��ġ�ϴ� ������ �����ϴ�.");
				}
				 
			}
			}
		}catch (Exception e) {
			scanner = new Scanner(System.in);
		}
	}

}