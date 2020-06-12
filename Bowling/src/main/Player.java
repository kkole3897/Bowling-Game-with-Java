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

import java.util.*;

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
	
	public int throwBall(int remainPinNum) {
		Random random = new Random();
		
		int droppedPins = 0;
		
		if (level == BEGINNER) {
			droppedPins = (int)(random.nextGaussian() * 5 + 5);
		} else if (level == INTERMEDIATE) {
			droppedPins = (int)(random.nextGaussian() * 3 + 7);
		} else if (level == ADVANCED) {
			droppedPins = (int)(random.nextGaussian() * 2 + 9);
		}
		
		droppedPins = (droppedPins > remainPinNum) ? remainPinNum : droppedPins;
		droppedPins = (droppedPins < 0) ? 0: droppedPins;
		
		return droppedPins;
	}
}
