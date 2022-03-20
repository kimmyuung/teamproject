package Day01_설계;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;


public class 컨트롤러 {
	public static String[][] 주차타워 = new String[12][3];
	
	// 차량이 차면 "[o]" 비면 "[ ]"
	//입차 시간
	ZonedDateTime parkStart = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
	//출차 시간
	ZonedDateTime parkEnd = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
	public static ArrayList<매출> 총매출저장리스트 = new ArrayList<>();
	
	public 컨트롤러(ZonedDateTime parkStart) {
		super();
		this.parkStart = parkStart;
	}
	public 컨트롤러(ZonedDateTime parkStart, ZonedDateTime parkEnd) {
		super();
		this.parkStart = parkStart;
		this.parkEnd = parkEnd;
	}
	public static String[] 차량등록(String carNumber) { // 차량등록 s
		ZonedDateTime parkStart = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		for(int i = 0; i<주차타워.length; i++) {
			주차타워[i][0] = "[ ]";
		}
		for(int i = 0; i<12; i++) { // for s
		if(주차타워[i][0].equals("[ ]")) { // 주차공간 있으면
		주차타워[i][0] = "[o]";
		주차타워[i][1] = parkStart.toString();
		주차타워[i][2] = carNumber;  // 배열 안에 배열
		return 주차타워[i];
		} // 차량 채우고 입차시간 배열 중첩으로 넣기										
		} // for e
		return null;
		} // 차량등록 e
	public static void 차량삭제(String carNumber) { // 차량삭제 s
		for(int i=0; i<12; i++) { // for s
		if(주차타워[i].equals(carNumber)) { // 차량번호 일치하면
		주차타워[i] = "[ ]"; return;
		}
		} // for e
		} // 차량삭제 e
		
	// main에서 컨트롤러 객체 생성 수 리스트 사용해야함
	
	
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
