package Day01_����;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ��������_����Ÿ�� {
	public static String[] parkSpace = {  "[ ]" , "[ ]" , "[ ]" , "[ ]" , 
			"[ ]" , "[ ]" , "[ ]" , "[ ]" ,
			"[ ]" , "[ ]" , "[ ]" , "[ ]" , };
// ������ ���� "[o]" ��� "[ ]"
private String carNumber; // ����ȣ
//���� �ð�
public ZonedDateTime parkStart = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
//���� �ð�
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
