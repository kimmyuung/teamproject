package Day01_설계;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class 조별과제_주차타워 {
	public static String[] parkSpace = {  "[ ]" , "[ ]" , "[ ]" , "[ ]" , 
			"[ ]" , "[ ]" , "[ ]" , "[ ]" ,
			"[ ]" , "[ ]" , "[ ]" , "[ ]" , };
// 차량이 차면 "[o]" 비면 "[ ]"
private String carNumber; // 차번호
//입차 시간
public ZonedDateTime parkStart = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
//출차 시간
public ZonedDateTime parkEnd = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

public String[] getParkSpace() {
return parkSpace;
}
public void setParkspace(String[] parkSpace) {
this.parkSpace = parkSpace;
}
public ZonedDateTime getParkStart() {
return parkStart;
}
public ZonedDateTime getParkEnd() {
return parkEnd;
}
public String getCarNumber() {
	return carNumber;
}
public void setCarNumber(String carNumber) {
	this.carNumber = carNumber;
}

}
