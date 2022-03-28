package 합치기;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class 고객컨트롤러 {

	영화티켓 영화티켓 = new 영화티켓();
	관리자_메뉴 관리자메뉴 = new 관리자_메뉴();
	Random random = new Random();
	static ArrayList<영화티켓> movieTicket = new ArrayList<>();
	static String [] 좌석 = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"
							};
	
	//v
	public void 좌석출력(int adult, int yougth , int child , int dp) {
		
		int i = 1;

		for(String temp: 좌석) {
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
		
	}//좌석출력 end
	//v
	public boolean 좌석선택(int adult, int yougth , int child , int dp , int ch1 ) {
	
		int person = (adult+yougth+child+dp);
	
	
		if(좌석[(ch1-1)].equals("[ x ]")) {
			return false;
		}
		
		
		for(int i=0; i<person; i++) {
			for(String temp: 좌석) {
				if(1<=person && temp.equals("[ ]")) {
					좌석[(ch1-1)]="[ x ]";
					person--;
					
				}			
			}
		}
			if(person==0) {
			return true;
			}
			return false;
	}//좌석선택 end
	//△
	public String 티켓발급() {
		
		int rd = random.nextInt(10000);
		DecimalFormat df=new DecimalFormat("0000");
		String ticketNb = df.format(rd);
		
		return ticketNb;
	}//티켓발급 end
	
	public String 예매티켓출력(int reser) {
		
		int rd = random.nextInt(1000000);
		DecimalFormat df=new DecimalFormat("0000000");
		String reservation = df.format(rd);
		
		return reservation;
	}//예매티켓출력 end
	
	public boolean 영화선택(String movieTitle) {
	 
			if(movieTitle.equals("admin")) {
				관리자메뉴.메뉴();
				return false;
			}
		
		return true;
	}//영화선택 end
	
	public void 시간() {}//시간 end
	//v
	public int 금액계산(int adult, int yougth , int child , int dp ) {
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
	}//금액계산 end
	
	public int 결제(int adult, int yougth , int child , int dp , int pay) {
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
	
	public void 티켓저장(String title) {
		영화티켓 영화티켓저장= new 영화티켓(title, null, 티켓발급(), 0);
		movieTicket.add(영화티켓저장);
	}
	
	public void 음식점이용() {
		관리자메뉴.음식점메뉴();
	}


	
	
}
