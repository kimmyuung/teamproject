package ��ġ��;

import java.time.LocalTime;
import java.util.ArrayList;



public class ��������Ʈ�ѷ� {

	static ArrayList<������_Ŭ����> ��ȭ����Ʈ = new ArrayList<>();

	boolean ��ȭ���(String ��ȭ�̸�, String ��ȭ�ð�) {
		
		for(������_Ŭ���� temp : ��ȭ����Ʈ) {
			if(temp != null && temp.get��ȭ����().equals(��ȭ�̸�)) {
				System.out.println(1); return false;
			}
		}
		
		������_Ŭ���� ������ = new ������_Ŭ����(��ȭ�̸�, ��ȭ�ð�, null, 0);
		��ȭ����Ʈ.add(������);
		return true;

	}


	void ���ĵ��() {
	}

	void ����Ȯ��() {
	}

}