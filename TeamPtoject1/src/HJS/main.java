package HJS;

import java.time.LocalTime;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			admincontroller admincontroller = new admincontroller();
			
			System.out.println("관리자메뉴");
			System.out.println("1. 영화등록 2. 영화시간등록 3. 음식등록 4. 매출확인 5. 로그아웃"); int ch = scanner.nextInt();
			
			if(ch == 1) {
				
				
				System.out.print("영화이름 : "); String 영화이름 = scanner.next();
				System.out.print("영화 시간을 입력해주세요 : "); String 영화시간 = scanner.next();
				
				Boolean 통과 = admincontroller.영화등록(영화이름, 영화시간);
				
				if(통과) {
					
					System.out.println("영화가 등록되었습니다.");
				}else {
					System.out.println("영화 등록 실패.");
				}
				
			}else if(ch == 1) {
				
			}else if(ch == 2) {
				
			}else if(ch == 3) {
				
			}else if(ch == 4) {
				
			}else if(ch == 5) {
				
			}else {
				System.out.println("알 수 없는 행동입니다.");
			}
				
		}
		
	}
	
}
