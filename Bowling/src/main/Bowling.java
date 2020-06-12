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

public class Bowling {
	
	private Player[] players = new Player[Main.PLAYER_NUM];
	private int turn;
	private int frame;
	
	GameBoard gameBoard = new GameBoard();
	
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
				int level = Integer.parseInt(scanner.nextLine());
				
				if (level == 0) {
					System.out.println("���α׷��� �����մϴ�.");
					return;
				} else if (level > 3) {
					System.out.println("������ �߸��ƽ��ϴ�.");
					continue;
				}
				
				// �÷��̾� ����
				players[playerId - 1] = new Player(level);
				
				if (playerId == Main.PLAYER_NUM) {
					break;
				}
				
				playerId++;
			} catch (Exception e) {
				System.out.println("�߸��� �Է��Դϴ�.");
				scanner.nextLine();
			}
		} // �÷��̾� ���� �Ϸ�
		
		turn = 0;
		frame = 1;
		
		// ���� ����
		while (true) {
			// ������ ���
			gameBoard.show();
			
			// �÷��̾� �� Ȯ��
			System.out.println("�÷��̾�" + (turn+1) + " ����");
			Player curPlayer = players[turn];
			
			// ������ ���� ���
			Pins pins = new Pins();
			pins.show();
			int remainPinNum = pins.getRemainNum();
			
			if (frame == 10) {
				// 10�������� 1�� �õ�
				System.out.println("1�� �õ� ");
				System.out.print("Press Any Key...");
				scanner.nextLine();
				int droppedPinNum = curPlayer.throwBall(remainPinNum);
				remainPinNum -= droppedPinNum;
				pins.drop(droppedPinNum);
				
				// �����ǿ� ���
				gameBoard.writeHistory(droppedPinNum, turn, frame, 1);
				gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
				
				if (remainPinNum == 0) { // 1�� �õ� ��Ʈ����ũģ ���
					// ������ ���
					gameBoard.show();
					
					// �÷��̾� �� Ȯ��
					System.out.println("�÷��̾�" + (turn+1) + " ����");
					
					// ������ ���� ���
					pins = new Pins();
					pins.show();
					remainPinNum = pins.getRemainNum();
					
					// 10�������� 2�� �õ�
					System.out.println("2�� �õ� ");
					System.out.print("Press Any Key...");
					scanner.nextLine();
					droppedPinNum = curPlayer.throwBall(remainPinNum);
					remainPinNum -= droppedPinNum;
					pins.drop(droppedPinNum);
					
					// �����ǿ� ���
					gameBoard.writeHistory(droppedPinNum, turn, frame, 2);
					gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
					
					if (remainPinNum == 0) { // 2�� �õ� ��Ʈ����ũģ ���
						// ������ ���
						gameBoard.show();
						
						// �÷��̾� �� Ȯ��
						System.out.println("�÷��̾�" + (turn+1) + " ����");
						
						// ������ ���� ���
						pins = new Pins();
						pins.show();
						remainPinNum = pins.getRemainNum();
						
						// 10�������� 3�� �õ�
						System.out.println("3�� �õ� ");
						System.out.print("Press Any Key...");
						scanner.nextLine();
						droppedPinNum = curPlayer.throwBall(remainPinNum);
						remainPinNum -= droppedPinNum;
						pins.drop(droppedPinNum);
						
						// �����ǿ� ���
						gameBoard.writeHistory(droppedPinNum, turn, frame, 3);
						gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
					} else { // 2�� �õ� ��ũ����ũ ��ģ ���
						// ������ ���
						gameBoard.show();
						
						// �÷��̾� �� Ȯ��
						System.out.println("�÷��̾�" + (turn+1) + " ����");

						// ������ ���� ���
						pins.show();
						remainPinNum = pins.getRemainNum();
						
						// 10�������� 3�� �õ�
						System.out.println("3�� �õ� ");
						System.out.print("Press Any Key...");
						scanner.nextLine();
						droppedPinNum = curPlayer.throwBall(remainPinNum);
						remainPinNum -= droppedPinNum;
						pins.drop(droppedPinNum);
						
						// �����ǿ� ���
						gameBoard.writeHistory(droppedPinNum, turn, frame, 3);
						gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
					}
				} else { // 1�� �õ� ��Ʈ����ũ �� ģ ���
					// ������ ���
					gameBoard.show();
					
					// �÷��̾� �� Ȯ��
					System.out.println("�÷��̾�" + (turn+1) + " ����");

					// ������ ���� ���
					pins.show();
					remainPinNum = pins.getRemainNum();
					
					// 10�������� 2�� �õ�
					System.out.println("2�� �õ� ");
					System.out.print("Press Any Key...");
					scanner.nextLine();
					droppedPinNum = curPlayer.throwBall(remainPinNum);
					remainPinNum -= droppedPinNum;
					pins.drop(droppedPinNum);
					
					// �����ǿ� ���
					gameBoard.writeHistory(droppedPinNum, turn, frame, 2);
					gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
					
					if (remainPinNum == 0) { // 2�� �õ� ����� ó���� ���
						// ������ ���
						gameBoard.show();
						
						// �÷��̾� �� Ȯ��
						System.out.println("�÷��̾�" + (turn+1) + " ����");
						
						// ������ ���� ���
						pins = new Pins();
						pins.show();
						remainPinNum = pins.getRemainNum();
						
						// 10�������� 3�� �õ�
						System.out.println("3�� �õ� ");
						System.out.print("Press Any Key...");
						scanner.nextLine();
						droppedPinNum = curPlayer.throwBall(remainPinNum);
						remainPinNum -= droppedPinNum;
						pins.drop(droppedPinNum);
						
						// �����ǿ� ���
						gameBoard.writeHistory(droppedPinNum, turn, frame, 3);
						gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
					}
				}
			} else { // 10�������� �ƴҶ�
				// ������ ������: 1�� �õ�
				System.out.println("1�� �õ� ");
				System.out.print("Press Any Key...");
				scanner.nextLine();
				int droppedPinNum = curPlayer.throwBall(remainPinNum);
				remainPinNum -= droppedPinNum;
				pins.drop(droppedPinNum);
				
				// �����ǿ� ���
				gameBoard.writeHistory(droppedPinNum, turn, frame, 1);
				
				// ��Ʈ����ũ�� ���� ��
				if (remainPinNum == 0) {
					gameBoard.writeFrameScore(droppedPinNum, 2, turn, frame);
				} else { // ��Ʈ����ũ�� ġ�� ������ ��
					gameBoard.writeFrameScore(droppedPinNum, -1, turn, frame);
					// ������ ���
					gameBoard.show();
					System.out.println("�÷��̾�" + (turn+1) + " ����");
					// ������ ���� ���
					pins.show();
					// 2�� �õ�
					System.out.println("2���õ� ");
					System.out.print("Press Any Key...");
					scanner.nextLine();
					// ������
					droppedPinNum = curPlayer.throwBall(remainPinNum);
					remainPinNum -= droppedPinNum;
					gameBoard.writeHistory(droppedPinNum, turn, frame, 2);
					
					// ����� ����
					if (remainPinNum == 0) {
						gameBoard.writeFrameScore(droppedPinNum, 1, turn, frame);
					} else { // ����� ����
						gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
					}
				}
			}
			
			// �� �ѱ��
			if (turn == Main.PLAYER_NUM - 1) {
				turn = 0;
				frame++;
			}
			
			else
				turn++;
			
			// ���� ����
			if (frame > 10) {
				gameBoard.show();
				System.out.println("������ �����մϴ�.");
				break;
			}
		}
	}
}
