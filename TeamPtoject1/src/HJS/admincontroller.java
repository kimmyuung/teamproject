package HJS;

import java.time.LocalTime;
import java.util.ArrayList;



public class admincontroller {

	static ArrayList<admin> ��ȭ����Ʈ = new ArrayList<>();

	boolean ��ȭ���(String ��ȭ�̸�, String ��ȭ�ð�) {
		
		for(admin temp : ��ȭ����Ʈ) {
			if(temp != null && temp.get��ȭ����().equals(��ȭ�̸�)) {
				System.out.println(1); return false;
			}
		}
		
		admin ������ = new admin(��ȭ�̸�, ��ȭ�ð�, null, 0);
		��ȭ����Ʈ.add(������);
		return true;

	}


	void ���ĵ��() {
	}

	void ����Ȯ��() {
	}

}
