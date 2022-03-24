package 합치기;

import java.time.LocalTime;
import java.util.ArrayList;



public class 관리자컨트롤러 {

	static ArrayList<관리자_클래스> 영화리스트 = new ArrayList<>();

	boolean 영화등록(String 영화이름, String 영화시간) {
		
		for(관리자_클래스 temp : 영화리스트) {
			if(temp != null && temp.get영화제목().equals(영화이름)) {
				System.out.println(1); return false;
			}
		}
		
		관리자_클래스 관리자 = new 관리자_클래스(영화이름, 영화시간, null, 0);
		영화리스트.add(관리자);
		return true;

	}


	void 음식등록() {
	}

	void 매출확인() {
	}

}