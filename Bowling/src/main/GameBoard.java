/*
 * 작성자 : 김진관
 * 마지막 작성일 : 2020-06-12
 * 개요 : 볼링 게임
 *      2명의 플레이어가 10프레임동안 번갈아가며 게임을 진행하고 과정과 결과를 보여주는 프로그램
 *      쓰러뜨리는 볼링핀의 개수는 등급에 따라 달라진다.
 * 버전
 * 	- v0.1 : 시작. 플레이어 설정 완료
 *  - v0.2 : 점수판 출력 방식, 볼링핀 출력 양식 설정, 넘어뜨린 핀 개수 기록
 *  - v0.3 : 10프레임까지 점수 계산 및 점수판 출력 완료
 *  - v0.4 : 플레이어 등급별로 실력 차등 구현, 인터페이스 개선
 */

package main;

public class GameBoard {
	
	private int[][] history;
	private boolean[][] historyWritten;
	private int[][] score;
	private int[][] bonus; // 보너스 점수 더해줘야할 개수
	
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
				bonus[i][j] = -1; // -1일 경우 아직 진행하지 않은 경우
			}
		}
	}
	
	public void writeHistory(int pinCount, int playerId, int frameNum, int chance) {
		history[playerId][2 * (frameNum - 1) + chance - 1] = pinCount;
		historyWritten[playerId][2 * (frameNum - 1) + chance - 1] = true;
	}
	
	public void writeFrameScore(int pinCount, int bonusCount, int playerId, int frameNum) {
		// 현재 프레임 설정		
		score[playerId][frameNum - 1] += pinCount;
		bonus[playerId][frameNum - 1] = bonusCount;
		
		// 전 프레임들 중에 보너스 점수 필요한 부분 있는지 찾아서 계산
		for (int i = 1; i <= 2; i++) {
			if (frameNum - 1 - i >= 0) {
				if (bonus[playerId][frameNum - 1 - i] > 0) {
					score[playerId][frameNum - 1 - i] += pinCount;
					bonus[playerId][frameNum - 1 - i] -= 1;
				}
			}
		}
	}
	
	// 특정 플레이어의 특정 프레임까지의 종수 총합
	private int sumScoreTo(int playerId, int idx) {
		int sum = 0;
		
		for (int i = 0; i <= idx; i++) {
			sum += score[playerId][i];
		}
		
		return sum;
	}
	
	public void printWinner() {
		if (sumScoreTo(0, 9) > sumScoreTo(1, 9)) {
			System.out.println("플레이어 1 Win!");
		} else if (sumScoreTo(0, 9) < sumScoreTo(1, 9)) {
			System.out.println("플레이어 2 Win!");
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
			System.out.print("플레이어" + (i+1));
			
			// 쓰러뜨린 볼링핀 수
			for (int j = 0; j < 21; j++) {
				if (historyWritten[i][j]) { // 기록이 됐을 때
					if (j % 2 == 0) { // 1차 시도
						if (history[i][j] == 10) // 스트라이크
							System.out.printf(" X ", history[i][j]);
						else
							System.out.printf(" %d ", history[i][j]);
					} else { // 2차 시도
						if (history[i][j] + history[i][j-1] == 10) // 스페어
							System.out.printf(" / ");
						else
							System.out.printf(" %d ", history[i][j]);
					}
				} else
					System.out.printf("   ");
			}
			System.out.println();
			System.out.print("      ");
			
			// 프레임 획득 점수
			for (int j = 0; j < 10; j++) {
				if (bonus[i][j] == 0)
					System.out.printf("  %-3d ", sumScoreTo(i, j));
				else
					System.out.printf("      ");
			}
			System.out.println();
			
			// 플레이어 구분선
			if (i == 0) {
				System.out.println("---------------------------------------------------------------------");
			}
		}
		System.out.println("=====================================================================");
	}
}