package HSB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;







public class ����Ʈ�ѷ� {

	��ȭƼ�� ��ȭƼ�� = new ��ȭƼ��();
	������_�޴� �����ڸ޴� = new ������_�޴�();
	Random random = new Random();
	static ArrayList<��ȭƼ��> movieTicket = new ArrayList<>();
	static String [] �¼� = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"
							};
	
	public void �¼����(int adult, int yougth , int child , int dp) {
		
		int i = 1;

		for(String temp: �¼�) {
			if(temp.equals("[ x ]")) {
				System.out.print("[xx]");
				if(i%5==0) {
					System.out.println("");
				}
			}
			
			if(temp.equals("[ ]") && i<10) {
				System.out.printf("["+0+i+"]",i);
				if(i%5==0) {
					System.out.println("");
				}		
			}
			
			if(temp.equals("[ ]") && i>=10) {
				System.out.printf("["+i+"]",i);
					
				if(i%5==0) {
					System.out.println("");
				}		
			}
			i++;
		}
		return;
		
	}//�¼���� end
	public boolean �¼�����(int adult, int yougth , int child , int dp , int ch1 ) {
	
		int person = (adult+yougth+child+dp);
	
	
		if(�¼�[(ch1-1)].equals("[ x ]")) {
			return false;
		}
		
		
		for(int i=0; i<person; i++) {
			for(String temp: �¼�) {
				if(1<=person && temp.equals("[ ]")) {
					�¼�[(ch1-1)]="[ x ]";
					person--;
					
				}			
			}
		}
			if(person==0) {
			return true;
			}
			return false;
	}//�¼����� end

	public String Ƽ�Ϲ߱�() {
		
		int rd = random.nextInt(10000);
		DecimalFormat df=new DecimalFormat("0000");
		String ticketNb = df.format(rd);
		
		return ticketNb;
	}//Ƽ�Ϲ߱� end
	
   public boolean ����Ƽ��Ȯ��(String reser) {
		
		for(��ȭƼ�� temp :movieTicket ) {
			if(temp.getƼ�Ϲ�ȣ().equals(reser)) {
				return true;
			}
			
		}
		return false;
	}//����Ƽ����� end
	
	public boolean ��ȭ����(String movieTitle) {
		for(������_Ŭ���� temp : ��������Ʈ�ѷ�.��ȭ����Ʈ) {
			if(movieTitle.equals("admin") || movieTitle.equals("ADMIN") || movieTitle.equals("Admin")) {
				�����ڸ޴�.�޴�();
				return false;
			}
			else if(temp.get��ȭ����().equals(movieTitle)) {
				return true;
			}
		}
		
		return true;
	}//��ȭ���� end
	
	public int �ݾװ��(int adult, int yougth , int child , int dp ) {
		    int person =(adult+yougth+child+dp);
		     adult=adult*15000;
			 yougth=yougth*9000;
			 child=child*5000;
			 dp=dp*8000;
			int sum=(adult+yougth+child+dp);
			if(person >=0) { 
			return sum;
			}else {
				return 0;
			}
	}//�ݾװ�� end
	
	public int ����(int adult, int yougth , int child , int dp , int pay) {
	     adult=adult*15000;
		 yougth=yougth*9000;
		 child=child*5000;
		 dp=dp*8000;
		int sum=(adult+yougth+child+dp);
		if(sum==pay) {
			return 1;
		}else if(sum>pay) {
			return 2;
		}else if (sum<pay) {
			return 3;
		}
		return 4;
		
	}
	
	public void Ƽ������(String time , String title , String ticket , int sumPerson ) {
		��ȭƼ�� ��ȭƼ������= new ��ȭƼ��(time, title, ticket, sumPerson);
		movieTicket.add(��ȭƼ������);
	}//Ƽ������
	
	public void �������̿�() {
		�����ڸ޴�.�������޴�();
	}

	public void �������() {
		

		for(int i = 0; i < �¼�.length; i++) {
			�¼�[i] = "[ ]";
		}
		return;
	}
	
	public void �����ڸ��() {
		�����ڸ޴�.�޴�();
	}
	public void Ƽ��������() {
		try {
			FileOutputStream outputStream = new FileOutputStream("D:/�ڹ�/Ƽ��.txt");
			for(��ȭƼ�� temp : movieTicket) {
				String Ƽ�ϳ��� = temp.get��ȭ����()+","+temp.get��ȭ�ð�()+","+temp.getƼ�Ϲ�ȣ()+","+temp.get�ο���()+"/n";
			outputStream.write(Ƽ�ϳ���.getBytes());	
			}
		} catch (Exception e) {
			System.out.println("!!!!!!!!!!!!���� ���� ���� !! ������ ���� �ʿ�!");
		}
	}
	
	public void Ƽ�������() {
		try {
			FileInputStream inputStream = new FileInputStream("D:/�ڹ�/Ƽ��.txt");
			byte [] bytes = new byte[1000];
			inputStream.read(bytes);
			String file = new String(bytes);
			String [] files = file.split("\n");
			int i = 0 ;
			for(String temp : files) {
				if(i+1==files.length) {
					break;
				}
			String []  field = temp.split(",");
			��ȭƼ�� Ƽ�� = new ��ȭƼ��(field[0], field[1], field[2], Integer.parseInt(field[3]));
					movieTicket.add(Ƽ��);
				
			}
		} catch (Exception e) {
			System.out.println("���� ��� ����!! ������ ����!!");
		}
		
	}
}
