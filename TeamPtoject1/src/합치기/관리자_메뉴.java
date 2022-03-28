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
		System.out.println("1. 영화 및 영화 시간등록 2. 음식등록 3. 음식점 재고 등록 4. 등록된 자료 확인 5. 로그아웃"); int ch = scanner.nextInt();
		
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
			System.out.println("재고 등록 ");
			System.out.println("1. 재고 입고 2. 재고 출고");
			int ch1 = scanner.nextInt();
			if(ch1 == 1) {
				System.out.println("재고를 입고할 먹거리 종류를 입력해주세요"); String foodname = scanner.next();
				System.out.println("입고할 재고 수를 입력해주세요");	int 재고 = scanner.nextInt();
				boolean result = admincontroller.재고입고(foodname, 재고);
				if(result) System.out.println("입고 성공");
				else System.out.println("입고 실패!");
			}
			else if(ch1 == 2) {
				System.out.println("재고를 입고할 먹거리 종류를 입력해주세요"); String foodname = scanner.next();
				System.out.println("출고할 재고 수를 입력해주세요");	int 재고 = scanner.nextInt();
				boolean result = admincontroller.재고입고(foodname, 재고);
				if(result) System.out.println("출고 성공!");
				else System.out.println("출고 실패!");
			}
			else {System.out.println("숫자를 잘못입력하셨습니다. 다시 입력해주세요");}
		}else if(ch == 4) {
			System.out.println("등록된 영화와 영화시간 및 음식 확인 ");
			System.out.println("1. 등록된 영화 확인 2. 등록된 음식 확인");
			int ch1 = scanner.nextInt();
			if(ch1 == 1) {
				admincontroller.등록영화();
				System.out.println("1. 영화 및 영화시간 수정 2. 영화 및 영화시간 삭제");
				int ch2 = scanner.nextInt();
				if(ch2 == 1) {
					System.out.println("바꿀 영화의 이름을 입력하세요");
					String movieName = scanner.next();
					System.out.println("바꿀 영화의 시간을 입력하세요");
					String movieTime = scanner.next();
					boolean result = admincontroller.영화와영화시간수정(movieName, movieTime);
					if(result) {}
				}
				else if(ch2 == 2) {
					
				}
			}
			else if(ch1 == 2) {
				admincontroller.등록음식();
				System.out.println("1. 음식 및 음식가격 수정 2. 음식 및 음식가격 삭제");
				int ch2 = scanner.nextInt();
				if(ch2 == 1) {
					
				}
				else if(ch2 == 2) {
					
				}
			}
			else {System.out.println("숫자를 잘못입력하셨습니다. 다시 입력해주세요");}
		}else if(ch == 5) {
			System.out.println("관리자모드를 종료합니다."); scanner.close();	break;
		}else {
			System.out.println("알 수 없는 행동입니다.");
		}
			
	}
	
}
void 음식점메뉴() { // 고객이 보는 음식점 메뉴
	Scanner sc = new Scanner(System.in);
	while(true) {
	System.out.println("음식점에 오신 걸 환영합니다.");
	System.out.println("1. 주문          2. 종료");
	for(음식점_클래스 temp : 관리자컨트롤러.상품리스트) {
		System.out.println("음식 종류 : "+temp.get먹거리종류());
		System.out.println("가격 : "+temp.get가격());
		}
	int ch = sc.nextInt();
	if(ch== 1) {
	System.out.println("먹을 음식의 종류를 입력해주세요"); 	String foodName = sc.next();
	for(음식점_클래스 temp : 관리자컨트롤러.상품리스트) {
		if(temp.get먹거리종류().equals(foodName)) {
			System.out.println("상품의 가격 : " + temp.get가격() + "입니다. ");
			System.out.println("1. 결제     2. 결제 취소"); 
			int ch1 = sc.nextInt();
			if(ch1 == 1) {
				System.out.println("결제를 위해 금액을 입력해주세요");
				int money = sc.nextInt();
				if(temp.get가격() <= money) {
					System.out.println("결제가 완료되었습니다.");
					System.out.println((temp.get가격() - money) + "원을 반환합니다.");
					temp.set재고(temp.get재고()-1);
					break;
				}
				else {System.out.println("결제금이 부족합니다. ");
						System.out.println((temp.get가격() - money) + "원 더 투입해주세요.");}
			}
			else if(ch1 == 2) {
				System.out.println("결제를 취소하셨습니다. 처음부터 다시 시도해주세요");
				break;
			}
		}
		else System.out.println("없는 음식입니다. 다시 주문해주세요");
	}
			}
	else if(ch==2) {System.out.println("음식점을 이용해주셔셔 감사합니다."); break;}
	
	
	}
}

} // ce