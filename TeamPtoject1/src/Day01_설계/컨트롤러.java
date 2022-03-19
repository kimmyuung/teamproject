package Day01_설계;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class 컨트롤러 {
 
	
	
	
	매출 매출메서드 = new 매출();	// 객체선언하고 리스트선언 같이해도 되는건가?? 햇갈리네
	public static ArrayList<매출> 총매출저장리스트 = new ArrayList<>();
	
	// txt파일에서 자바로 읽어들이는 메서드
	public void 매출파일로딩() {
		try {	// FileInputStream 때문에 일반예외 발생
			FileInputStream fileInputStream = new FileInputStream("D:/java/주차장매출.txt");
			byte[] 임시바이트배열 = new byte[4096];	// 넉넉하게 4KB짜리 임시저장용 바이트형 배열 선언
			fileInputStream.read(임시바이트배열);	// 주차장매출.txt 파일 읽어들인 다음 바이트형 배열에 저장
			String 파일내용 = new String(임시바이트배열);	// 바이트배열-> 문자열로 이동
			
			String[] 연매출 = 파일내용.split("\n");	
			
			for(String tmp : 연매출) {
				String[] 월매출 = tmp.split("/t");
				for(String tmp2 : 월매출) {
					// 파일로딩부 아직 제작중. 저장을 어캐할지 확정하고나서 완성 ㄱㄱ
					// 햇갈리면 Day10_07 키오스크, 롯데리아 참고
					
//					매출 매출 = new 매출(field[0], field[1], field[2], field[3]);
//					총매출저장리스트.add(월매출);	// 총매출저장리스트 리스트에 저장.
				}
			}
			
		} catch (Exception e) {System.out.println("매출파일로딩 메서드 예외 발생");}
	}	// 매출파일로딩 메서드 END
	
	
	public void 매출파일저장() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/주차장매출.txt");	// 1. 파일 출력 객체 생성
			for(매출 tmp : 총매출저장리스트) {
				String 저장파일에들어갈문자열 = tmp.get연도() + "," + tmp.get월() + "," + tmp.get날짜() + "," + tmp.get매출금액() + "\n";
				fileOutputStream.write(저장파일에들어갈문자열.getBytes());
			}
		}catch(Exception e) {System.out.println("매출파일저장 메서드 예외 발생");}
	}	// 매출파일저장 END
}	// class END
