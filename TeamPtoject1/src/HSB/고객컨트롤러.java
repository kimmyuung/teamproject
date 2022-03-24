package HSB;

import java.util.ArrayList;

public class 고객컨트롤러 {

	영화티켓 영화티켓 = new 영화티켓();
	관리자_메뉴 관리자메뉴 = new 관리자_메뉴();
	static ArrayList<영화티켓> movieTicket = new ArrayList<>();
	static String [] 좌석 = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"
							};
	
	
	public void 좌석출력() {
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
	}
	
	public boolean 좌석선택(int ch1) {
		for(String temp: 좌석) {
			if(temp.equals("[ ]")) {
				좌석[(ch1-1)]="[ x ]";
				
				return true;
			}	
			
		}
		return false;
	}
	
	public void 티켓발급() {}//티켓발급 end
	
	public void 티켓출력() {}//티켓출력 end
	
	public void 예매티켓출력() {}//예매티켓출력 end
	
	public boolean 영화선택(String movieTitle) {
	 
			if(movieTitle.equals("admin")) {
				관리자메뉴.메뉴();
				return false;
			}
		
		return true;
	}//영화선택 end
	
	public void 시간() {}//시간 end
	
	public void 좌석() {}//좌석 end
	
	public void 결제() {}//결제 end
	
	public void 관리자() {}//관리자 end
	
	
	
}
