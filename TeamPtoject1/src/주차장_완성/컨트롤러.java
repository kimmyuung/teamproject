package ������_�ϼ�;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Random;


import javax.swing.text.DateFormatter;





public class ��Ʈ�ѷ� extends ����{
	public static String[][] ����Ÿ�� = new String[12][3];
	public static ArrayList<����> �Ѹ������帮��Ʈ = new ArrayList<>();
	
	
	public String[] �������(String carNumber) { // ������� s
		Date date = new Date();
		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String �������� = now.format(formatter);
		for(int i = 0; i<����Ÿ��.length; i++) {
			if(����Ÿ��[i][0] == null)  ����Ÿ��[i][0] = "[ ]";
		}
		for(int i = 0; i<����Ÿ��.length; i++) { // for s
		if(����Ÿ��[i][0].equals("[ ]")) { // �������� ������
		����Ÿ��[i][0] = "[o]";
		����Ÿ��[i][1] =  ��������;
		����Ÿ��[i][2] = carNumber;  
		return ����Ÿ��[i];
		} // ���� ä��� �����ð� �迭 ��ø���� �ֱ�										
		} // for e
		return null;
		} // ������� e
	
	public String ��������(String carNumber) { // �������� s
		for(int i=0; i<����Ÿ��.length; i++) { // for s
		if(����Ÿ��[i][0].equals("[o]") && ����Ÿ��[i][2].equals(carNumber)) 
			{ // ������ȣ ��ġ�ϸ�
		����Ÿ��[i][0] = "[ ]";
		����Ÿ��[i][2] = null;
			}
			} // for e // ������ ĭ ���� ��
		// ���
		return null;
				} // �������� e
	
	public int ������� (int �ݾ�) {
		Date date = new Date();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");	
		String ���� = now.format(formatter);
		String[] ����times = ����.split(":");
		for(int i = 0 ; i < ����Ÿ��.length; i++) {
			if(����Ÿ��[i][1] != null) {
		String[] ����times = ����Ÿ��[i][1].split(":");
		int ������ = Integer.parseInt(����times[0]);
		int ������ = Integer.parseInt(����times[1]);
		int ������ = Integer.parseInt(����times[0]);
		int ������ = Integer.parseInt(����times[1]);
		int �ð� = ������ - ������ ; // '��'�� �������.
		int �� = ������ - ������ ; // '��'�� �������
		int �������ð� = (�ð� * 60) + ��;	// ���� : ��
		int ����� = (�������ð�/10)*1000;	// 30���� ����� �������ð����� 30�� ����, 10�д��̶� 10 ������, 1000���̶� 1000 ���ϱ�
		
		if (�������ð� < 30) {����� = 0; System.out.println("����Ͻ� �ʿ�����ϴ�."); ����Ÿ��[i][1] = null;}
		else if (�ð� > 24) {����� = 50000; System.out.println("����Ͻ� �ݾ��� 5�����Դϴ�."); ����Ÿ��[i][1] = null;}
		else if (�ݾ� < �����) {System.out.println("�ݾ��� �����մϴ� " + (�����-�ݾ�) + "�� �� �������ּ���");}
		else if (�ݾ� >= �����) {System.out.println("�����Ǿ����ϴ�. " + (�ݾ�-�����) + "���� ��ȯ�մϴ�."); ����Ÿ��[i][1] = null;}
		return �����;	}
		}
	return 0;
	}
	
		// �������� ��ü������ ���� �� �μ��� ���� ����ݰ� ���� ����Ʈ�� �����ϴ� �޼���
		public void ����ݴ���(int �����) {
			int ����ݾ� = �����;
			Date date = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("yy��");
			String ���� = dateformat.format(date);
			dateformat = new SimpleDateFormat("M��");	// 03�� : 3��, 12�� : 12��
			String �� = dateformat.format(date);
			dateformat = new SimpleDateFormat("d��");
			String ��¥ = dateformat.format(date);
			���� ����ݴ��� = new ����(����ݾ�, ��¥, ��, ����);
			�Ѹ������帮��Ʈ.add(����ݴ���);
			������������();
		}
		
		// �ֿܼ��� �Է¹��� ������ ���� �������� ���� ���⳻���� ArrayList�� ����
		public ArrayList<����> �������(int ����, int ��, int ���ı���) {
			
			ArrayList<����> ���ϸ��� = new ArrayList<>();
			
			String ã������ = ����+"��";	
			String ã���� = ��+"��";	
			
			// 1. ��� ��¥�� ����ݾ��� �ִ� �Ѹ������帮��Ʈ���� �Է¹��� ��, ���� ���⸸ �� ���ͼ� ���ϸ��� ����Ʈ�� �ݾװ� ��¥ ���� 
			for(���� tmp : �Ѹ������帮��Ʈ) {	
				if(tmp.get����().contains(ã������) && tmp.get��().contains(ã����)) {	
					���� �ӽð�ü = new ����(tmp.get����ݾ�(), tmp.get��¥());
					���ϸ���.add(�ӽð�ü);
				}
			}
			
			// 2. ���� �ݺ������� ���� ���ϸ��� ����Ʈ���� ���� ��¥�� �Ѱ��� ���ѵ�, �������� 0�� ó����.
			for(int i=0; i<���ϸ���.size(); i++) {
				String tmp;
				int �ӽø��⴩��=0;
				tmp = ���ϸ���.get(i).get��¥();
				for(int j=i; j<���ϸ���.size(); j++) {
					if(tmp.equals(���ϸ���.get(j).get��¥())) {
						�ӽø��⴩�� += ���ϸ���.get(j).get����ݾ�();
						���ϸ���.get(j).set����ݾ�(0);
					}
				}
				���ϸ���.get(i).set����ݾ�(�ӽø��⴩��);
			}
			
			// 3. 0�� ó���� �ε����� �����ϴ� �ݺ���
			for(int i=0; i<���ϸ���.size(); i++){	
				if(���ϸ���.get(i).get����ݾ�()==0) {	// ���ϸ����� ���� �� �ε������� 0������ Ȯ��
					���ϸ���.remove(i);
					i-=1;	// ���� �ε��� ���� ���� �ڵ����� �������� ������ ������ ���� 0���� �ٽ��ѹ� Ȯ���ؾ���. �����ε��� �ٽ��ѹ� �˻��ϱ� ���� i= -1
				}
			}
			// 4-1 ����ڰ� ���� �������� ���� ���ý� ���� �������� ����
			if(���ı���==1) {	
				���� ����������ӽù迭 = new ����();
				int indexCount1=0;
				for(���� tmp : ���ϸ���) {
					int indexCount2=0;
					for (���� tmp2 : ���ϸ���) {
						if(Integer.parseInt(tmp.get��¥().replace("��", "")) < Integer.parseInt(tmp2.get��¥().replace("��", ""))) {
							����������ӽù迭 = ���ϸ���.get(indexCount1);
							���ϸ���.set(indexCount1, ���ϸ���.get(indexCount2));
							���ϸ���.set(indexCount2, ����������ӽù迭);
						}
						indexCount2++;
					}
					indexCount1++;
				}
			}
			else {
				���� ����������ӽù迭 = new ����();
				int indexCount1=0;
				for(���� tmp : ���ϸ���) {
					int indexCount2=0;
					for (���� tmp2 : ���ϸ���) {
						if(tmp.get����ݾ�()<tmp2.get����ݾ�()) {
							����������ӽù迭 = ���ϸ���.get(indexCount1);
							���ϸ���.set(indexCount1, ���ϸ���.get(indexCount2));
							���ϸ���.set(indexCount2, ����������ӽù迭);
						}
						indexCount2++;
					}
					indexCount1++;
				}
			}
			return ���ϸ���;
		}	// ������� END
		
		// txt���Ͽ��� java�� �о���̴� �޼���
		public void �������Ϸε�() {
			try {	// FileInputStream ������ �Ϲݿ��� �߻�
				FileInputStream fileInputStream = new FileInputStream("D:/java/���������.txt");
				byte[] �ӽù���Ʈ�迭 = new byte[65536];	// �˳��ϰ� 32KB¥�� �ӽ������ ����Ʈ�� �迭 ����
				fileInputStream.read(�ӽù���Ʈ�迭);	// ���������.txt ���� �о���� ���� ����Ʈ�� �迭�� ����
				String ���ϳ��� = new String(�ӽù���Ʈ�迭);	// ����Ʈ�迭-> ���ڿ��� �̵�
				
				String[] ���ϳ���迭 = ���ϳ���.split("\n");	
				
				for(String tmp : ���ϳ���迭) {
					String[] �ӽù迭 = tmp.split(",");
						���� ���� = new ����(Integer.parseInt(�ӽù迭[0]), �ӽù迭[1], �ӽù迭[2], �ӽù迭[3]);
						�Ѹ������帮��Ʈ.add(����);	// �Ѹ������帮��Ʈ ����Ʈ�� ����.
				}
			} catch (Exception e) { }
		}	// �������Ϸε� �޼��� END
		
		// java���� txt���Ϸ� �������� �޼���
		public void ������������() {
			try {
				FileOutputStream fileOutputStream = new FileOutputStream("D:/java/���������.txt");	// 1. ���� ��� ��ü ����
				for(���� tmp : �Ѹ������帮��Ʈ) {
					String �������Ͽ������ڿ� = tmp.get����ݾ�() + "," + tmp.get��¥() + "," + tmp.get��() + "," + tmp.get����() + "\n";
					fileOutputStream.write(�������Ͽ������ڿ�.getBytes());
				}
			}catch(Exception e) { }
			
		}	// ������������ END
		
		public void �׽�Ʈ���ϰ����() {
			for(���� tmp : �Ѹ������帮��Ʈ)
				System.out.println(tmp.get����ݾ�()+"��"+tmp.get��¥()+tmp.get��()+tmp.get����());
		}
		
		public void �밡�ٱ�����() {
			Random random = new Random();
			int ����ݾ� = random.nextInt(4001)+1000;	// 1000~5000
			float ����ݾ�2 = Math.round(����ݾ�/100.0)*100.0f;
			int year = random.nextInt(3)+20;			// 20~22
			int month = random.nextInt(12)+1;		// 1~12
			int day = 0;
			
			switch(month) {
			case 2: day = random.nextInt(28)+1;	break;	// 1~28
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: day = random.nextInt(31)+1; break;	//1~31;
			case 4:
			case 6:
			case 9:
			case 11: day = random.nextInt(30)+1; break;	//1~30;
			}
			
			String year2 = year+"��";
			String month2 = month+"��";
			String day2 = day+"��";
			
			���� ��ũ�λ������� = new ����((int)����ݾ�2, day2, month2, year2);
			�Ѹ������帮��Ʈ.add(��ũ�λ�������);
			������������();
		}
	
}	// class END
