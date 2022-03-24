package 합치기;

import java.util.Scanner;

public class 영화관_메인{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		고객컨트롤러 movieController = new 고객컨트롤러();
		while(true) {
			System.out.println("-------------어서오십시오.ezen movie-------------------");
			System.out.println(); //상영중인 영화 출력 for문 예정
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
					
				}
				System.out.println("찾을 수 없는 영화제목입니다.");
				
				
			}//영화 선택
			else if (ch==2) {
				System.out.println();//현재 먹거리 메뉴 출력
			}//먹거리 선택
			
		
		}
	}

}