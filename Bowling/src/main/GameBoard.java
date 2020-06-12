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

public class GameBoard {
	
	private int[][] history;
	private boolean[][] historyWritten;
	private int[][] score;
	private int[][] bonus; // ���ʽ� ���� ��������� ����
	
	public GameBoard() {
		history = new int[Main.PLAYER_NUM][21];
		historyWritten = new boolean[Main.PLAYER_NUM][21];
		
		for (int i = 0; i < historyWritten.length; i++) {
			for (int j = 0; j < historyWritten[i].length; j++) {
				historyWritten[i][j] = false;
			}
		}
		
		score = new int[Main.PLAYER_NUM][10];
		bonus = new int[Main.PLAYER_NUM][10];
		
		for (int i = 0; i < bonus.length; i++) {
			for (int j = 0; j < bonus[i].length; j++) {
				score[i][j] = 0;
				bonus[i][j] = -1; // -1�� ��� ���� �������� ���� ���
			}
		}
	}
	
	public void writeHistory(int pinCount, int playerId, int frameNum, int chance) {
		history[playerId][2 * (frameNum - 1) + chance - 1] = pinCount;
		historyWritten[playerId][2 * (frameNum - 1) + chance - 1] = true;
	}
	
	public void writeFrameScore(int pinCount, int bonusCount, int playerId, int frameNum) {
		// ���� ������ ����		
		score[playerId][frameNum - 1] += pinCount;
		bonus[playerId][frameNum - 1] = bonusCount;
		
		// �� �����ӵ� �߿� ���ʽ� ���� �ʿ��� �κ� �ִ��� ã�Ƽ� ���
		for (int i = 1; i <= 2; i++) {
			if (frameNum - 1 - i >= 0) {
				if (bonus[playerId][frameNum - 1 - i] > 0) {
					score[playerId][frameNum - 1 - i] += pinCount;
					bonus[playerId][frameNum - 1 - i] -= 1;
				}
			}
		}
	}
	
	// Ư�� �÷��̾��� Ư�� �����ӱ����� ���� ����
	private int sumScoreTo(int playerId, int idx) {
		int sum = 0;
		
		for (int i = 0; i <= idx; i++) {
			sum += score[playerId][i];
		}
		
		return sum;
	}
	
	public void printWinner() {
		if (sumScoreTo(0, 9) > sumScoreTo(1, 9)) {
			System.out.println("�÷��̾� 1 Win!");
		} else if (sumScoreTo(0, 9) < sumScoreTo(1, 9)) {
			System.out.println("�÷��̾� 2 Win!");
		} else {
			System.out.println("Draw.");
		}
	}
	
	public void show() {
		System.out.println("=====================================================================");
		System.out.print("      ");
		for (int i = 1; i <= 10; i++) {
			System.out.printf("  %2d  ", i);
		}
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		for (int i = 0; i < Main.PLAYER_NUM; i++) {
			System.out.print("�÷��̾�" + (i+1));
			
			// �����߸� ������ ��
			for (int j = 0; j < 21; j++) {
				if (historyWritten[i][j]) { // ����� ���� ��
					if (j % 2 == 0) { // 1�� �õ�
						if (history[i][j] == 10) // ��Ʈ����ũ
							System.out.printf(" X ", history[i][j]);
						else
							System.out.printf(" %d ", history[i][j]);
					} else { // 2�� �õ�
						if (history[i][j] + history[i][j-1] == 10) // �����
							System.out.printf(" / ");
						else
							System.out.printf(" %d ", history[i][j]);
					}
				} else
					System.out.printf("   ");
			}
			System.out.println();
			System.out.print("      ");
			
			// ������ ȹ�� ����
			for (int j = 0; j < 10; j++) {
				if (bonus[i][j] == 0)
					System.out.printf("  %-3d ", sumScoreTo(i, j));
				else
					System.out.printf("      ");
			}
			System.out.println();
			
			// �÷��̾� ���м�
			if (i == 0) {
				System.out.println("---------------------------------------------------------------------");
			}
		}
		System.out.println("=====================================================================");
	}
}