package ���ΰ�������;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ��������_���� {
	//�Ϻ� ���� �޼ҵ�
			public static void dayPay() throws IOException {
				//��¥ �ޱ�
				Scanner scanner = new Scanner( System.in);
				System.out.print(" ���� :"); int year = scanner.nextInt();
				System.out.print(" �� :");	int month = scanner.nextInt();
				
				//��̸���Ʈ�Է�
				ArrayList<Integer> allDayPay = new ArrayList<Integer>();	//�ӽþ�̹迭
				allDayPay.add(1000); //�׽�Ʈ ���� 1����
				allDayPay.add(5000); //�׽�Ʈ ���� 2����
						
				//���Ϻҷ�����
					//���Ͼ�����
				FileInputStream inputStream = new FileInputStream("D:/java/1.txt");
				byte[] bytes = new byte[1024];
				inputStream.read( bytes );
				String ���ϳ��� = new String( bytes );
				String[] ������ = ���ϳ���.split("\n");
				
					//���� ���Ͽ� �����ϱ�
				int h=0;
				for( String temp : ������ ) {
					 
					String r = (������[h]) ;
					//int ���� = Integer.parseInt(r);   //Bytes�� ����� ������ ������ String���� �ٲٰ� int�� ��ȯ�������� String���ε� ������� ��µ�
					//allDayPay.add(����);             //Ȥ�ø� ����
					h++;
				}
				
				//���� ���Ͽ� �Է�
				try {
					FileOutputStream outputStream = new FileOutputStream("D:/java/����1.txt");
					for(int i = 0 ; i<1000 ;i++) {
						if(allDayPay.get(i)!=null) {
							String �������� = allDayPay.get(i)+"\n"; 
							outputStream.write( ��������.getBytes() );
						}
					}
					
				}catch( Exception e ) { // ����[����] ó��[���] : Exception Ŭ����
				}
				
				
				
				//��¥����
				Calendar calendar = Calendar.getInstance();
				calendar.set( year , month-1 , 1 ); // ����� ���� �޷�  
				
				
				
				//�޷����
				int sweek = calendar.get( Calendar.DAY_OF_WEEK ); 
				int eday = calendar.getActualMaximum( Calendar.DAY_OF_MONTH );
				System.out.println("\n\n********************** "+year+"��" + month+"�� ******************");
				System.out.println("��\t��\tȭ\t��\t��\t��\t��");
				for( int i = 1 ; i < sweek ; i++ ) { // 3��1�� = ȭ = 3 
					System.out.print("\t"); // �������
				}
				for( int i = 0 ; i<eday ; i++ ) {
					if(allDayPay.get(i)!= null) {
						Integer a = allDayPay.get(i);
						if(a!= null) {
							System.out.print(i+")"+a+"��\t");  // i = �ϼ� ���
						}
						
					}
					else {
						System.out.print(i+")\t");
					}
					
					if( sweek % 7 == 0 ) System.out.println(); // ����ϸ��� �ٹٲ�ó�� [ �����=7 ] ������ 7�������
					sweek++;  // �Ϸ羿 ���� ���� 
				}
				
			}
}
