package HSB;

import java.util.Scanner;

public class 영화관_메인{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		관리자_메뉴 관리자메뉴 = new 관리자_메뉴();
		고객컨트롤러 movieController = new 고객컨트롤러();
		
		while(true) {
			try {
				System.out.println("");
				System.out.println("-------------어서오십시오.ezen movie-------------------");
//			System.out.print(""); //상영중인 영화 출력 for문 예정
//			Thread.sleep(500);
//			System.out.print("\t준");
//			Thread.sleep(500);
//			System.out.print("\t서");
//			Thread.sleep(500);
//			System.out.print("\t기");
//			Thread.sleep(500);
//			System.out.print("\t짱");
//			Thread.sleep(500);
//			System.out.println("");
			System.out.println("---------------------------------------------------");
			System.out.println("\t\t1.영화보기 2.먹거리선택");
			int ch= scanner.nextInt();
			
			//영화보기 선택 시
			if(ch==1){
				System.out.println("영화제목을 입력해주세요.");
				String movieTitle = scanner.next();
				boolean result=movieController.영화선택(movieTitle);
				
				if(result) {
					System.out.println("시간을 선택해주세요.");
					System.out.println("------------------------시간선택----------------------");
					System.out.println(); //시간 선택창 띄우기
					System.out.println("----------------------------------------------------");
					System.out.println("------------------------인원선택-----------------------");
					System.out.println("성인인원을 선택해 주세요.");
					int adult = scanner.nextInt();
					System.out.println("청소년 인원을 선택해 주세요");
					int yougth =scanner.nextInt();
					System.out.println("유아 인원을 선택해 주세요.");
					int child =scanner.nextInt();
					System.out.println("장애인 인원을 선택해주세요.");
					int dp =scanner.nextInt();
					System.out.println("------------------------좌석선택-----------------------");				
					while(true) {
						System.out.println("┌───────SCREEN───────┐  ┌─");
						System.out.println("└────────────────────┘  │e");
						System.out.println("			│x");
						System.out.println("			│i");
						System.out.println("			│t");
						System.out.println("			└─");
						movieController.좌석출력(adult, yougth, child, dp);
  						System.out.println("                      ┌IN┐");
						System.out.println("--------------------------------------------------");
						System.out.print("원하는 좌석을 선택해주세요.  >");
						int ch1=scanner.nextInt();
						boolean result2=movieController.좌석선택(adult ,yougth , child ,dp ,ch1);
						if(result2) {
							System.out.println("좌석이 선택되었습니다.");
						String sum=movieController.결제(adult, yougth, child, dp);
						System.out.println("총 결제 금액 :"+sum);
						System.out.println("결제금액을 입력해주세요.");
						int pay = scanner.nextInt();
						String ticket=movieController.티켓발급();
						System.out.println("티켓번호 : "+ticket);
						
							break;
						}else {
							System.out.println("좌석선택 실패 !! ");
						}
					}	
				}else{			
					System.out.println("wellcome admin");
				}
			}//영화 선택
			
			//먹거리 선택 시
			else if (ch==2) {
				System.out.println();//현재 먹거리 메뉴 출력
			}//먹거리 선택
		
			}catch (Exception e) {
				scanner = new Scanner(System.in);
			}
		}
	}

}