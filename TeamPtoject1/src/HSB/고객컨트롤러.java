package HSB;

import java.util.ArrayList;

public class ����Ʈ�ѷ� {

	��ȭƼ�� ��ȭƼ�� = new ��ȭƼ��();
	������_�޴� �����ڸ޴� = new ������_�޴�();
	static ArrayList<��ȭƼ��> movieTicket = new ArrayList<>();
	static String [] �¼� = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"
							};
	
	
	public void �¼����() {
	int i = 1;
		for(String temp: �¼�) {
			if(temp.equals("[ x ]")) {
				System.out.print("[x]");
				if(i%5==0) {
					System.out.println("");
				}		
			}
			
			if(temp.equals("[ ]")) {
				System.out.printf("["+i+"]",i);
				if(i%5==0) {
					System.out.println("");
				}		
			}
			i++;
		}
		return;
	}
	
	public boolean �¼�����(int ch1) {
		for(String temp: �¼�) {
			if(temp.equals("[ ]")) {
				�¼�[(ch1-1)]="[ x ]";
				
				return true;
			}	
			
		}
		return false;
	}
	
	public void Ƽ�Ϲ߱�() {}//Ƽ�Ϲ߱� end
	
	public void Ƽ�����() {}//Ƽ����� end
	
	public void ����Ƽ�����() {}//����Ƽ����� end
	
	public boolean ��ȭ����(String movieTitle) {
	 
			if(movieTitle.equals("admin")) {
				�����ڸ޴�.�޴�();
				return false;
			}
		
		return true;
	}//��ȭ���� end
	
	public void �ð�() {}//�ð� end
	
	public void �¼�() {}//�¼� end
	
	public void ����() {}//���� end
	
	public void ������() {}//������ end
	
	
	
}
