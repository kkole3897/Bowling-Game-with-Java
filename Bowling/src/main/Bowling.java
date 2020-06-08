/*
 * �ۼ��� : ������
 * ������ �ۼ��� : 2020-06-08
 * ���� : ���� ����
 *      2���� �÷��̾ 10�����ӵ��� �����ư��� ������ �����ϰ� ������ ����� �����ִ� ���α׷�
 *      �����߸��� �������� ������ ��޿� ���� �޶�����.
 * ����
 * 	- v0.1 : ����. �÷��̾� ���� �Ϸ�
 */

package main;

import java.util.*;

public class Bowling {
	
	private Player[] players = new Player[2];
	
	public Bowling() {
		System.out.println("���� ������ �����մϴ�.");
		
		// �÷��̾� ����
		Scanner scanner = new Scanner(System.in);
		
		int playerId = 1;
		while (true) {
			System.out.println("�÷��̾�" + playerId + "�� ����� �����ּ���.");
			System.out.println("0.����  | 1.�ʱ�  | 2.�߱�  | 3.���");
			
			try {
				System.out.print(">> ");
				int level = scanner.nextInt();
				
				if (level == 0) {
					System.out.println("���α׷��� �����մϴ�.");
					return;
				} else if (level > 3) {
					System.out.println("������ �߸��ƽ��ϴ�.");
					continue;
				}
				
				// �÷��̾� ����
				players[playerId - 1] = new Player(level);
				
				if (playerId == 2) {
					break;
				}
				
				playerId++;
			} catch (Exception e) {
				System.out.println("�߸��� �Է��Դϴ�.");
				scanner.nextLine();
			}
		} // �÷��̾� ����
		
		// ���� Ȯ��
		for (int i = 0; i < 2; i++) {
			System.out.println("�÷��̾�" + (i+1) + " " + players[i].getLevel());
		}
		
		// ���� ����
		
	}
}
