package Day01_����;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;


public class ��Ʈ�ѷ� extends ����{
	public static String[][] ����Ÿ�� = new String[12][3];
	
	// ������ ���� "[o]" ��� "[ ]"
	//���� �ð�
	LocalTime parkStart = LocalTime.now(ZoneId.of("Asia/Seoul"));
	//���� �ð�
	LocalTime parkEnd = LocalTime.now(ZoneId.of("Asia/Seoul"));
	public static ArrayList<����> �Ѹ������帮��Ʈ = new ArrayList<>();
	
	public ��Ʈ�ѷ�(LocalTime parkStart) {
		super();
		this.parkStart = parkStart;
	}
	public ��Ʈ�ѷ�(LocalTime parkStart, LocalTime parkEnd) {
		super();
		this.parkStart = parkStart;
		this.parkEnd = parkEnd;
	}
	public static String[] �������(String carNumber) { // ������� s
		Date date = new Date();
		DateFormat parkStart = new SimpleDateFormat("hh�� : mm��");
		for(int i = 0; i<����Ÿ��.length; i++) {
			if(����Ÿ��[i][0] == null)  ����Ÿ��[i][0] = "[ ]";
		}
		for(int i = 0; i<����Ÿ��.length; i++) { // for s
		if(����Ÿ��[i][0].equals("[ ]")) { // �������� ������
		����Ÿ��[i][0] = "[o]";
		����Ÿ��[i][1] = parkStart.toString();
		����Ÿ��[i][2] = carNumber;  // �迭 �ȿ� �迭
		return ����Ÿ��[i];
		} // ���� ä��� �����ð� �迭 ��ø���� �ֱ�										
		} // for e
		return null;
		} // ������� e
	
	public static String ��������(String carNumber) { // �������� s
		Date date = new Date();
		SimpleDateFormat parkEnd = new SimpleDateFormat("hh�� : mm��");
		String ���� = parkEnd.toString();
		for(int i=0; i<����Ÿ��.length; i++) { // for s
		if(����Ÿ��[i][0].equals("[o]") && ����Ÿ��[i][2].equals(carNumber)) 
			{ // ������ȣ ��ġ�ϸ�
		����Ÿ��[i][0] = "[ ]";
		//������� ���(String����)
		int �����ð� = Integer.parseInt(����Ÿ��[i][1]);
		int �����ð� = Integer.parseInt(����);
		int �ð� = �����ð� / 100 - �����ð� / 100; // �ð��� ����
		int �� = �����ð� % 100 - �����ð� % 100; // ���� ����
		int �������ð� = �ð� * 60 + ��;
		int ������ = 1000;
		int ��� = �������ð� / 30 * ������;
		����Ÿ��[i][2] = null;
		System.out.println(���);
		
			}
			} // for e // ������ ĭ ���� ��
		// ���
		return null;
				} // �������� e
	
	
	// �������� ��ü������ ���� �� �μ��� ���� ����ݰ� ���� ����Ʈ�� �����ϴ� �޼���
	public static void ����ݴ���(int �����) {
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
	public static ArrayList<����> ����˻����(int ����, int ��) {	
		ArrayList<����> ���ϸ��� = new ArrayList<>();
		
		String ã������ = ����+"��";	
		String ã���� = ��+"��";	
		
		for(���� tmp : �Ѹ������帮��Ʈ) {	
			if(�Ѹ������帮��Ʈ.contains(ã������) && �Ѹ������帮��Ʈ.contains(ã����)) {	
				���� �ӽð�ü = new ����(tmp.get����ݾ�(), tmp.get��¥());
				���ϸ���.add(�ӽð�ü);
			}
		}
		return ���ϸ���;
	}
	
	// txt���Ͽ��� java�� �о���̴� �޼���
	public static void �������Ϸε�() {
		try {	// FileInputStream ������ �Ϲݿ��� �߻�
			FileInputStream fileInputStream = new FileInputStream("D:/java/���������.txt");
			byte[] �ӽù���Ʈ�迭 = new byte[4096];	// �˳��ϰ� 4KB¥�� �ӽ������ ����Ʈ�� �迭 ����
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
	public static void ������������() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/���������.txt");	// 1. ���� ��� ��ü ����
			for(���� tmp : �Ѹ������帮��Ʈ) {
				String �������Ͽ������ڿ� = tmp.get����ݾ�() + "," + tmp.get��¥() + "," + tmp.get��() + "," + tmp.get����() + "\n";
				fileOutputStream.write(�������Ͽ������ڿ�.getBytes());
			}
		}catch(Exception e) {System.out.println("������������ �޼��� ���� �߻�");}
	}	// ������������ END
	
	public void �׽�Ʈ���ϰ����() {
		for(���� tmp : �Ѹ������帮��Ʈ)
			System.out.println(tmp.get����ݾ�()+"��"+tmp.get��¥()+tmp.get��()+tmp.get����());
	}
	
}	// class END
