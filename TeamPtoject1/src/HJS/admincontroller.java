package HJS;

import java.time.LocalTime;
import java.util.ArrayList;



public class admincontroller {

	static ArrayList<admin> 영화리스트 = new ArrayList<>();

	boolean 영화등록(String 영화이름, String 영화시간) {
		
		for(admin temp : 영화리스트) {
			if(temp != null && temp.get영화제목().equals(영화이름)) {
				System.out.println(1); return false;
			}
		}
		
		admin 관리자 = new admin(영화이름, 영화시간, null, 0);
		영화리스트.add(관리자);
		return true;

	}


	void 음식등록() {
	}

	void 매출확인() {
	}

}
