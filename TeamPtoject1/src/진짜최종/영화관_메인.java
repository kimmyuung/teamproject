package 진짜최종;

import java.text.DecimalFormat;
import java.util.Scanner;



import java.text.DecimalFormat;
import java.util.Scanner;



public class 영화관_메인{
	static Scanner scanner = new Scanner(System.in);
	static 고객컨트롤러 movieController = new 고객컨트롤러();
	영화티켓 영화티켓 = new 영화티켓();
	public static void main(String[] args) {
		영화관_메인 app = new 영화관_메인();
		app.메인메뉴();
	}	
	static void 메인메뉴() {
		try {
		while(true) {
			
			System.out.println("");
			System.out.println("-------------어서오십시오.ezen movie-------------------");
			관리자컨트롤러.영화출력();
			System.out.printf("%10s \t %10s \n", "영화제목", "영화시간");
			
			for( 관리자_클래스 temp : 관리자컨트롤러.영화리스트 ) {
				System.out.printf("%10s\t%10s \n", temp.get영화제목() ,
						temp.get영화시간() );
			}
			System.out.println("---------------------------------------------------");
			System.out.println("\t1.영화티켓발급  2.먹거리선택  3.영화보기");
			int ch= scanner.nextInt();
			
			//영화보기 선택 시
			if(ch==1){
				System.out.println("영화제목을 입력해주세요.");
				String movieTitle = scanner.next();
				boolean result=movieController.영화선택(movieTitle);
				
				if(result) {
					System.out.println("시간을 선택해주세요.");		
					String movieTime = scanner.next();
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
					int personSum =(adult+yougth+child+dp);
					
					for(int i= 0; i<personSum; i++) {
						System.out.println("------------------------좌석선택-----------------------");			
						System.out.println("┌───────SCREEN───────┐  ┌─");
						System.out.println("└────────────────────┘  │E");
						System.out.println("			│X");
						System.out.println("			│I");
						System.out.println("			│T");
						System.out.println("			└─");
						movieController.좌석출력(adult, yougth, child, dp);
  						System.out.println("                      ┌IN┐");
						System.out.println("--------------------------------------------------");
						System.out.print("원하는 좌석을 선택해주세요.  >");
						int ch1=scanner.nextInt();
						
						
						//좌석선택
							boolean result2=movieController.좌석선택(adult ,yougth , child ,dp ,ch1);
							if(result2) {
								System.out.println("좌석이 선택되었습니다.");
							
							}else {
								System.out.println("좌석선택 실패 !! ");
								System.out.println("이미 선택된 좌석이거나 존재하지 않는 좌석입니다.");
								System.out.println("다른 좌석을 선택해 주세요.");
								personSum++;
								
							}	
						}	
						//금액계산
						int sum=movieController.금액계산(adult, yougth, child, dp);
						//결제금액 형식 변환
						DecimalFormat df= new DecimalFormat("###,###원");
						String sum2 = df.format(sum);
						System.out.println("총 결제 금액 :"+sum2);
						System.out.print("결제금액을 입력해주세요.");
						int pay = scanner.nextInt();
						
						//잔액 계산 형식 변환
						int payBack1=(pay-sum);
						String payBack =df.format(payBack1);
						//결제
						int result3=movieController.결제(adult, yougth, child, dp, pay);
						System.out.print("결");
						Thread.sleep(500);
						System.out.print("제");
						Thread.sleep(500);
						System.out.print("확");
						Thread.sleep(500);
						System.out.println("인");
						Thread.sleep(500);
						if(result3==1) {
							System.out.println("결제가 완료되었습니다.");
							
						}
						else if(result3==2){
							System.out.println("결제 금액이 부족합니다.");
							movieController.결제취소();	
						}
						else if(result3==3){
							System.out.println("결제가 완료되었습니다.");
							System.out.println("잔액:"+(payBack));
							
						
						}else {
							System.out.println("알수없는 행동입니다.");
							
						}
				
						if(result3==1 || result3==3) {
						String ticket=movieController.티켓발급();
						System.out.println("티켓번호 : "+ticket);
						
						//티켓 저장
						movieController.티켓저장(movieTime, movieTitle , ticket , personSum);
						}	
					
				}else{			
					System.out.println("wellcome admin");
				}
				
			}//영화 선택
			
			//먹거리 선택 시
			else if (ch==2) {
				movieController.음식점이용();
				// 관리자_메뉴의 음식점이용 출력
			}//먹거리 선택 end
			
			//예매티켓 확인
			else if(ch==3) {
				 System.out.println("발급 받으신 예매티켓 번호를 입력하여 주세요.");
				 String reser = scanner.next();
				boolean anyReser = movieController.예매티켓확인(reser);
				
				if(anyReser) {
					
					for(영화티켓 temp : 고객컨트롤러.movieTicket) {
						if(temp.get티켓번호().equals(reser)) {
							System.out.println("\t┌────────Movie ticket────────┐");
							System.out.println("");
							System.out.println("\t   영화 시간: "+temp.get영화시간());
							System.out.println("\t------------------------------");
							System.out.println("\t   영화 제목: "+temp.get영화제목());
							System.out.println("\t------------------------------");
							System.out.println("\t   티켓 번호: "+temp.get티켓번호());
							System.out.println("\t------------------------------");
							System.out.println("\t   총 인원수: "+temp.get인원수()+"명");
							System.out.println("");
							System.out.println("\t└────────────────────────────┘");
						}
					}
					System.out.println("즐거운 관람 되십시오.");
				}else {
					System.out.println("일치하는 정보가 없습니다.");
				}
				 
			}
			}
		}catch (Exception e) {
			scanner = new Scanner(System.in);
		}
	}

}