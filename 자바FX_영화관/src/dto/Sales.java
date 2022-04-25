package dto;

public class Sales {
private int 매출;
private String 날짜;
public Sales() {}
public Sales(int 매출, String 날짜) {
	super();
	this.매출 = 매출;
	this.날짜 = 날짜;
}

public int get매출() {
	return 매출;
}
public void set매출(int 매출) {
	this.매출 = 매출;
}
public String get날짜() {
	return 날짜;
}
public void set날짜(String 날짜) {
	this.날짜 = 날짜;
}

}
