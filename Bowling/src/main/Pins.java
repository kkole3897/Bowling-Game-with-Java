/*
 * �ۼ��� : ������
 * ������ �ۼ��� : 2020-06-12
 * ���� : ���� ����
 *      2���� �÷��̾ 10�����ӵ��� �����ư��� ������ �����ϰ� ������ ����� �����ִ� ���α׷�
 *      �����߸��� �������� ������ ��޿� ���� �޶�����.
 * ����
 * 	- v0.1 : ����. �÷��̾� ���� �Ϸ�
 *  - v0.2 : ������ ��� ���, ������ ��� ��� ����, �Ѿ�߸� �� ���� ���
 *  - v0.3 : 10�����ӱ��� ���� ��� �� ������ ��� �Ϸ�
 *  - v0.4 : �÷��̾� ��޺��� �Ƿ� ���� ����, �������̽� ����
 */

package main;

public class Pins {
	
	private boolean[] pinState = new boolean[10]; // ���ִ� ���  true, ���������� ��� false
	
	public Pins() {
		for (int i = 0; i < 10; i++) {
			pinState[i] = true;
		}
	}
	
	public int getRemainNum() {
		int count = 0;
		
		for (boolean b : pinState) {
			if (b)
				count++;
		}
		
		return count;
	}
	
	public void drop(int n) {
		int idx = pinState.length - 1;
		
		while (n > 0 && idx >= 0) {
			if (pinState[idx]) {
				pinState[idx] = false;
				n--;
			}
			
			idx--;
		}
	}
	
	public void show() {
		int pinIdx = 0;
		for (int i = 0; i < 4; i++) {
			// �� ���� ���� ���� ó��
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			int startIdx = pinIdx;
			for (int j = startIdx; j < startIdx + 4 - i; j++) {
				if (pinState[pinIdx]) {
					System.out.print("O ");
				} else {
					System.out.print("X ");
				}
				pinIdx++;
			}
			System.out.println();
		}
	}
}
