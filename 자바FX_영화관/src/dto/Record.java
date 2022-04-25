package dto;

public class Record {
private String 상영영화;
private String 상영시간;
private String 관이름;

public Record() {}

public Record(String 상영영화, String 상영시간, String 관이름) {
	super();
	this.상영영화 = 상영영화;
	this.상영시간 = 상영시간;
	this.관이름 = 관이름;
}

public String get상영영화() {
	return 상영영화;
}
public void set상영영화(String 상영영화) {
	this.상영영화 = 상영영화;
}
public String get상영시간() {
	return 상영시간;
}
public void set상영시간(String 상영시간) {
	this.상영시간 = 상영시간;
}
public String get관이름() {
	return 관이름;
}
public void set관이름(String 관이름) {
	this.관이름 = 관이름;
}

}
