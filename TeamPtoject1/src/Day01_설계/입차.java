package Day01_����;

import java.util.Scanner;

public class ���� {
	
	public static void main(String[] args) {//cs
		
		Scanner scanner = new Scanner(System.in);
		
		int[] �����ڸ� = new int[12];
		
		//��ȣ �Է� �ޱ�/12�ڸ� 0~11
		for(int i =0; i<12; i++) {
			//i�� 0���� 11���� ���� �ݺ�
			System.out.println("0~11���� �Է�:");
			int ��ȣ = scanner.nextInt();
			
			boolean ���� = true; //����Ǵ� ���Ǻ���
					
			//����1. �����峻������ ���� ����
			if(��ȣ<0 || ��ȣ>11) {//0���� �۰ų� 12�̻���x
				System.out.println("�˸�)) �߸��Է��ϼ̽��ϴ�.[���Է�]");
				i--;
				���� = false;
			}//if end
			
			//����2 �ߺ�üũ
				//�迭�� ��� �ε��� ȣ��
			for(int j=0; j<12; j++) {
				if(��ȣ == �����ڸ�[j]) {
				//2.�ڸ� �ߺ�üũ
					System.out.println("�˸�)) �̹� ������ �ڸ��Դϴ�.[���Է�]");
					i--;
					���� = false; //����x
					}
				}
			//�����Է�(������ true)�̸� �迭�� ����
			if(����==true) �����ڸ�[i]=��ȣ;
			}
			System.out.print("\n����ڰ� ������ ������ �ڸ� ��ȣ:");
			
			//*����� �迭�� ��� �ε��� ���
			for(int temp : �����ڸ�) {
				System.out.println(temp +"\t");
			}
		
	
	}//me

}//cs
