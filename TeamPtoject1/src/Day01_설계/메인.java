package Day01_설계;

import java.util.Scanner;

public class 메인 { // c s
	public static String[] parklist = {"[    ]", "[    ]", 
			"[    ]", "[    ]"};

public static void main(String[] args) { // ms
	Scanner sc = new Scanner(System.in);
		try { // t s
	while(true) { // w s
		
		System.out.println("몇층짜리 주차장인지 입력해주세요.");
		int floor = sc.nextInt();
		
		System.out.println("[[1. 입차  2. 출차  3. 매출확인]]");
		int select = sc.nextInt();
		
		if(select == 1) {}
		
		else if(select == 2) {}
		
		else if(select == 3) {}
		
		else {}
		
		
		
		} // w1 e
		}catch(Exception e) {System.out.println("숫자를 입력하십시오");} // tc e
	} // m e
} // c e
