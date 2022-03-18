/* 
 * 	1. 파일 저장
 * 		경로 : D:\java\주차장매출.txt
 * 		구분 단위
 * 			1. \n : 연
 * 			2. \t : 월
 * 			3. ,  : 일
 * 			
 * 		필드, 생성자는 남기고 메서드부는 컨트롤러로 옮기기.
 * 		day10_07_키오스크, 롯데리아 참고.
 * 
 * 		클래스 : car, 메인, 컨트롤러, 매출.
 * 
 */

package Day01_설계;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Stack;

public class 매출 {
	
	// 1. 필드
	private int 매출금액;
	private int 날짜;
	private String 연도;
	private String 월;

	// 2. 생성자
	public 매출() { }
	
	public 매출(int 매출금액, int 날짜, String 연도, String 월) {
		this.매출금액 = 매출금액;
		this.날짜 = 날짜;
		this.연도 = 연도;
		this.월 = 월;
	}


	// 3. 메서드
	public int get매출금액() {
		return 매출금액;
	}

	public void set매출금액(int 매출금액) {
		this.매출금액 = 매출금액;
	}

	public String get연도() {
		return 연도;
	}

	public void set연도(String 연도) {
		this.연도 = 연도;
	}

	public String get월() {
		return 월;
	}

	public void set월(String 월) {
		this.월 = 월;
	}
	
	
	public void 매출파일저장(int 날짜, int 금액) {
		try {	// FileInputStream 때문에 일반예외 발생
			
			
			
			
			
			
			FileOutputStream fileOutputStream = new FileOutputStream("D:/java/주차장매출.txt");
		} catch(Exception e) {}
	}
	
	
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
			}
		}
		
		
		} catch (Exception e) {	}
	}	// 파일로딩 메서드 END 
	
	public void 누적매출호출() {}
	

	
}