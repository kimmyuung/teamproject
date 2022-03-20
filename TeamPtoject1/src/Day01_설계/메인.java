package Day01_설계;

import java.util.Scanner;

public class 메인 { // c s
public static void main(String[] args) { // ms
	Scanner sc = new Scanner(System.in);
	
		try { // t s
	while(true) { // w s
		
//		System.out.println("몇층짜리 주차장인지 입력해주세요.");
//		int floor = sc.nextInt();
		
		System.out.println("[[1. 입차  2. 출차  3. 매출확인]]");
		int select = sc.nextInt();
		컨트롤러.매출파일로딩(); 
		
		if(select == 1) {
				System.out.println("차량번호를 입력해주세요");
				String carNumber = sc.next();
				컨트롤러.차량등록(carNumber);				
				System.out.println("주차되었습니다.");
				
				for(int i = 0; i < 컨트롤러.주차타워.length; i++) {
					if(컨트롤러.주차타워[i][0] != null) {System.out.print(컨트롤러.주차타워[i][0]);}
					if(i % 4 == 3) System.out.println();
				}
		}
		
		else if(select == 2) {
			System.out.println("차량번호를 입력해주세요");
			String carNumber = sc.next();
			컨트롤러.차량삭제(carNumber);
			
			System.out.println("금액을 입력해주세요");
			int 금액 = sc.nextInt();
			컨트롤러.주차계산(금액);
			
			int 정산금 = 컨트롤러.주차계산(금액);
			컨트롤러.정산금누적(정산금);
			
		}
		
		else if(select == 3) {
			System.out.println("매출 확인");
			System.out.println("매출을 확인할 연도를 입력해주세요");
			int 연도 = sc.nextInt();
			System.out.println("매출을 확인할 개월을 입력해주세요");
			int 월 = sc.nextInt();
			컨트롤러.매출검색출력(연도, 월);
			
		}
		else if(select < 0) {System.out.println("숫자를 잘못입력하셨습니다. 다시 입력해주세요");}
		else {System.out.println("잘못된 숫자를 입력하셨습니다. 다시 입력해주세요.");}
		
		
		
		} // w1 e
		}catch(Exception e) {System.out.println("숫자를 입력하십시오");} // tc e
	} // m e
} // c e
