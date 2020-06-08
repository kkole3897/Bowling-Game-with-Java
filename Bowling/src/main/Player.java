/*
 * �ۼ��� : ������
 * ������ �ۼ��� : 2020-06-08
 * ���� : ���� ����
 *      2���� �÷��̾ 10�����ӵ��� �����ư��� ������ �����ϰ� ������ ����� �����ִ� ���α׷�
 *      �����߸��� �������� ������ ��޿� ���� �޶�����.
 * ����
 * 	- v0.1 : ����. �÷��̾� ���� �Ϸ�.
 */

package main;

public class Player {
	static final int BEGINNER = 1;
	static final int INTERMEDIATE = 2;
	static final int ADVANCED = 3;
	
	private int level;
	
	public Player(int level) {
		this.level = level;
	}
	
	public String getLevel() {
		String strLevel = null;
		
		if (level == BEGINNER) {
			strLevel = "�ʱ�";
		} else if (level == INTERMEDIATE) {
			strLevel = "�߱�";
		} else if (level == ADVANCED) {
			strLevel = "���";
		}
		
		return strLevel;
	}
}
