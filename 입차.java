package Day01_설계;

import java.util.Scanner;

public class 입차 {
	
	public static void main(String[] args) {//cs
		
		Scanner scanner = new Scanner(System.in);
		
		int[] 주차자리 = new int[12];
		
		//번호 입력 받기/12자리 0~11
		for(int i =0; i<12; i++) {
			//i는 0부터 11까지 증가 반복
			System.out.println("0~11사이 입력:");
			int 번호 = scanner.nextInt();
			
			boolean 주차 = true; //저장되는 조건변수
					
			//조건1. 주차장내에서의 주차 여부
			if(번호<0 || 번호>11) {//0보다 작거나 12이상은x
				System.out.println("알림)) 잘못입력하셨습니다.[재입력]");
				i--;
				주차 = false;
			}//if end
			
			//조건2 중복체크
				//배열내 모든 인덱스 호출
			for(int j=0; j<12; j++) {
				if(번호 == 주차자리[j]) {
				//2.자리 중복체크
					System.out.println("알림)) 이미 주차된 자리입니다.[재입력]");
					i--;
					주차 = false; //저장x
					}
				}
			//정상입력(주차가 true)이면 배열에 저장
			if(주차==true) 주차자리[i]=번호;
			}
			System.out.print("\n사용자가 선택한 주차한 자리 번호:");
			
			//*사용자 배열내 모든 인덱스 출력
			for(int temp : 주차자리) {
				System.out.println(temp +"\t");
			}
		
	
	}//me

}//cs
