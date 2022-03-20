package 컨트롤러어;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		컨트롤러 메인컨트롤러 = new 컨트롤러();
		
		
		/*
		 *  합칠때 해야할것
		 *  1. 주차장 실행하기 전(main클래스 내 최상단) 매출파일로딩 메서드 실행
		 *  2. if ch==1 부분은 필요없음. ch==2부분만 복붙하면 됨.
		 */
		
		
		Scanner scanner = new Scanner(System.in);
		메인컨트롤러.매출파일로딩();
		메인컨트롤러.테스트용일괄출력();	// 테스트용 메서드
		for(int i=0; i<200; i++)	// 테스트용 매출액 파일 랜덤생성
			메인컨트롤러.노가다귀찮다();	
		
		while(true) {
			System.out.println("1. 주차장정산금액 입력 | 2. 검색");
			System.out.print("입력 >");
			int ch=scanner.nextInt();
			if(ch==1) {
				System.out.println("주차정산금액 입력");
				int 출차하면서받은금액 = scanner.nextInt();
				메인컨트롤러.정산금누적(출차하면서받은금액);
			}	
			
				
			
			else if(ch==2) {	
				boolean isInputRight = true;	// 사용자가 예상한대로 값을 입력했는지 기록하는 플래그. true : 정상실행
				System.out.printf("검색할 연도를 정수로 입력하세요.\n입력예시) 2022년 : 22\n입력가능연도 : 20~22\n입력 >");
				int year = scanner.nextInt();
				System.out.printf("%2d년에서 검색할 달을 정수로 입력하세요.\n입력예시)03월 : 3\n입력 >",year);
				int month = scanner.nextInt();
				System.out.print("정렬기준을 고르시오\n1. 일자 | 2. 금액\n선택 >");
				int sortBy = scanner.nextInt();
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
					ArrayList<매출> 검색결과출력용리스트 =  new ArrayList<>(메인컨트롤러.매출출력(year, month, sortBy));
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
			}	// 검색매뉴진입 else if END
		}	// while END
	}	// main END
}	// class END
