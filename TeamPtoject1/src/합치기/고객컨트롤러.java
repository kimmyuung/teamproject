package 합치기;

import java.util.ArrayList;

public class 고객컨트롤러 {

	static ArrayList<영화티켓> movieTicket = new ArrayList<>();
	static String [] 좌석 = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
	};
	
	
	
	public void 좌석출력() {}
	
	public void 티켓발급() {}//티켓발급 end
	
	public void 티켓출력() {}//티켓출력 end
	
	public void 예매티켓출력() {}//예매티켓출력 end
	
	public boolean 영화선택(String movieTitle) {
		for(영화티켓 temp : movieTicket) {
			if(temp.get영화제목().equals(movieTitle)) {
				return true;
			}
		}
		return false;
	}//영화선택 end
	
	public void 시간() {}//시간 end
	
	public void 좌석() {}//좌석 end
	
	public void 결제() {}//결제 end
	
	public void 관리자() {}//관리자 end
	
	
	
}
