package 개인과제구상;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class 조별과제_매출 {
	//일별 매출 메소드
			public static void dayPay() throws IOException {
				//날짜 받기
				Scanner scanner = new Scanner( System.in);
				System.out.print(" 연도 :"); int year = scanner.nextInt();
				System.out.print(" 월 :");	int month = scanner.nextInt();
				
				//어레이리스트입력
				ArrayList<Integer> allDayPay = new ArrayList<Integer>();	//임시어레이배열
				allDayPay.add(1000); //테스트 매출 1일차
				allDayPay.add(5000); //테스트 매출 2일차
						
				//파일불러오기
					//파일얻어오기
				FileInputStream inputStream = new FileInputStream("D:/java/1.txt");
				byte[] bytes = new byte[1024];
				inputStream.read( bytes );
				String 파일내용 = new String( bytes );
				String[] 매출목록 = 파일내용.split("\n");
				
					//매출 파일에 저장하기
				int h=0;
				for( String temp : 매출목록 ) {
					 
					String r = (매출목록[h]) ;
					//int 매출 = Integer.parseInt(r);   //Bytes로 저장된 파일의 내용을 String으로 바꾸고 int로 전환할했으나 String으로도 산관없이 출력됨
					//allDayPay.add(매출);             //혹시모를 오류
					h++;
				}
				
				//매출 파일에 입력
				try {
					FileOutputStream outputStream = new FileOutputStream("D:/java/팀프1.txt");
					for(int i = 0 ; i<1000 ;i++) {
						if(allDayPay.get(i)!=null) {
							String 내보내기 = allDayPay.get(i)+"\n"; 
							outputStream.write( 내보내기.getBytes() );
						}
					}
					
				}catch( Exception e ) { // 예외[오류] 처리[잡기] : Exception 클래스
				}
				
				
				
				//날짜대입
				Calendar calendar = Calendar.getInstance();
				calendar.set( year , month-1 , 1 ); // 사용자 설정 달력  
				
				
				
				//달력출력
				int sweek = calendar.get( Calendar.DAY_OF_WEEK ); 
				int eday = calendar.getActualMaximum( Calendar.DAY_OF_MONTH );
				System.out.println("\n\n********************** "+year+"년" + month+"월 ******************");
				System.out.println("일\t월\t화\t수\t목\t금\t토");
				for( int i = 1 ; i < sweek ; i++ ) { // 3월1일 = 화 = 3 
					System.out.print("\t"); // 공백출력
				}
				for( int i = 0 ; i<eday ; i++ ) {
					if(allDayPay.get(i)!= null) {
						Integer a = allDayPay.get(i);
						if(a!= null) {
							System.out.print(i+")"+a+"원\t");  // i = 일수 출력
						}
						
					}
					else {
						System.out.print(i+")\t");
					}
					
					if( sweek % 7 == 0 ) System.out.println(); // 토요일마다 줄바꿈처리 [ 토요일=7 ] 요일이 7배수마다
					sweek++;  // 하루씩 요일 증가 
				}
				
			}
}
