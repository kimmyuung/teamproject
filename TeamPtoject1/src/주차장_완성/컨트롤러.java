package 주차장_완성;

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
import java.util.Random;


import javax.swing.text.DateFormatter;





public class 컨트롤러 extends 메인{
	public static String[][] 주차타워 = new String[12][3];
	public static ArrayList<매출> 총매출저장리스트 = new ArrayList<>();
	
	
	public String[] 차량등록(String carNumber) { // 차량등록 s
		Date date = new Date();
		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
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
	
	public String 차량삭제(String carNumber) { // 차량삭제 s
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
	
	public int 주차계산 (int 금액) {
		Date date = new Date();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");	
		String 출차 = now.format(formatter);
		String[] 출차times = 출차.split(":");
		for(int i = 0 ; i < 주차타워.length; i++) {
			if(주차타워[i][1] != null) {
		String[] 주차times = 주차타워[i][1].split(":");
		int 주차시 = Integer.parseInt(주차times[0]);
		int 주차분 = Integer.parseInt(주차times[1]);
		int 출차시 = Integer.parseInt(출차times[0]);
		int 출차분 = Integer.parseInt(출차times[1]);
		int 시간 = 출차시 - 주차시 ; // '시'만 들어있음.
		int 분 = 출차분 - 주차분 ; // '분'만 들어있음
		int 총주차시간 = (시간 * 60) + 분;	// 단위 : 분
		int 정산금 = (총주차시간/10)*1000;	// 30분은 무료라서 총주차시간에서 30분 제외, 10분당이라 10 나누기, 1000원이라 1000 곱하기
		
		if (총주차시간 < 30) {정산금 = 0; System.out.println("계산하실 필요없습니다."); 주차타워[i][1] = null;}
		else if (시간 > 24) {정산금 = 50000; System.out.println("계산하실 금액은 5만원입니다."); 주차타워[i][1] = null;}
		else if (금액 < 정산금) {System.out.println("금액이 부족합니다 " + (정산금-금액) + "원 더 투입해주세요");}
		else if (금액 >= 정산금) {System.out.println("결제되었습니다. " + (금액-정산금) + "원을 반환합니다."); 주차타워[i][1] = null;}
		return 정산금;	}
		}
	return 0;
	}
	
		// 연월일을 자체적으로 찍은 뒤 인수로 받은 정산금과 같이 리스트에 저장하는 메서드
		public void 정산금누적(int 정산금) {
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
		public ArrayList<매출> 매출출력(int 연도, int 월, int 정렬기준) {
			
			ArrayList<매출> 일일매출 = new ArrayList<>();
			
			String 찾을연도 = 연도+"년";	
			String 찾을달 = 월+"월";	
			
			// 1. 모든 날짜의 매출금액이 있는 총매출저장리스트에서 입력받은 연, 월의 매출만 쭉 빼와서 일일매출 리스트에 금액과 날짜 저장 
			for(매출 tmp : 총매출저장리스트) {	
				if(tmp.get연도().contains(찾을연도) && tmp.get월().contains(찾을달)) {	
					매출 임시객체 = new 매출(tmp.get매출금액(), tmp.get날짜());
					일일매출.add(임시객체);
				}
			}
			
			// 2. 윗쪽 반복문에서 만든 일일매출 리스트에서 같은 날짜는 한곳에 더한뒤, 나머지는 0원 처리함.
			for(int i=0; i<일일매출.size(); i++) {
				String tmp;
				int 임시매출누적=0;
				tmp = 일일매출.get(i).get날짜();
				for(int j=i; j<일일매출.size(); j++) {
					if(tmp.equals(일일매출.get(j).get날짜())) {
						임시매출누적 += 일일매출.get(j).get매출금액();
						일일매출.get(j).set매출금액(0);
					}
				}
				일일매출.get(i).set매출금액(임시매출누적);
			}
			
			// 3. 0원 처리된 인덱스들 삭제하는 반복문
			for(int i=0; i<일일매출.size(); i++){	
				if(일일매출.get(i).get매출금액()==0) {	// 일일매출의 가장 끝 인덱스부터 0원인지 확인
					일일매출.remove(i);
					i-=1;	// 현재 인덱스 뒤의 값이 자동으로 떙겨지기 때문에 떙겨진 값이 0인지 다시한번 확인해야함. 같은인덱스 다시한번 검사하기 위해 i= -1
				}
			}
			// 4-1 사용자가 일자 기준으로 정렬 선택시 일자 오름차순 정렬
			if(정렬기준==1) {	
				매출 순서변경용임시배열 = new 매출();
				int indexCount1=0;
				for(매출 tmp : 일일매출) {
					int indexCount2=0;
					for (매출 tmp2 : 일일매출) {
						if(Integer.parseInt(tmp.get날짜().replace("일", "")) < Integer.parseInt(tmp2.get날짜().replace("일", ""))) {
							순서변경용임시배열 = 일일매출.get(indexCount1);
							일일매출.set(indexCount1, 일일매출.get(indexCount2));
							일일매출.set(indexCount2, 순서변경용임시배열);
						}
						indexCount2++;
					}
					indexCount1++;
				}
			}
			else {
				매출 순서변경용임시배열 = new 매출();
				int indexCount1=0;
				for(매출 tmp : 일일매출) {
					int indexCount2=0;
					for (매출 tmp2 : 일일매출) {
						if(tmp.get매출금액()<tmp2.get매출금액()) {
							순서변경용임시배열 = 일일매출.get(indexCount1);
							일일매출.set(indexCount1, 일일매출.get(indexCount2));
							일일매출.set(indexCount2, 순서변경용임시배열);
						}
						indexCount2++;
					}
					indexCount1++;
				}
			}
			return 일일매출;
		}	// 매출출력 END
		
		// txt파일에서 java로 읽어들이는 메서드
		public void 매출파일로딩() {
			try {	// FileInputStream 때문에 일반예외 발생
				FileInputStream fileInputStream = new FileInputStream("D:/java/주차장매출.txt");
				byte[] 임시바이트배열 = new byte[65536];	// 넉넉하게 32KB짜리 임시저장용 바이트형 배열 선언
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
		public void 매출파일저장() {
			try {
				FileOutputStream fileOutputStream = new FileOutputStream("D:/java/주차장매출.txt");	// 1. 파일 출력 객체 생성
				for(매출 tmp : 총매출저장리스트) {
					String 저장파일에들어갈문자열 = tmp.get매출금액() + "," + tmp.get날짜() + "," + tmp.get월() + "," + tmp.get연도() + "\n";
					fileOutputStream.write(저장파일에들어갈문자열.getBytes());
				}
			}catch(Exception e) { }
			
		}	// 매출파일저장 END
		
		public void 테스트용일괄출력() {
			for(매출 tmp : 총매출저장리스트)
				System.out.println(tmp.get매출금액()+"원"+tmp.get날짜()+tmp.get월()+tmp.get연도());
		}
		
		public void 노가다귀찮다() {
			Random random = new Random();
			int 매출금액 = random.nextInt(4001)+1000;	// 1000~5000
			float 매출금액2 = Math.round(매출금액/100.0)*100.0f;
			int year = random.nextInt(3)+20;			// 20~22
			int month = random.nextInt(12)+1;		// 1~12
			int day = 0;
			
			switch(month) {
			case 2: day = random.nextInt(28)+1;	break;	// 1~28
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: day = random.nextInt(31)+1; break;	//1~31;
			case 4:
			case 6:
			case 9:
			case 11: day = random.nextInt(30)+1; break;	//1~30;
			}
			
			String year2 = year+"년";
			String month2 = month+"월";
			String day2 = day+"일";
			
			매출 매크로생성매출 = new 매출((int)매출금액2, day2, month2, year2);
			총매출저장리스트.add(매크로생성매출);
			매출파일저장();
		}
	
}	// class END
