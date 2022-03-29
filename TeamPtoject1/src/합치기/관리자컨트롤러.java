package 합치기;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalTime;
import java.util.ArrayList;



public class 관리자컨트롤러 {

	static ArrayList<관리자_클래스> 영화리스트 = new ArrayList<>();
	static ArrayList<음식점_클래스> 상품리스트 = new ArrayList<>();
	
	boolean 영화등록(String 영화이름, String 영화시간) {
		
		for(관리자_클래스 temp : 영화리스트) {
			if(temp != null && temp.get영화제목().equals(영화이름)) {
				System.out.println(1); return false;
			}
		}
		
		관리자_클래스 관리자 = new 관리자_클래스(영화이름, 영화시간, null, 0);
		영화리스트.add(관리자);
		영화저장();
		return true;

	}


	boolean 음식등록(String 먹거리종류,  int 가격, int 재고) {
		for(음식점_클래스 temp : 상품리스트) {
			if(temp.get먹거리종류().equals(먹거리종류)) {
				return false;
			}
		}
		음식점_클래스 음식 = new 음식점_클래스(먹거리종류, 가격, 재고);
		상품리스트.add(음식);
		음식점저장();
		return true;
	}

	static void  음식점저장 () {
		
			try {
				// 1. 파일출력 클래스 
				FileOutputStream outputStream = new FileOutputStream("D:/자바/음식점.txt");
				// 2. 파일에 작성할 내용 [ 리스트내 객체 1개씩 = 한줄씩 = 게시물 1개씩 = 객체 1개씩 ]
				for( 음식점_클래스 temp : 상품리스트 ) { // , : 필드구분용     \n : 객체구분용
					String 작성내용 = temp.get먹거리종류() +","+ temp.get가격()+","+
							temp.get재고()+"\n";
					// 3. 내용[문자열] -> 바이트열 변환  [ 외부통신(스트림) : 통신단위 : 바이트 ]
					outputStream.write( 작성내용.getBytes() ); // 4. 내보내기 [ write() ]
				}
			}catch( Exception e ) {  System.err.println(" 알림]] 파일저장 실패( 관리자에게문의 )"); }
		
	}
	static void  음식출력 () {
		try {
			FileInputStream inputStream = new FileInputStream("D:/자바/음식점.txt"); // 1. 파일입력클래스 
			byte[] bytes = new byte[1000]; // 2. 바이트배열 선언
			inputStream.read( bytes ); // 3. 모든 바이트 읽어와서 바이트에 저장 
			String file = new String( bytes ); // 4. 바이트 -> 문자열 변환 
			String[] files = file.split("\n"); // 5. 문자열 자르기 [ 한줄씩 [ \n ] -> 1개객체 ] 
			int i = 0; // 인덱스 용 
			for( String temp : files ) { // 배열내 문자열 하나씩 꺼내기 
				if( i+1 == files.length ) { break; }// * 마지막 인덱스[객체] 제외
				String[] field = temp.split(","); // 6. 문자열 자르기 [ 한줄 [,] -> 각필드 ] 
				음식점_클래스 음식점 = new 음식점_클래스( field[0], Integer.parseInt(field[1]), 
						Integer.parseInt(field[2]) );  // 7. 객체화
				상품리스트.add(음식점);// 8. 리스트 담기 
				i++; // 인덱스 증가 
			}
			음식점저장 ();
		}catch( Exception e ) { System.err.println(" 알림]] 파일로드  실패( 관리자에게문의 )"+e);  }
	}
	boolean 재고입고(String foodname, int 재고) {
		for(음식점_클래스 temp : 상품리스트) {
			if(temp.get먹거리종류().equals(foodname)) {
				temp.set재고(temp.get재고() + 재고);
				음식점저장();
				return true;
			}
		}
	return false;
	}
	boolean 재고출고(String foodname, int 재고) {
		for(음식점_클래스 temp : 상품리스트) {
			if(temp.get먹거리종류().equals(foodname)) {
				temp.set재고(temp.get재고() - 재고);
				음식점저장();
				return true;
			}
		}
	return false;
	}
	
	boolean 영화와영화시간수정 (String movieName, String movieTime, String movieName1, String movieTime1) {
		for(관리자_클래스 temp : 영화리스트) {
			if(temp.get영화제목().equals(movieName) && temp.get영화시간().equals(movieTime)) {
				temp.set영화제목(movieName1);
				temp.set영화시간(movieTime1);
				System.out.println(1);
				영화저장();
				return true;
			}
		}
		return false;
	}
	boolean 음식과음식가격수정 (String FoodName, String FoodName1, int FoodPrice, int FoodPrice1) {
		for(음식점_클래스 temp : 상품리스트) {
			if(temp.get먹거리종류().equals(FoodName) && temp.get가격() == FoodPrice) {
				temp.set먹거리종류(FoodName1);
				temp.set가격(FoodPrice1);
				음식점저장();
				return true;
			}
		}
		return false;
	}
	public static void 영화저장 () {
		
		try {
			// 1. 파일출력 클래스 
			FileOutputStream outputStream = new FileOutputStream("D:/자바/영화.txt");
			// 2. 파일에 작성할 내용 [ 리스트내 객체 1개씩 = 한줄씩 = 게시물 1개씩 = 객체 1개씩 ]
			for(  관리자_클래스 temp : 영화리스트 ) { // , : 필드구분용     \n : 객체구분용
				String 작성내용 = temp.get영화제목() +","+ temp.get영화시간()+"\n";
				// 3. 내용[문자열] -> 바이트열 변환  [ 외부통신(스트림) : 통신단위 : 바이트 ]
				outputStream.write( 작성내용.getBytes() ); // 4. 내보내기 [ write() ]
			}
		}catch( Exception e ) {  System.err.println(" 알림]] 파일저장 실패( 관리자에게문의 )"); }
	
}
	public static void 영화출력 () {
		try {
		FileInputStream inputStream = new FileInputStream("D:/자바/영화.txt"); // 1. 파일입력클래스 
		byte[] bytes = new byte[1000]; // 2. 바이트배열 선언
		inputStream.read( bytes ); // 3. 모든 바이트 읽어와서 바이트에 저장 
		String file = new String( bytes ); // 4. 바이트 -> 문자열 변환 
		String[] files = file.split("\n"); // 5. 문자열 자르기 [ 한줄씩 [ \n ] -> 1개객체 ] 
		int i = 0; // 인덱스 용 
		for( String temp : files ) { // 배열내 문자열 하나씩 꺼내기 
			if( i+1 == files.length ) { break; }// * 마지막 인덱스[객체] 제외
			String[] field = temp.split(","); // 6. 문자열 자르기 [ 한줄 [,] -> 각필드 ] 
			관리자_클래스 영화 = new 관리자_클래스( field[0], field[1]);  // 7. 객체화
			영화리스트.add(영화);// 8. 리스트 담기 
			
			i++; // 인덱스 증가 
		}
		
	}catch( Exception e ) { System.err.println(" 알림]] 파일로드  실패( 관리자에게문의 )"+e);  }
	}
	boolean 영화와시간삭제(String MovieName, String MovieTime) {
		for(관리자_클래스 temp : 영화리스트) {
			if(temp.get영화제목().equals(MovieName) && temp.get영화시간().equals(MovieTime)) {
				temp.set영화시간("null");
				temp.set영화제목("null");
				영화저장();
				return true;
			}
		}
		return false;
	}
	boolean 음식과가격삭제(String FoodName) {
		for(음식점_클래스 temp : 상품리스트) {
			if(temp.get먹거리종류().equals(FoodName) ) {
				temp.set먹거리종류(null);
				temp.set가격(0);
				temp.set재고(0);
				음식점저장();
				return true;
			}
		}
		return false;
	}
}