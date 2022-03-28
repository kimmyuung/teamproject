package 합치기;

import java.util.Scanner;

public class 관리자_메뉴 {

	public static void main(String[] args) {
		관리자_메뉴 app = new 관리자_메뉴();
		app.메뉴();
	}

void 메뉴() {
	Scanner scanner = new Scanner(System.in);
	while(true) {
		관리자컨트롤러 admincontroller = new 관리자컨트롤러();
		
		System.out.println("관리자메뉴");
		System.out.println("1. 영화 및 영화 시간등록 2. 음식등록 3. 매출확인 4. 자료 확인 5. 로그아웃"); int ch = scanner.nextInt();
		
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
			System.out.println("먹거리 종류를 입력하세요");  String foodName = scanner.next();
			System.out.println("먹거리 가격을 입력하세요"); 	int foodPrice = scanner.nextInt();
			
			boolean result = admincontroller.음식등록(foodName, foodPrice, 0);
			if(result) {System.out.println("먹거리가 등록되었습니다.");}
			else {System.out.println("먹거리 등록 실패!!");}
		}else if(ch == 3) {
			System.out.println("매출 확인 ");
			System.out.println("1. 영화관 매출 확인 2. 음식점 매출 확인");
			int ch1 = scanner.nextInt();
			if(ch1 == 1) {
				
			}
			else if(ch1 == 2) {
				
			}
			else {System.out.println("숫자를 잘못입력하셨습니다. 다시 입력해주세요");}
		}else if(ch == 4) {
			System.out.println("등록된 영화와 영화시간 및 음식 확인 ");
			System.out.println("1. 등록된 영화 확인 2. 등록된 음식 확인");
			int ch1 = scanner.nextInt();
			if(ch1 == 1) {
				
			}
			else if(ch1 == 2) {
				
			}
			else {System.out.println("숫자를 잘못입력하셨습니다. 다시 입력해주세요");}
		}else if(ch == 5) {
			System.out.println("관리자모드를 종료합니다."); break;
		}else {
			System.out.println("알 수 없는 행동입니다.");
		}
			
	}
	
}
void 음식점메뉴() {
	
}

} // ce