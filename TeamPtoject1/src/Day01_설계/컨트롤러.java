package Day01_설계;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import javax.swing.text.DateFormatter;


public class 컨트롤러 extends 메인{
	public static String[][] 주차타워 = new String[12][3];
	public static ArrayList<매출> 총매출저장리스트 = new ArrayList<>();
	
	
	public static String[] 차량등록(String carNumber) { // 차량등록 s
		Date date = new Date();
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh : mm");
		String 주차시작 = now.format(formatter);
		for(int i = 0; i<주차타워.length; i++) {
			if(주차타워[i][0] == null)  주차타워[i][0] = "[ ]";
		}
		for(int i = 0; i<주차타워.length; i++) { // for s
		if(주차타워[i][0].equals("[ ]")) { // 주차공간 있으면
		주차타워[i][0] = "[o]";
		주차타워[i][1] =  주차시작;
		주차타워[i][2] = carNumber;  
		return 주차타워[i];
		} // 차량 채우고 입차시간 배열 중첩으로 넣기										
		} // for e
		return null;
		} // 차량등록 e
	
	public static String 차량삭제(String carNumber) { // 차량삭제 s
		for(int i=0; i<주차타워.length; i++) { // for s
		if(주차타워[i][0].equals("[o]") && 주차타워[i][2].equals(carNumber)) 
			{ // 차량번호 일치하면
		주차타워[i][0] = "[ ]";
		주차타워[i][2] = null;
			}
			} // for e // 주차장 칸 비우기 끝
		// 계산
		return null;
				} // 차량삭제 e
	
	public static int 주차계산 (int 금액) {
		Date date = new Date();
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh : mm");	
		String 출차 = now.format(formatter);
		String[] 출차times = 출차.split("");
		for(int i = 0 ; i < 주차타워.length; i++) {
			if(주차타워[i][1] != null) {
		String[] 주차times = 주차타워[i][1].split("");
		int 주차시간 = Integer.parseInt(주차타워[i][1]);
		int 출차시간 = Integer.parseInt(출차);
		int 시간 = 출차시간 / 100 - 주차시간 / 100; // int형으로 변경시 hhmm이므로 시간의 차이
		int 분 = 출차시간 % 100 - 주차시간 % 100; // 분의 차이 int형으로 변경시 hhmm이므로 분의 차이
		int 총주차시간 = (시간 * 60) + 분;
		int 계산비율 = 1000;
		int 정산금 = 총주차시간 / (10 * 계산비율);
		if (총주차시간 < 30) {정산금 = 0; System.out.println("계산하실 필요없습니다."); 주차타워[i][1] = null;}
		else if (시간 > 24) {정산금 = 50000; System.out.println("계산하실 금액은 5만원입니다."); 주차타워[i][1] = null;}
		else if (금액 < 정산금) {System.out.println("금액이 부족합니다 " + (정산금-금액) + "원 더 투입해주세요");}
		else if (금액 >= 정산금) {System.out.println("결제되었습니다. " + (금액-정산금) + "원을 반환합니다."); 주차타워[i][1] = null;}
		return 정산금;	}
		}
	return 0;
	}
	
	
	
	
	
	// 연월일을 자체적으로 찍은 뒤 인수로 받은 정산금과 같이 리스트에 저장하는 메서드
	public static void 정산금누적(int 정산금) {
		int 매출금액 = 정산금;
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yy년");
		String 연도 = dateformat.format(date);
		dateformat = new SimpleDateFormat("M월");	// 03월 : 3월, 12월 : 12월
		String 월 = dateformat.format(date);
		dateformat = new SimpleDateFormat("d일");
		String 날짜 = dateformat.format(date);
		매출 정산금누적 = new 매출(매출금액, 날짜, 월, 연도);
		총매출저장리스트.add(정산금누적);
		매출파일저장();
	}
	
	// 콘솔에서 입력받은 연도와 월을 바탕으로 일일 매출내역을 ArrayList로 리턴
	public static ArrayList<매출> 매출검색출력(int 연도, int 월) {	
		ArrayList<매출> 일일매출 = new ArrayList<>();
		
		String 찾을연도 = 연도+"년";	
		String 찾을달 = 월+"월";	
		
		for(매출 tmp : 총매출저장리스트) {	
			if(총매출저장리스트.contains(찾을연도) && 총매출저장리스트.contains(찾을달)) {	
				매출 임시객체 = new 매출(tmp.get매출금액(), tmp.get날짜());
				일일매출.add(임시객체);
			}
		}
		return 일일매출;
	}
	
	// txt파일에서 java로 읽어들이는 메서드
	public static void 매출파일로딩() {
		try {	// FileInputStream 때문에 일반예외 발생
			FileInputStream fileInputStream = new FileInputStream("D:/java/주차장매출.txt");
			byte[] 임시바이트배열 = new byte[4096];	// 넉넉하게 4KB짜리 임시저장용 바이트형 배열 선언
			fileInputStream.read(임시바이트배열);	// 주차장매출.txt 파일 읽어들인 다음 바이트형 배열에 저장
			String 파일내용 = new String(임시바이트배열);	// 바이트배열-> 문자열로 이동
			
			String[] 파일내용배열 = 파일내용.split("\n");	
			
			for(String tmp : 파일내용배열) {
				String[] 임시배열 = tmp.split(",");
					매출 매출 = new 매출(Integer.parseInt(임시배열[0]), 임시배열[1], 임시배열[2], 임시배열[3]);
					총매출저장리스트.add(매출);	// 총매출저장리스트 리스트에 저장.
			}
		} catch (Exception e) { }
	}	// 매출파일로딩 메서드 END
	
	// java에서 txt파일로 내보내는 메서드
	public static void 매출파일저장() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/주차장매출.txt");	// 1. 파일 출력 객체 생성
			for(매출 tmp : 총매출저장리스트) {
				String 저장파일에들어갈문자열 = tmp.get매출금액() + "," + tmp.get날짜() + "," + tmp.get월() + "," + tmp.get연도() + "\n";
				fileOutputStream.write(저장파일에들어갈문자열.getBytes());
			}
		}catch(Exception e) {System.out.println("매출파일저장 메서드 예외 발생");}
	}	// 매출파일저장 END
	
	public void 테스트용일괄출력() {
		for(매출 tmp : 총매출저장리스트)
			System.out.println(tmp.get매출금액()+"원"+tmp.get날짜()+tmp.get월()+tmp.get연도());
	}
	
}	// class END
