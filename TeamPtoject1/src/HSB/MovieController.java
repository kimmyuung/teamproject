package HSB;

import java.util.ArrayList;

public class MovieController {

	static ArrayList<MovieTicket> movieTicket = new ArrayList<>();
	static String [] �¼� = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",
	};
	
	
	
	public void �¼����() {}
	
	public void Ƽ�Ϲ߱�() {}//Ƽ�Ϲ߱� end
	
	public void Ƽ�����() {}//Ƽ����� end
	
	public void ����Ƽ�����() {}//����Ƽ����� end
	
	public boolean ��ȭ����(String movieTitle) {
		for(MovieTicket temp : movieTicket) {
			if(temp.get��ȭ����().equals(movieTitle)) {
				return true;
			}
		}
		return false;
	}//��ȭ���� end
	
	public void �ð�() {}//�ð� end
	
	public void �¼�() {}//�¼� end
	
	public void ����() {}//���� end
	
	public void ������() {}//������ end
	
	
	
}
