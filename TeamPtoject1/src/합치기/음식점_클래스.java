package 합치기;

public class 음식점_클래스 {
String 먹거리종류;
int 가격;
int 재고;
public 음식점_클래스(String 먹거리종류, int 가격, int 재고) {
	super();
	this.먹거리종류 = 먹거리종류;
	this.가격 = 가격;
	this.재고 = 재고;
}

음식점_클래스() {}

public String get먹거리종류() {
	return 먹거리종류;
}

public void set먹거리종류(String 먹거리종류) {
	this.먹거리종류 = 먹거리종류;
}

public int get가격() {
	return 가격;
}

public void set가격(int 가격) {
	this.가격 = 가격;
}

public int get재고() {
	return 재고;
}

public void set재고(int 재고) {
	this.재고 = 재고;
}

}
