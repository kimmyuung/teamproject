package dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test11 {
	
	public static void main(String[] args) {
		
LocalDateTime curDate = LocalDateTime.now();
		
		String reseve_time =curDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(reseve_time);
		int num_reseve_time = Integer.parseInt(reseve_time);
		System.out.println(num_reseve_time+5);
	}
}
