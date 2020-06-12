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

public class Pins {
	
	private boolean[] pinState = new boolean[10]; // 서있는 경우  true, 쓰러져있을 경우 false
	
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
			// 각 줄의 시작 공백 처리
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
