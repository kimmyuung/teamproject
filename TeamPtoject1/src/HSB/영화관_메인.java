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
//			System.out.print("어"); //상영중인 영화 출력 for문 예정
//			Thread.sleep(1000);
//			System.out.print("\t서");
//			Thread.sleep(1000);
//			System.out.print("\t오");
//			Thread.sleep(1000);
//			System.out.print("\t세");
//			Thread.sleep(1000);
//			System.out.print("\t요");
//			Thread.sleep(1000);
//			System.out.println("");
			System.out.println("---------------------------------------------------");
			System.out.println("\t\t1.영화보기 2.먹거리선택");
			int ch= scanner.nextInt();
			if(ch==1){
				System.out.println("영화제목을 입력해주세요.");
				String movieTitle = scanner.next();
				boolean result=movieController.영화선택(movieTitle);
				
				if(result) {
					System.out.println("시간을 선택해주세요.");
					System.out.println("------------------------------------------");
					System.out.println(); //시간 선택창 띄우기
					System.out.println("------------------------------------------");
					
					System.out.println("좌석을선택해주세요.");
					System.out.println("------------------------------------------");
					while(true) {
					movieController.좌석출력();
						System.out.println("------------------------------------------");
						System.out.print("원하는 좌석을 선택해주세요.  >");
						int ch1=scanner.nextInt();
						
						boolean result2=movieController.좌석선택(ch1);
						if(result2) {
							System.out.println("좌석이 선택되었습니다.");
						}else {
							System.out.println("좌석선택 실패 !! ");
						}
					}	
				}else{			
					System.out.println("wellcome admin");
				}
			}//영화 선택
			else if (ch==2) {
				System.out.println();//현재 먹거리 메뉴 출력
			}//먹거리 선택
		
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}