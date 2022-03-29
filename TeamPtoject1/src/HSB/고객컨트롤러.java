package HSB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	
	public void 좌석출력(int adult, int yougth , int child , int dp) {
		
		int i = 1;

		for(String temp: 좌석) {
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
		
	}//좌석출력 end
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

	public String 티켓발급() {
		
		int rd = random.nextInt(10000);
		DecimalFormat df=new DecimalFormat("0000");
		String ticketNb = df.format(rd);
		
		return ticketNb;
	}//티켓발급 end
	
   public boolean 예매티켓확인(String reser) {
		
		for(영화티켓 temp :movieTicket ) {
			if(temp.get티켓번호().equals(reser)) {
				return true;
			}
			
		}
		return false;
	}//예매티켓출력 end
	
	public boolean 영화선택(String movieTitle) {
		for(관리자_클래스 temp : 관리자컨트롤러.영화리스트) {
			if(movieTitle.equals("admin") || movieTitle.equals("ADMIN") || movieTitle.equals("Admin")) {
				관리자메뉴.메뉴();
				return false;
			}
			else if(temp.get영화제목().equals(movieTitle)) {
				return true;
			}
		}
		
		return true;
	}//영화선택 end
	
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
	
	public void 티켓저장(String time , String title , String ticket , int sumPerson ) {
		영화티켓 영화티켓저장= new 영화티켓(time, title, ticket, sumPerson);
		movieTicket.add(영화티켓저장);
	}//티켓저장
	
	public void 음식점이용() {
		관리자메뉴.음식점메뉴();
	}

	public void 결제취소() {
		

		for(int i = 0; i < 좌석.length; i++) {
			좌석[i] = "[ ]";
		}
		return;
	}
	
	public void 관리자모드() {
		관리자메뉴.메뉴();
	}
	public void 티케팅저장() {
		try {
			FileOutputStream outputStream = new FileOutputStream("D:/자바/티켓.txt");
			for(영화티켓 temp : movieTicket) {
				String 티켓내용 = temp.get영화제목()+","+temp.get영화시간()+","+temp.get티켓번호()+","+temp.get인원수()+"/n";
			outputStream.write(티켓내용.getBytes());	
			}
		} catch (Exception e) {
			System.out.println("!!!!!!!!!!!!파일 저장 실패 !! 관리자 문의 필요!");
		}
	}
	
	public void 티켓팅출력() {
		try {
			FileInputStream inputStream = new FileInputStream("D:/자바/티켓.txt");
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
			영화티켓 티켓 = new 영화티켓(field[0], field[1], field[2], Integer.parseInt(field[3]));
					movieTicket.add(티켓);
				
			}
		} catch (Exception e) {
			System.out.println("파일 출력 실패!! 관리자 문의!!");
		}
		
	}
}
