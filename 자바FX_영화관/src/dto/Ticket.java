package dto;

public class Ticket {
private int ����;
private String ��ȭ����;
private String �¼���ȣ;
private int �ο���;
private String ���̸�;
private String ��¥;
private String �¼�;
public Ticket() {}
public Ticket(int ����, String ��ȭ����, String �¼���ȣ, int �ο���, String ���̸�, String ��¥, String �¼�) {
	super();
	this.���� = ����;
	this.��ȭ���� = ��ȭ����;
	this.�¼���ȣ = �¼���ȣ;
	this.�ο��� = �ο���;
	this.���̸� = ���̸�;
	this.��¥ = ��¥;
	this.�¼� = �¼�;
}
public int get����() {
	return ����;
}
public void set����(int ����) {
	this.���� = ����;
}
public String get��ȭ����() {
	return ��ȭ����;
}
public void set��ȭ����(String ��ȭ����) {
	this.��ȭ���� = ��ȭ����;
}
public String get�¼���ȣ() {
	return �¼���ȣ;
}
public void set�¼���ȣ(String �¼���ȣ) {
	this.�¼���ȣ = �¼���ȣ;
}
public int get�ο���() {
	return �ο���;
}
public void set�ο���(int �ο���) {
	this.�ο��� = �ο���;
}
public String get���̸�() {
	return ���̸�;
}
public void set���̸�(String ���̸�) {
	this.���̸� = ���̸�;
}
public String get��¥() {
	return ��¥;
}
public void set��¥(String ��¥) {
	this.��¥ = ��¥;
}
public String get�¼�() {
	return �¼�;
}
public void set�¼�(String �¼�) {
	this.�¼� = �¼�;
}
}
