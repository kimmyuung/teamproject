package ��Ʈ�ѷ���;

public class ���� {
	// 1. �ʵ�
		private int ����ݾ�;
		private String ��¥;
		private String ��;
		private String ����;

		// 2. ������
		
		public ����() { }		// ���������
		
		// ��Ʈ�ѷ�.����, �ε� �޼��尡 ����� Ǯ ������
		public ����(int ����ݾ�, String ��¥, String ��,String ����) {	
			this.����ݾ� = ����ݾ�;
			this.��¥ = ��¥;
			this.�� = ��;
			this.���� = ����;
		}

		// ��Ʈ�ѷ�.������� �޼��忡�� ���ϰ� ��üȭ������ �� ������
		public ����(int ����ݾ�, String ��¥) {
			this.����ݾ� = ����ݾ�;
			this.��¥ = ��¥;
		}

		// 3. �޼���
		public int get����ݾ�() {
			return ����ݾ�;
		}

		public void set����ݾ�(int ����ݾ�) {
			this.����ݾ� = ����ݾ�;
		}

		public String get����() {
			return ����;
		}

		public void set����(String ����) {
			this.���� = ����;
		}

		public String get��() {
			return ��;
		}

		public void set��(String ��) {
			this.�� = ��;
		}
		
		public String get��¥() {
			return ��¥;
		}

		public void set��¥(String ��¥) {
			this.��¥ = ��¥;
		}

}
