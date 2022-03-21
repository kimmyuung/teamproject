package Day01_설계;

import java.util.ArrayList;
import java.util.Scanner;

import 컨트롤러어.매출;

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
			boolean isInputRight = true;	// 사용자가 예상한대로 값을 입력했는지 기록하는 플래그. true : 정상실행
			System.out.printf("검색할 연도를 정수로 입력하세요.\n입력예시) 2022년 : 22\n입력가능연도 : 20~22\n입력 >");
			int year = sc.nextInt();
			System.out.printf("%2d년에서 검색할 달을 정수로 입력하세요.\n입력예시)03월 : 3\n입력 >",year);
			int month = sc.nextInt();
			System.out.print("정렬기준을 고르시오\n1. 일자 | 2. 금액\n선택 >");
			int sortBy = sc.nextInt();
			System.out.println("=====================================");
			
			if(sortBy<1 || sortBy>2 ) {	// 만약 정렬기준을 1번이나 2번이 아닌걸 고르면
				System.out.println("제발 보기 안에 있는걸 골라주세요...");
				isInputRight=false;
			}else if(month<1 || month>12) {	// 검색 달을 1~12월 밖으로 입력하면
				System.out.println("제발 1월에서 12월까지만 넣어주세요...");
				isInputRight=false;
			}else if(year<20 || year>22) {
				System.out.println("입력년도를 확인하세요.\n입력가능연도 : 20~22년");
				isInputRight=false;
			}
			
			if(isInputRight==true) {	
				ArrayList<매출> 검색결과출력용리스트 =  new ArrayList<>(컨트롤러.매출출력(year, month, sortBy));
				if(검색결과출력용리스트.size()==0)	// 만약 리턴받은 리스트에 암것도 ㅇ벗으면
					System.out.println("입력한 기간에는 매출이 없습니다.");
				int sum=0;
				for(매출 tmp : 검색결과출력용리스트) {
						System.out.printf("%d년 %2d월 %3s 매출 : %s원\n", year, month, tmp.get날짜(), tmp.get매출금액());
						sum += tmp.get매출금액();
				}
				System.out.printf("\n%d년 %2d월의 매출액 합계는 %5d원 입니다.\n",year,month,sum);
				System.out.println("=====================================");
			}
		}
		else if(select < 0) {System.out.println("숫자를 잘못입력하셨습니다. 다시 입력해주세요");}
		else {System.out.println("잘못된 숫자를 입력하셨습니다. 다시 입력해주세요.");}
		
		
		
		} // w1 e
		}catch(Exception e) {System.out.println(e);} // tc e
	} // m e
} // c e
