package ��ġ��;

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
	
	//v
	public void �¼����(int adult, int yougth , int child , int dp) {
		
		int i = 1;

		for(String temp: �¼�) {
			if(temp.equals("[ x ]")) {
				System.out.print("[x]");
				if(i%5==0) {
					System.out.println("");
				}
			}
			
			if(temp.equals("[ ]")) {
				System.out.printf("["+i+"]",i);
				if(i%5==0) {
					System.out.println("");
				}		
			}
			i++;
		}
		return;
		
	}//�¼���� end
	//v
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
	//��
	public String Ƽ�Ϲ߱�() {
		
		int rd = random.nextInt(10000);
		DecimalFormat df=new DecimalFormat("0000");
		String ticketNb = df.format(rd);
		
		return ticketNb;
	}//Ƽ�Ϲ߱� end
	
	public String ����Ƽ�����(int reser) {
		
		int rd = random.nextInt(1000000);
		DecimalFormat df=new DecimalFormat("0000000");
		String reservation = df.format(rd);
		
		return reservation;
	}//����Ƽ����� end
	
	public boolean ��ȭ����(String movieTitle) {
	 
			if(movieTitle.equals("admin")) {
				�����ڸ޴�.�޴�();
				return false;
			}
		
		return true;
	}//��ȭ���� end
	
	public void �ð�() {}//�ð� end
	//v
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
	
	public void Ƽ������(String title) {
		��ȭƼ�� ��ȭƼ������= new ��ȭƼ��(title, null, Ƽ�Ϲ߱�(), 0);
		movieTicket.add(��ȭƼ������);
	}
	
	public void �������̿�() {
		�����ڸ޴�.�������޴�();
	}


	
	
}
